package com.example.productservice.Controllers;

import com.example.productservice.Dto.EurekaDto;
import com.example.productservice.Dto.ProductRequestDto;
import com.example.productservice.Dto.ProductResWrapper;
import com.example.productservice.Models.Categories;
import com.example.productservice.Models.Eureka;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.FakeStoreProductService;
import com.example.productservice.Services.SelfProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Setter
@Getter
@Controller
@RestController
public class ProductController {

  SelfProductService productService;
    RestTemplate restTemplate;
    FakeStoreProductService fakeStoreProductService;

    @Autowired
    ProductController(SelfProductService productService, RestTemplate restTemplate,FakeStoreProductService fakeStoreProductService  ) {
        this.productService = productService;
        this.restTemplate = restTemplate;
        this.fakeStoreProductService = fakeStoreProductService;

    }
    @GetMapping("/fakeproducts")
    public List<Product> getFakeProducts()
    {
        System.out.println("Getting fake products");
        return fakeStoreProductService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResWrapper> getSingleProduct(@PathVariable("id") Long id) throws Exception {

        Product Product = productService.getSingleProduct(id);
        ProductResWrapper productResWrapper = new ProductResWrapper(Product, "Product Found");
        return ResponseEntity.ok(productResWrapper);

    }

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {

        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequest) {
        Product product = new Product();
        product.setTitle(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setImage(productRequest.getImage());
        product.setCategory(new Categories());
        product.getCategory().setName(productRequest.getCategory());
          productService.addProduct(product);
        return product;
    }


   @PostMapping("/EurekaProducts")
    public Eureka createProduct(@RequestBody EurekaDto eureka)
   {
        return productService.createProduct(eureka);
    }


    @RequestMapping("/dummy")
    public void dummyApi() {
        String answer =
                restTemplate.getForObject("http://USERSERVICE/hi", String.class);

        System.out.println(answer);
    }







//    @PutMapping("/products/{id}")
//    public Product updateProduct(@RequestBody ProductRequestDto product, @PathVariable("id") Long id)
//    {
//       return productService.updateProduct(product,id);
//    }
//
//        @PutMapping("/products/{id}")
//        public Product putProduct (@RequestBody ProductRequestDto product, @PathVariable("id") Long id)
//        {
//            return productService.putProduct(product, id);
//        }
//
//        @GetMapping("/products/limit/{limit}")
//        public List<Product> limitProductlist ( @PathVariable("limit") int limit)
//        {
//            return productService.limitProductList(limit);
//        }
    }

