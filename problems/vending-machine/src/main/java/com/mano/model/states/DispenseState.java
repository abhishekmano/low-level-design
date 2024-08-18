package com.mano.model.states;

import com.mano.model.ProductGroup;
import com.mano.model.currency.currency;

public class DispenseState implements IState {

    @Override
    public void selectProduct(ProductGroup product, int count) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectProduct'");
    }

    @Override
    public void insertMoney(currency currency) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertMoney'");
    }

    @Override
    public void dispense() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispense'");
    }

    @Override
    public void returnChange(currency currency) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnChange'");
    }

    @Override
    public void cancel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancel'");
    }

    @Override
    public void insertMoneyButton() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertMoneyButton'");
    }

    @Override
    public void selectProductButton() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectProductButton'");
    }
    
}
