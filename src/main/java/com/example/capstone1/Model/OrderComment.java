package com.example.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderComment {

@NotEmpty(message = "Comment should be not empty!")
@Size(min = 50,message = "maximum character in comments is 50")
    private String comment;

@NotNull(message = "OrderId should be not null!")
    private int orderId;

}
