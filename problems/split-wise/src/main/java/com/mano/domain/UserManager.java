package com.mano.domain;

import java.util.HashSet;

public class UserManager {
    HashSet<User> users ;
    public void addUser(User user){
        users.add(user);
    }
    public void removeUser(User user){
        if(users.contains(user)){
            users.remove(user);
        }
    }
}
