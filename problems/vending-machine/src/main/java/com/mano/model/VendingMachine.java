package com.mano.model;

import java.util.List;

import com.mano.model.currency.CurrencyManager;
import com.mano.model.states.IState;
import com.mano.model.states.IdleState;

import lombok.Data;

@Data
public class VendingMachine {
    private List<Shelf> products;
    private ProductGroup selectedProduct;
    private int selectedCount;
    private IState state;
    private CurrencyManager currencyManager;
    VendingMachine(){
        state = new IdleState(this);   
    }
}
