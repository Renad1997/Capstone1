package com.example.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {

@NotNull(message = "Id should be Not Null!")
    private int id;

@NotEmpty(message = "Name should be not Empty!")
@Size(min = 3 , message = "Name should be more than 3 characters")
    private String name;

@NotNull(message = "Price should be Not Null!")
@Positive(message = "Price must be a number")
    private double price;

@NotNull(message = "CategoryID should be Not Null!")
    private int categoryId;





}
