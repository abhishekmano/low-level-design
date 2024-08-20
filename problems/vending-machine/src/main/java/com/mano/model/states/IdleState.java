package com.mano.model.states;

import java.util.List;

import com.mano.model.ProductGroup;
import com.mano.model.VendingMachine;
import com.mano.model.currency.currency;

public class IdleState implements IState {
    private VendingMachine vendingMachine;
    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(ProductGroup product, int count) {
        
    }

    @Override
    public void insertMoney(currency currency) {
        System.out.println("Please insert money after clicking insert button");
        
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
        vendingMachine.setState(new HasMoneyState(vendingMachine));
    }
    @Override
    public void selectProductButton() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectProductButton'");
    }
    
}
