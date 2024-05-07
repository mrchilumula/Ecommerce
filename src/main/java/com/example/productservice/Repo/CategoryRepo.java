package com.example.productservice.Repo;

import com.example.productservice.Models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Categories, Long>

{
Categories save(Categories category);
 Optional<Categories> findByName(String name);
}
