package com.example.productservice.Controllers;

import com.example.productservice.Dto.LoginRequestDto;
import com.example.productservice.Dto.SignupResquestDto;
import com.example.productservice.Models.Token;
import com.example.productservice.Models.User;
import com.example.productservice.Services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/signup")
    public User signUp(@RequestBody SignupResquestDto signupResquestDto) throws JsonProcessingException {
        return userService.signUp(signupResquestDto.getUsername(), signupResquestDto.getPassword(), signupResquestDto.getEmail());
    }
    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto loginRequestDto)
    {
        return userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
    }

}
