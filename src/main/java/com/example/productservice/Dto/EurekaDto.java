package com.example.productservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EurekaDto {
    private String title;
    private double price;
    private String email;

    public Object getProductName() {
            return null;
    }

    public Object getProductDescription() {
        return null;
    }
}
