package com.example.capstone1.Service;

import com.example.capstone1.Model.Order;
import com.example.capstone1.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

    private final ProductService productService;

    ArrayList<Order> orders = new ArrayList<Order>();

    private  MerchantService merchantService;
    private UserService userService;
    private MerchantStockService merchantStockService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }


    public ArrayList<Order> getOrder() {
        return orders;
    }


    public void addOrder(Order order) {
        orders.add(order);
    }

    public boolean updateOrder(int id, Order order) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId() == id) {
                orders.set(i, order);
                return true;
            }
        }
        return false;
    }

    public boolean deleteOrder(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId() == id) {
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    public int buyProduct(int userId, int productId, int merchantId) {
        if (!userService.isUserExist(userId)){
            return 4;
        }
        if (!merchantService.isMerchantExist(merchantId)){
            return 4;
        }
        if(!productService.isProductExist(productId)){
            return 4;
        }

        for (int i = 0; i <productService.products.size(); i++) {
            if (merchantStockService.merchantStockList.get(i).getProductId() == productId) {
                if (merchantStockService.merchantStockList.get(i).getStock() >= 1) {
                    merchantStockService.merchantStockList.get(i).setStock(merchantStockService.merchantStockList.get(i).getStock() - 1);
                    int transportFee = 30;
                    if (userService.users.get(i).getBalance() >= (productService.products.get(i).getPrice() + transportFee)) {

                        if(userService.isUserPrime(userId))
                        {
                            transportFee = 0;
                        }
                        userService.users.get(i).setBalance(userService.users.get(i).getBalance() - (productService.products.get(i).getPrice() + transportFee));
                        return 5;
                    }

                    return 1;
                }
                return 2;
            }


            return 3;
        }
        return 4;
    }

    public boolean isOrderExist(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId() == id) {

                return true;
            }
            }

        return false;
    }

    public Order find(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId() == id) {

                return orders.get(i);
            }
        }
        return null;
    }
    public int findIndex(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId() == id) {

                return i;
            }
        }
        return -1;
    }

}
