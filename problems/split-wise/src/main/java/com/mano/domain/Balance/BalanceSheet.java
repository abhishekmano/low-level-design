package com.mano.domain.Balance;

import java.util.HashMap;

import com.mano.domain.User;
import com.mano.domain.Split.Split;

import lombok.Data;

@Data
public class BalanceSheet {
    private HashMap<User, Balance> balances ;
    private int totalOwe;
    private int totalGetBack;
    public BalanceSheet(){
        balances = new HashMap<>();
    }
    public void addNewOwe(Split split, User owner){
        if(!balances.containsKey(owner)){
            Balance newBalance = new Balance();
            balances.put(owner, newBalance);
        }
        balances.get(owner).addToOwe(split.getAmount());
        totalOwe += split.getAmount();
    }
    public void addNewGetBack(Split split){
        if(!balances.containsKey(split.getUser())){
            Balance newBalance = new Balance();
            balances.put(split.getUser(), newBalance);
        }
        balances.get(split.getUser()).addToGetBack(split.getAmount());
        totalGetBack += split.getAmount();
    }
}
