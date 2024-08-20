package com.mano.domain;

import lombok.Data;

@Data
public class Like {
    private User likedBy;
    public Like(User user){
        likedBy = user;
    }
    public void display(){
        System.out.println("\t Liked By " +  likedBy.getUserName());
    }
}
