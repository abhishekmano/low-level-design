package com.mano.domain;

import java.util.ArrayList;
import java.util.List;

import com.mano.domain.Split.Split;
import com.mano.domain.Split.SplitStrategy;

import lombok.Data;

@Data
public class Expense {
    private int id ;
    private String name ;
    private String notes ;
    private double value ;
    private User paidBy;
    private List<Split> splits; 
    private SplitStrategy strategy;
    public Expense(SplitStrategy strategy){
        splits = new ArrayList<>();
        this.strategy = strategy;
    }
    public void addSplit(Split split){
        splits.add(split);
    }
    public void calculateSplit(){
        strategy.updateSplit(this);
    }

}
