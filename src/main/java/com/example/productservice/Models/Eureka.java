package com.example.productservice.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "eureka")
public class Eureka extends BaseModel {
    private String title;
    private double price;

    @Getter
    @Setter
    private String email;



}