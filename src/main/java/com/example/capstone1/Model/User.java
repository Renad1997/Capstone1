package com.example.capstone1.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
public class User {

    @NotNull(message = "Id should be not Null!")
    private int id;

    @NotEmpty(message = "username should be not Empty!")
    @Size(min = 5,message = "username have to be more than 5 characters")
    private String username;

    @NotEmpty(message = "password should be not Empty!")
    @Size(min = 6,message = "have to be more than 6 , must have characters and digits")
    @Pattern(regexp = "(^(?:(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*)[^\\s]{8,}$)",message = "")
    private String password;

    @NotEmpty(message = "Email should be not empty!")
    @Email(message = "Email must be valid email")
    private String email;

    @NotEmpty(message = "Role should be not empty!")
    @Pattern(regexp="^(Admin|Customer)$",message = "Role must to be Admin or Customer")
    private String role;

    @NotNull(message = "Balance should be not Null!")
    @Positive(message = "Balance have to be positive")
    private double balance;

    @AssertFalse
    private boolean isPrimary;



}
