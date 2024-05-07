package com.example.productservice.Services;

import com.example.productservice.Dto.EurekaDto;
import com.example.productservice.Dto.ProductRequestDto;
import com.example.productservice.Dto.ProductResponseDto;
import com.example.productservice.Models.Categories;
import com.example.productservice.Models.Eureka;
import com.example.productservice.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@Service
public class FakeStoreProductService implements IProductService {
    @Autowired
    RestTemplate restTemplate;


    ProductResponseDto productResponseDto;
    ProductRequestDto productRequestDto;
    public Product getSingleProduct(Long id)
    {
        ProductResponseDto responseDto= restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductResponseDto.class);
        assert responseDto != null;
        return getProductFromResponseDto(responseDto);
    }
    public  List<Product> getAllProducts()
    {
        ProductResponseDto[] responseDto= restTemplate.getForObject("https://fakestoreapi.com/products",
                                                                           ProductResponseDto[].class);
        List<Product> products = new ArrayList<>();
        assert responseDto != null;
        for(ProductResponseDto productResponseDto: responseDto)
        {
            products.add(getProductFromResponseDto(productResponseDto));
        }
        return products;
    }
    public Product putProduct(ProductRequestDto product, Long id)
    {
         restTemplate.put("https://fakestoreapi.com/products/"+id,product, ProductResponseDto.class);
          ProductResponseDto responseDto= restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductResponseDto.class);
        assert responseDto != null;
        return getProductFromResponseDto(responseDto);
    }


    @Override
    public Product addProduct(ProductResponseDto product) {

     ProductResponseDto responseDto= restTemplate.postForObject("https://fakestoreapi.com/products", product, ProductResponseDto.class);
        assert responseDto != null;

        return getProductFromResponseDto(responseDto);

    }
    public  Product updateProduct(ProductRequestDto product, Long id)
    {
        RequestCallback requestCallback =restTemplate.httpEntityCallback(productRequestDto,ProductResponseDto.class);
        HttpMessageConverterExtractor<ProductResponseDto> responseExtractor =
                new HttpMessageConverterExtractor<>(ProductResponseDto.class,restTemplate.getMessageConverters());
      ProductResponseDto responseDto= restTemplate.execute("https://fakestoreapi.com/products/"+id,
                                                  HttpMethod.PUT, requestCallback, responseExtractor);
        assert responseDto != null;
        return  getProductFromResponseDto(responseDto);
    }
    public List<Product> limitProductList(int limit)
    {
        ProductResponseDto[] responseDto= restTemplate.getForObject("https://fakestoreapi.com/products?limit="+limit, ProductResponseDto[].class);
        List<Product> products = new ArrayList<>();
        assert responseDto != null;
        for(ProductResponseDto productResponseDto: responseDto)
        {
            products.add(getProductFromResponseDto(productResponseDto));
        }
        return products;
    }

    @Override
    public Eureka createProduct(EurekaDto product) {
        return null;
    }

    public Product getProductFromResponseDto(ProductResponseDto responseDto)
    {
        Product product = new Product();
        product.setId(responseDto.getId());

        product.setTitle(responseDto.getTitle());
        product.setDescription(responseDto.getDescription());
        product.setPrice(responseDto.getPrice());
        product.setImage(responseDto.getImage());

        Categories category = new Categories();
        category.setName(responseDto.getCategory());
        product.setCategory(category);
        return product;
    }




    }

