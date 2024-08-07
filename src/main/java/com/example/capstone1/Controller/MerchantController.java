package com.example.capstone1.Controller;

import com.example.capstone1.Api.ApiResponse;
import com.example.capstone1.Model.Category;
import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchant() {
        ArrayList<Merchant> merchants = merchantService.getMerchant();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable int id ,@Valid @RequestBody Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantService.updateMerchant(id,merchant);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Merchant Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Merchant not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable int id) {
        boolean isDeleted= merchantService.deleteMerchant(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Merchant Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Merchant not found"));
    }

    @PutMapping("/update/rate/{rate}/{merchantId}")
    public ResponseEntity updateMerchantRate(@PathVariable double rate,@PathVariable int merchantId){
        if(!merchantService.isMerchantExist(merchantId)){
            return ResponseEntity.status(404).body(new ApiResponse("Merchant not found"));
        }
        merchantService.merchantRate(rate,merchantId);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant Rate Updated"));
    }


}
