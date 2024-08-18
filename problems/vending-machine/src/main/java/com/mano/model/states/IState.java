package com.mano.model.states;

import com.mano.model.Product;

public interface IState {
    public void selectProduct(Product product);
    public void insertMoney();
    public void dispense();
    public void returnChange();
}
