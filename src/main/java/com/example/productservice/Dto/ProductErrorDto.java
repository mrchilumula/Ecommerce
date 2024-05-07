package com.example.productservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductErrorDto {
    private String message;

    public ProductErrorDto(String arithmeticException) {
        this.message = arithmeticException;
    }
}
