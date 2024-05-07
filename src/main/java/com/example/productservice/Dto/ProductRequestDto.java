package com.example.productservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter



public class ProductRequestDto {

    private String name;
    private int price;
    private String description;
    private String image;

    private String category;

    public Long getId() {
            return null;
    }


    // title: 'test product',
    //price: 13.5,
    //description: 'lorem ipsum set',
   //  image: 'https://via.placeholder.com/150',
    //category: 'test category'
}
