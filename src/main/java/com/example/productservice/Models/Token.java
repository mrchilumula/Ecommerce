package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter

public class Token extends BaseModel{
    @ManyToOne
    private User user;
    private String token;
    private Boolean isActive;
    private Date expiryDate;

    public void setExpireAt(Date expiredDate) {

    }
}
