package com.example.capstone1.Controller;

import com.example.capstone1.Api.ApiResponse;
import com.example.capstone1.Model.OrderComment;
import com.example.capstone1.Model.User;
import com.example.capstone1.Service.CommentService;
import com.example.capstone1.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    ArrayList<OrderComment> comments = new ArrayList<OrderComment>();

    private final OrderService orderService;
    private final CommentService commentService;

    @PostMapping("/add/comment/{orderId}/{comment}")
    public ResponseEntity addComment(@PathVariable int orderId, @PathVariable String comment) {
       if(!orderService.isOrderExist(orderId)){
           String message = "Order id " + orderId + " does not exist";
           return ResponseEntity.status(404).body(message);

       }
      commentService.AddComment(new OrderComment(comment, orderId));
       return ResponseEntity.status(200).body("Comment added");
    }

    @GetMapping("/get/comment/{orderId}")
    public ResponseEntity getComment(@PathVariable int orderId) {
        if(!orderService.isOrderExist(orderId)){
            String message = "Order id " + orderId + " does not exist";
            return ResponseEntity.status(404).body(message);
        }
        ArrayList<OrderComment> comments = commentService.getComments(orderId);
        return ResponseEntity.status(200).body(comments);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable int id , @Valid @RequestBody OrderComment orderComment, Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = commentService.updateComment(id,orderComment);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Comment Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Comment not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable int id) {
        boolean isDeleted= commentService.deleteComment(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Comment Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Comment not found"));
    }


}
