package com.example.productservice.Services;

import com.example.productservice.Dto.EurekaDto;
import com.example.productservice.Dto.ProductRequestDto;
import com.example.productservice.Dto.ProductResponseDto;
import com.example.productservice.Models.Categories;
import com.example.productservice.Models.Eureka;
import com.example.productservice.Models.Product;
import com.example.productservice.Repo.CategoryRepo;
import com.example.productservice.Repo.ProductServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@Qualifier("SelfProductService")
public class SelfProductService implements IProductService {
    ProductServiceRepo productServiceRepo;
    CategoryRepo categoryRepo;

    @Autowired
    public SelfProductService(ProductServiceRepo productServiceRepo, CategoryRepo categoryRepo) {
        this.productServiceRepo = productServiceRepo;
        this.categoryRepo = categoryRepo;
    }

    public void addProduct(Product product) {
        Optional<Categories> categoryOptional = categoryRepo.findByName(product.getCategory().getName());
        if (categoryOptional.isEmpty()) {
            Categories category = new Categories();
            category.setName(product.getCategory().getName());
            categoryRepo.save(category);
        } else {
            product.setCategory(categoryOptional.get());
        }
        productServiceRepo.save(product);


    }

    public Product getProductById(Long id) {
        return productServiceRepo.findById(id).orElse(null);
    }

    @Override
    public Product getSingleProduct(Long id) throws Exception {
        return productServiceRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addProduct(ProductResponseDto product) {
        return null;
    }

    @Override
    public Product updateProduct(ProductRequestDto product, Long id) {
        return null;
    }

    @Override
    public Product putProduct(ProductRequestDto product, Long id) {
        return null;
    }

    @Override
    public List<Product> limitProductList(int limit) {
        return List.of();
    }

    @Override
    public Eureka createProduct(EurekaDto product) {
        RestTemplate restTemplate = new RestTemplate();
        Boolean entity = restTemplate.getForObject("http://USERSERVICE:8051/emails/" + product.getEmail(), Boolean.class);
        Eureka eureka1 = new Eureka();
        eureka1.setEmail(product.getEmail());
        eureka1.setTitle(product.getTitle());
        eureka1.setPrice(product.getPrice());
        productServiceRepo.save(eureka1);

        return eureka1;
    }
}




