package com.mano.domain.Split;

import java.util.List;

import com.mano.domain.Expense;

public interface SplitStrategy {
    public void updateSplit(Expense expense);
}
