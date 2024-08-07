package com.example.capstone1.Service;

import com.example.capstone1.Model.Category;
import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<Merchant>();

    public  ArrayList<Merchant> getMerchant() {
        return merchants;
    }

    public void addMerchant(Merchant merchant) {
        merchants.add(merchant);
    }

    public boolean updateMerchant(int id ,Merchant merchant) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId()==id) {
                merchants.set(i, merchant);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchant(int id ){
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId()==id) {
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean isMerchantExist(int id) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId()==id) {

                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    public Merchant find(int id) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId()==id) {

                return merchants.get(i);
            }else {
                return null;
            }
        }
        return null;
    }
    public void merchantRate(double rate,int merchantId) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId()==merchantId) {
                double newRate=(rate+merchants.get(i).getRate())/2;
                merchants.get(i).setRate(newRate);
            }
        }
    }


}
