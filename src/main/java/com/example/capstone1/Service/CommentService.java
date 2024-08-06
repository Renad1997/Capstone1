package com.example.capstone1.Service;

import com.example.capstone1.Model.Order;
import com.example.capstone1.Model.OrderComment;
import com.example.capstone1.Model.User;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CommentService {

    ArrayList<OrderComment> comments = new ArrayList<OrderComment>();


    public ArrayList<OrderComment> getComments(int OrderId) {
        ArrayList<OrderComment> temp = new ArrayList<>();
     for (int i = 0; i < comments.size(); i++) {
         if (comments.get(i).getOrderId() == OrderId) {
             temp.add(comments.get(i));

         }
     }
     return temp;
    }
    public void AddComment(OrderComment comment) {
        comments.add(comment);

    }

    public boolean updateComment(int id ,OrderComment comment ) {
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getOrderId() == id) {
                comments.set(i,comment);
                return true;
            }
        }
        return false;
    }

    public boolean deleteComment(int id) {
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getOrderId() == id) {
                comments.remove(i);
                return true;
            }
        }
        return false;
    }


}
