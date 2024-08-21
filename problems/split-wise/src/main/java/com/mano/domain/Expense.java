package com.mano.domain;

import java.util.ArrayList;
import java.util.List;

import com.mano.domain.Split.Split;

import lombok.Data;

@Data
public class Expense {
    private int id ;
    private String name ;
    private String notes ;
    private double value ;
    private User paidBy;
    private List<Split> splits; 
    public Expense(){
        splits = new ArrayList<>();
    }
    public void addSplit(Split split){
        splits.add(split);
    }

}
