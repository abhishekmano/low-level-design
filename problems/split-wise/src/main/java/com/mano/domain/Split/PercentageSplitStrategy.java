package com.mano.domain.Split;

import java.util.List;

import com.mano.domain.Expense;

public class PercentageSplitStrategy implements SplitStrategy{

    @Override
    public void updateSplit(Expense expense) {
        double amount = expense.getValue();
        List<Split> splits = expense.getSplits();
        int total = splits.size();

        for(int idx = 0 ; idx < total ; ++idx){
            Split split = splits.get(idx);
            int percentage = split.getPercentage();
            double share = amount * percentage / 100;
            split.setAmount(share);
        }
    }
    
}
