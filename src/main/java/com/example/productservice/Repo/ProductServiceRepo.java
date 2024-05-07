package com.example.productservice.Repo;

import com.example.productservice.Models.Eureka;
import com.example.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductServiceRepo extends JpaRepository<Product, Long> {

    public Product findByTitle(String title);
    public Product findByPrice(double price);

    public Product findById(long id );

    public Product save(Product product);

    void save(Eureka eureka1);
}
