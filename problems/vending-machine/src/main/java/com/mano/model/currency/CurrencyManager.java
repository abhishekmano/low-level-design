package com.mano.model.currency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

@Data
public class CurrencyManager {
    private HashMap<Integer,List<currency>> currencies ;
    private HashMap<Integer,List<currency>> currentUserMoney ;
    private int totalUserMoney;
    public CurrencyManager(){
        currencies = new HashMap<>();
        currentUserMoney = new HashMap<>();
        totalUserMoney = 0;
    }
    public void insertMoney(currency currency){
        int value = currency.getValue();
        if(!currentUserMoney.containsKey(value)){
            currentUserMoney.put(value, new ArrayList<>()) ;
        }
        currentUserMoney.get(value).add(currency);
        totalUserMoney += currency.getValue();
    }
}
