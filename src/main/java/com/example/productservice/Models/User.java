package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter

public class User extends BaseModel {
    private String username;
    private String Password;
    private String email;
    private String Role;
    @ManyToMany
    private List<Roles> roles;
   private Boolean isActive;

    public User(String username, String password, String email) {
        username = username;
        Password = password;
        email = email;
    }

    public User() {

    }
}
