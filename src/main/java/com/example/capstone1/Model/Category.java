package com.example.capstone1.Model;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Category {

    @NotNull(message = "Id should be Not Null!")
    private int id;

    @NotEmpty(message = "Name should be not Empty!")
    @Size(min = 3 , message = "Name should be more than 3 characters")
    private String name;

}
