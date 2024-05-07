package com.example.productservice.Services;

import com.example.productservice.Dto.EurekaDto;
import com.example.productservice.Dto.ProductRequestDto;
import com.example.productservice.Dto.ProductResponseDto;
import com.example.productservice.Models.Eureka;
import com.example.productservice.Models.Product;

import java.util.List;

public interface IProductService {
    public Product getSingleProduct(Long id) throws Exception;

   List<Product> getAllProducts();


    Product addProduct(ProductResponseDto product);

    Product updateProduct(ProductRequestDto product, Long id);
    Product putProduct(ProductRequestDto product, Long id);

    List<Product> limitProductList(int limit);

    Eureka createProduct(EurekaDto product);
}
