package com.mano.domain;

import com.mano.domain.Balance.BalanceSheet;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String userName;
    private String userMail;
    private BalanceSheet balanceSheet;
    public User(){
        balanceSheet = new BalanceSheet();
    }
    public User(int id , String userName , String userMail){
        this.userId = id;
        this.userName = userName;
        this.userMail = userMail;
    }
}
