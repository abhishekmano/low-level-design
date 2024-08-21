package com.mano.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import lombok.Data;

@Data
public class Group {
    private int groupId;
    private String groupName;
    private String groupDescription;
    private HashSet<User> users;
    private HashSet<User> admins;
    private List<Expense> expenses;
    public Group(){
        users = new HashSet<>();
        admins = new HashSet<>();
        expenses = new ArrayList<>();
    }
    public Group(int id , String name , String desc){
        this();
        groupDescription = desc;
        groupName = name ;
        groupDescription = desc;
    }
    public void addExpense(Expense expense){
        expenses.add(expense);
    }
    public void addUser(User user){
        users.add(user);
    }
    public void removeUser(User user){
        if(users.contains(user)){
            users.remove(user);
        }
    }
    public void addAdmin(User user){
        admins.add(user);
    }
    public void removeAdmin(User user){
        if(admins.contains(user)){
            admins.remove(user);
        }
    }

}
