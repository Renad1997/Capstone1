package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStockList = new ArrayList<MerchantStock>();

    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStockList;
    }

    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStockList.add(merchantStock);
    }

    public boolean updateMerchantStock(int id ,MerchantStock merchantStock) {
        for (int i = 0; i < merchantStockList.size(); i++) {
            if (merchantStockList.get(i).getId()==id) {
                merchantStockList.set(i, merchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(int id ){
        for (int i = 0; i < merchantStockList.size(); i++) {
            if (merchantStockList.get(i).getId()==id) {
                merchantStockList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean ProductReStock(int ProdcutId , int merchantId , int amount) {
        for (int i = 0; i < merchantStockList.size(); i++) {
            if (merchantStockList.get(i).getProductId()==ProdcutId && merchantStockList.get(i).getMerchantId()==merchantId){
                merchantStockList.get(i).setStock(merchantStockList.get(i).getStock() + amount);
                return true;
            }
        }
        return false;
  }



}
