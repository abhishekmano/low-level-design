package com.mano.model.states;

import java.util.List;

import com.mano.model.Product;
import com.mano.model.ProductGroup;
import com.mano.model.currency.currency;

public interface IState {
    public void selectProduct(ProductGroup product , int count );
    public void insertMoneyButton();
    public void selectProductButton();
    public void insertMoney(currency currency);
    public void dispense();
    public void returnChange(currency currency);
    public void cancel();
}
