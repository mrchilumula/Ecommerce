package com.example.productservice.ControllerAdvice;

import com.example.productservice.Dto.ProductErrorDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Setter
@Getter
@RestControllerAdvice
public class GlobalControllerExpectionAdvice {

 @ExceptionHandler(Exception.class)
    public ResponseEntity<ProductErrorDto> handleArithmeticException()
    {
        return new ResponseEntity<>(new ProductErrorDto("Something Wrong"), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

