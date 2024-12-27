package com.scaler.firstspringapi.controllers;

import com.scaler.firstspringapi.configs.commons.AuthCommon;
import com.scaler.firstspringapi.dtos.ProductResponseDto;
import com.scaler.firstspringapi.dtos.UserDto;
import com.scaler.firstspringapi.exceptions.ProductNotFoundException;
import com.scaler.firstspringapi.models.Product;
import com.scaler.firstspringapi.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

//localhost:8080/products
@RestController //This controller is going to REST HTTP API's
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private AuthCommon authCommon;

    public ProductController(@Qualifier("selfProductService") ProductService productService,AuthCommon authCommon) {
        this.productService = productService;
        this.authCommon = authCommon;
    }

    //localhost:8080/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        // UserDto userDto = authCommon.validateToken(token);
        ResponseEntity<Product> responseEntity;
        // if (userDto == null) {
        //     System.out.println("user is not authenticated");
        //     responseEntity = new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
        //     return responseEntity;
        // }
        Product product = productService.getProductById(id);
//        if (product == null) {
//            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            return responseEntity;
//        }

//        Product sampleProduct = new Product();

        responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;

//        ResponseEntity<Product> responseEntity = null;
//        try {
//            Product product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (ArithmeticException e) {
//            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        //Controllers should be as light as possible.
//        return responseEntity;
        //throw new RuntimeException("Something went wrong");
    }

    // localhost:8080/products
    @GetMapping()
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber,@RequestParam("pageSize") int pageSize) {

//        List<Product> products = productService.getAllProducts();
//        List<ProductResponseDto> productResponseDtos=new ArrayList<>();
//        for(Product product:products){
//            productResponseDtos.add(ProductResponseDto.from(product));
//        }
//        return productResponseDtos;
         return productService.getAllProducts(pageNumber,pageSize);
    }

    //createProduct
    //deleteProduct
    //updateProduct -> Partial Update (PATCH)
    //replaceProduct -> Replace (PUT)

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Void> handleSomeException() {
        return null;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) { // can use DTO as well.
        return productService.createProduct(product);
    }
}
