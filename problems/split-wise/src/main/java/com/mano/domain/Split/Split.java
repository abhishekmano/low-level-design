package com.mano.domain.Split;

import com.mano.domain.User;

import lombok.Data;

@Data
public class Split {
    private int id;
    private User user ;
    private double amount ; 
    private int percentage;
    public Split(){

    }
    public Split(int id ,User user , double amount ){
        this.id = id;
        this.user = user;
        this.amount = amount ;
    }
    public Split(int id ,User user , double amount , int percentage){
        this.id = id;
        this.user = user;
        this.amount = amount ;
        this.percentage = percentage;
    }

}
