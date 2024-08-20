package com.mano.domain;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String userName;
    private String userMail;
    public User(){

    }
    public User(int id , String userName , String userMail){
        this.userId = id;
        this.userName = userName;
        this.userMail = userMail;
    }
}
