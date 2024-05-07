package com.example.productservice.Dto;

public class SignupResquestDto {
    private String username;
    private String password;
    private String email;

    public SignupResquestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
