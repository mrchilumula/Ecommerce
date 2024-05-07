package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Categories extends BaseModel{

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @Setter
    @Getter
    private String name;

}
