package com.mano.domain.Balance;

import java.util.HashMap;

import com.mano.domain.User;
import com.mano.domain.Split.Split;

import lombok.Data;

@Data
public class BalanceSheet {
    private HashMap<Integer, Balance> balances ;
    private double totalOwe;
    private double totalGetBack;
    public BalanceSheet(){
        totalGetBack = 0;
        totalOwe = 0;
        balances = new HashMap<>();
    }
    public void addNewOwe(Split split, User owner){
        try{
            if(!balances.containsKey(owner.getUserId())){
                Balance newBalance = new Balance();
                balances.put(owner.getUserId(), newBalance);
            }
            Balance ownerBalance = balances.get(owner.getUserId());
            balances.get(owner.getUserId()).addToOwe(split.getAmount());
            totalOwe += split.getAmount();
        }
        catch(Exception ex){
            //handle

        }
        
    }
    public void addNewGetBack(Split split){
        if(!balances.containsKey(split.getUser().getUserId())){
            Balance newBalance = new Balance();
            balances.put(split.getUser().getUserId(), newBalance);
        }
        balances.get(split.getUser().getUserId()).addToGetBack(split.getAmount());
        totalGetBack += split.getAmount();
    }
    public void display(){
        System.out.println("Owes: " + totalOwe );
        System.out.println("Getback: " + totalGetBack );
    }
}
