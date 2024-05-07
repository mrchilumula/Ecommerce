package com.example.productservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponseDto {
    private Long id;
    private String title;
    private int price;
    private String description;
    private String image;
    private String category;


//    id:1,
//    title:'...',
//    price:'...',
//    description:'...',
//    image:'...'
//    category:'...',
}
