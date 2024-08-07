package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    ArrayList<Product> products = new ArrayList<Product>();

    private  MerchantService merchantService;
    private UserService userService;
    private MerchantStockService merchantStockService;


    public  ArrayList<Product> getProduct() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean updateProduct(int id ,Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==id) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id ) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean isProductExist(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()==id) {

                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductsByCategoryId(int categoryId) {
        ArrayList<Product> temp = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCategoryId()==categoryId) {
                temp.add(products.get(i));
            }
        }
        return temp;
    }

}
