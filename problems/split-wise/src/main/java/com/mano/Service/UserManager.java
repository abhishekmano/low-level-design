package com.mano.Service;

import java.util.HashSet;

import com.mano.domain.User;

public class UserManager {
    HashSet<User> users ;
    public  UserManager(){
        users = new HashSet<>();
    }
    public void addUser(User user){
        users.add(user);
    }
    public void removeUser(User user){
        if(users.contains(user)){
            users.remove(user);
        }
    }
    public void display(){
        for(User user : users){
            user.display();
        }
    }
}
