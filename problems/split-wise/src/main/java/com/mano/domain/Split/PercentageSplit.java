package com.mano.domain.Split;

import com.mano.domain.User;

import lombok.Data;

@Data
public class PercentageSplit extends Split{
    private int percentage;
    private int id;
    private User user ;
    private double amount ; 
    public PercentageSplit(int id ,User user , double amount ){
        this.id = id;
        this.user = user;
        this.amount = amount ;
    }
    public PercentageSplit(){}
    public PercentageSplit(int id , int percentage , User user , double amount ){
        this(id, user, amount);
        this.percentage = percentage;
    }
}
