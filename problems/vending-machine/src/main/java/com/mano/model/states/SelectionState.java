package com.mano.model.states;

import java.util.HashMap;

import com.mano.model.ProductGroup;
import com.mano.model.VendingMachine;
import com.mano.model.currency.currency;

public class SelectionState implements IState {
    private VendingMachine vendingMachine;
    public SelectionState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(ProductGroup product, int count) {
        vendingMachine.setSelectedProduct(product);
        vendingMachine.setSelectedCount(count);
    }

    @Override
    public void insertMoney(currency currency) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertMoney'");
    }

    @Override
    public void dispense() {
        int totalProductMoney = vendingMachine.getSelectedProduct().getPrice() * vendingMachine.getSelectedCount();
        int totalInsertedMoney = vendingMachine.getCurrencyManager().getTotalUserMoney();
        if(totalProductMoney > totalInsertedMoney){
            cancel();
        }
        else{
            System.out.println("Dispensing the product");
            // add the user currency to the existing list and return the extra amount 
            //call the vending machine helper to reduce the item count 
            vendingMachine.setSelectedCount(0);
            vendingMachine.setSelectedProduct(null);
            vendingMachine.setState(new IdleState(vendingMachine));
        }

    }

    @Override
    public void returnChange(currency currency) {
        System.out.println("Returning the money " + currency.getValue());
        
    }

    @Override
    public void cancel() {
        System.out.println("Cancelling Order");
        var userCash = vendingMachine.getCurrencyManager().getCurrentUserMoney();
        for (var pair : userCash.values()) {
            for(currency note : pair){
                returnChange(note);
            }
        }
        vendingMachine.getCurrencyManager().setCurrencies(new HashMap<>());
        vendingMachine.getCurrencyManager().setTotalUserMoney(0);
        vendingMachine.setSelectedProduct(null);
        vendingMachine.setSelectedCount(0);
        vendingMachine.setState(new IdleState(vendingMachine));
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
