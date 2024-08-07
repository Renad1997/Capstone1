package com.example.capstone1.Controller;

import com.example.capstone1.Api.ApiResponse;
import com.example.capstone1.Model.Order;
import com.example.capstone1.Model.User;
import com.example.capstone1.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity getOrder(){
        ArrayList<Order> orders  = orderService.getOrder();
        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@Valid @RequestBody Order order, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        orderService.addOrder(order);
        return ResponseEntity.status(200).body(new ApiResponse("Order Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable int id ,@Valid @RequestBody Order order, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = orderService.updateOrder(id,order);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Order Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Order not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable int id) {
        boolean isDeleted= orderService.deleteOrder(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Order Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Order not found"));
    }

    @PutMapping("/update/{userId}/{productId}/{merchantId}")
    public ResponseEntity buyProduct(@PathVariable int userId, @PathVariable int productId, @PathVariable int merchantId){

        int a = orderService.buyProduct(userId, productId, merchantId);
        if(a==1){
            return ResponseEntity.status(400).body(new ApiResponse("balance not enough"));
        }
        else if (a==2) {
            return ResponseEntity.status(400).body(new ApiResponse("product Not found in stock"));
        }
        else if (a==3) {
            return ResponseEntity.status(400).body(new ApiResponse("product id not found"));
        }
        else if (a==4) {
            return ResponseEntity.status(400).body(new ApiResponse("buy fail"));
        }
        else
            return ResponseEntity.status(200).body(new ApiResponse("buy Successfully"));

    }
}
