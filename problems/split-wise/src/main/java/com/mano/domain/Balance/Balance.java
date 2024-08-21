package com.mano.domain.Balance;

public class Balance {
    private double owe;
    private double getBack;
    public void addToOwe(double amount){
        owe+= amount;
    }
    public void addToGetBack(double amount){
        getBack += amount;
    }
}
