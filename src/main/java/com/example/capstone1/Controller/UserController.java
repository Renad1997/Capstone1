package com.example.capstone1.Controller;

import com.example.capstone1.Api.ApiResponse;
import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.User;
import com.example.capstone1.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        ArrayList<User> users  = userService.getUser();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id ,@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = userService.updateUser(id,user);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("User Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        boolean isDeleted= userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("User Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User not found"));
    }

    @PutMapping("/prime/{id}")
    public ResponseEntity chargePrime(@PathVariable int id){
        boolean isCharged= userService.chargePrime(id);
        if (isCharged) {
            return ResponseEntity.status(200).body(new ApiResponse("User Charged Successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User not found"));
    }
}
