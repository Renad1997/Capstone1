package com.example.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MerchantStock {

    @NotNull(message = "Id should be Not Null!")
    private int id;

    @NotNull(message = "productId should be not Null!")
    private int productId;

    @NotNull(message = "MerchantId should be Not Null!")
    private int merchantId;

    @NotNull(message = "Stock should be Not Null!")
    @Size(min = 10,message = "have to be more than 10 at start")
    private int stock;

}
