package com.mano.model.states;

import java.util.List;

import com.mano.model.ProductGroup;
import com.mano.model.VendingMachine;
import com.mano.model.currency.currency;

public class HasMoneyState implements IState{
    private VendingMachine vendingMachine;
    public HasMoneyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(ProductGroup product, int count) {
        vendingMachine.setSelectedProduct(product );
        vendingMachine.setSelectedCount(count);
    }

    @Override
    public void insertMoney(currency currency) {
       vendingMachine.getCurrencyManager().insertMoney(currency);
    }

    @Override
    public void dispense() {
        //
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
        vendingMachine.setState(new SelectionState(vendingMachine));
    }
    
}
