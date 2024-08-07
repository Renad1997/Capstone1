package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUser() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean updateUser(int id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean isUserExist(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {

                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public User find(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {

                return users.get(i);
            }
        }
        return null;
    }
    public int findIndex(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {

                return i;
            }
        }
        return -1;
    }

    public boolean isUserPrime(int id) {
   User user = find(id);
   if (user == null) {
       return false;
   }
   return user.isPrimary();

    }
    public boolean chargePrime(int id) {
        int userIndex = findIndex(id);
        if (userIndex == -1) {
            return false;
        }
        users.get(userIndex).setPrimary(true);
        return true;
    }

}
