package com.example.productservice.Repo;

import com.example.productservice.Models.Token;
import com.example.productservice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
@Repository
public interface TokenRepo  extends JpaRepository<Token, Long> {
    public Optional<Token> findByToken(String token);
    public Optional<Token> findByUser(User user);
    public Optional<Token> findByExpiryDate(Date date);





}
