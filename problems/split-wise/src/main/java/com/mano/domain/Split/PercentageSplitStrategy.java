package com.mano.domain.Split;

import java.util.List;

import com.mano.domain.Expense;
import com.mano.domain.User;

public class PercentageSplitStrategy implements SplitStrategy{

    @Override
    public void updateSplit(Expense expense) {
        double amount = expense.getValue();
        List<Split> splits = expense.getSplits();
        int total = splits.size();
        User owner = expense.getPaidBy();
        for (Split split : splits) {
            int percentage = split.getPercentage();
            double share = amount * percentage / 100;
            split.setAmount(share);
            if (split.getUser() != owner) {
                owner.getBalanceSheet().addNewGetBack(split);
                split.getUser().getBalanceSheet().addNewOwe(split, owner);
            }
        }
    }
    
}
