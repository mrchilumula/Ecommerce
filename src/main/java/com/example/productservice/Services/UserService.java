package com.example.productservice.Services;

import com.example.productservice.Dto.SendEmailMessageDto;
import com.example.productservice.Models.Token;
import com.example.productservice.Models.User;
import com.example.productservice.Repo.TokenRepo;
import com.example.productservice.Repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepo userRepo;
    @Autowired
    TokenRepo tokenRepo;
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper ;


    public User signUp(String username, String password, String email) throws JsonProcessingException {
        User user = new User(username, password, email);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       User savedUser= userRepo.save(user);
        SendEmailMessageDto sendEmailMessageDto = new SendEmailMessageDto();
        sendEmailMessageDto.setFrom("Karthik.chilumula1@gmail.com");
        sendEmailMessageDto.setTo(savedUser.getEmail());
        sendEmailMessageDto.setSubject("Welcome to our application");
        sendEmailMessageDto.setBody("Welcome to our application. Your account has been created successfully");
        try {
            kafkaTemplate.send("send_email", objectMapper.writeValueAsString(sendEmailMessageDto));
        }
        catch (JsonProcessingException e) {

        }


        return savedUser;

    }

    public Token login(String email, String password) {
        Optional<User> userOptional = userRepo.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid userOptional or password");
        }

        User user = userOptional.get();

        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid userOptional or password");
        }

        Token token = new Token();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());

        Date expiredDate = getExpiredDate();

        token.setExpireAt(expiredDate);

        return tokenRepo.save(token);
    }

    // expiration date will be 30 days after today.
    private Date getExpiredDate() {

        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(new Date());


        //add(Calendar.DAY_OF_MONTH, -5).
        calendarDate.add(Calendar.DAY_OF_MONTH, 30);

        return calendarDate.getTime();

    }

}
