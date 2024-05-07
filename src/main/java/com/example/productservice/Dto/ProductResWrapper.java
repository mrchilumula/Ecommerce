package com.example.productservice.Dto;

import com.example.productservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductResWrapper {
    public ProductResWrapper(Product product, String productFound) {
        this.product = product;
        this.message = productFound;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Product product;
    public String message;
}
