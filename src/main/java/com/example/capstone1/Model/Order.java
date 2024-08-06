package com.example.capstone1.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Order {

    @NotNull(message = "orderId should be not Null!")
    private int orderId;

    @NotNull(message = "userId should be not Null!")
    private int userId;

    @NotNull(message = "productId should be not Null!")
    private int productId;

    @NotNull(message = "merchantId should be not Null!")
    private int merchantId;

    @NotNull(message = "Price should be Not Null!")
    @Positive(message = "Price must be a number")
    private double price;

    @NotNull(message = "discount should be Not Null!")
    private double discount;
}

