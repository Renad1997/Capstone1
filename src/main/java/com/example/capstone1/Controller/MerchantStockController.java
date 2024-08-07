package com.example.capstone1.Controller;

import com.example.capstone1.Api.ApiResponse;
import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantStock")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStock() {
        ArrayList<MerchantStock> merchantStockList = merchantStockService.getMerchantStock();
        return ResponseEntity.status(200).body(merchantStockList);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant Stock Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable int id ,@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantStockService.updateMerchantStock(id,merchantStock);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Merchant Stock Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Merchant Stock not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id) {
        boolean isDeleted= merchantStockService.deleteMerchantStock(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Merchant Stock Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Merchant Stock not found"));
    }

    @PutMapping("/restock/{ProdcutId}/{merchantId}/{amount}")
    public ResponseEntity ProductReStock(@PathVariable int ProdcutId, @PathVariable int merchantId, @PathVariable int amount) {
        boolean isRestock= merchantStockService.ProductReStock(ProdcutId,merchantId,amount);
        if (isRestock) {
            return ResponseEntity.status(200).body(new ApiResponse("Product ReStock Successful"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Product ReStock not found"));
    }

}
