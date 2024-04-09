package com.scaler.firstspringapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    private String image;
    @ManyToOne
    @JoinColumn
    private Category category;
}

/*
  1      ->         1
Product -------- Category ==> M:1
  M          <-     1
==========================
   M               1

  1                 M
Movie ------------ Actor ==> M:M
  M                  1


 */
