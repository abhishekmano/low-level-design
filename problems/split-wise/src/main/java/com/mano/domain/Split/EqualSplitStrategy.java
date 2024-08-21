package com.mano.domain.Split;

import java.util.List;

import com.mano.domain.Expense;
import com.mano.domain.User;

public class EqualSplitStrategy implements SplitStrategy {
    public void updateSplit(Expense expense){
        double amount = expense.getValue();
        List<Split> splits = expense.getSplits();
        int total = splits.size();
        double perUserSplit = amount/total;
        User owner = expense.getPaidBy();
        for (Split split : splits) {
            split.setAmount(perUserSplit);
            if (split.getUser() != owner) {
                owner.getBalanceSheet().addNewGetBack(split);
                split.getUser().getBalanceSheet().addNewOwe(split, owner);
            }
        }
    }
}
