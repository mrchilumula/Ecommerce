package com.example.productservice.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name = "product")
public class Product extends BaseModel {
     @Setter
    private String title;
    @Setter
    private String description;

    @Setter
    private double price;
    private String image;
    @Setter
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Categories category;


    public void setImage(String image) {
    }

    public void setTitle(String title) {

    }

    public void setImageUrl(String image) {

    }
}
