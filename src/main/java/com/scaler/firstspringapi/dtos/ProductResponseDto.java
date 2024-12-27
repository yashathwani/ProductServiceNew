package com.scaler.firstspringapi.dtos;


import com.scaler.firstspringapi.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;

    public static ProductResponseDto from(Product product)
    {
        ProductResponseDto productDto=new ProductResponseDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategory(product.getCategory().getTitle());
        return productDto;
    }
}