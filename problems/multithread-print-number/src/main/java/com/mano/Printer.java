package com.mano;

import lombok.Data;
import lombok.SneakyThrows;


@Data
public class Printer implements Runnable {
    private final int step;
    private PrinterType currentPrinterType ;
    private PrinterType nextPrinterType ;
    private int value;
    private int maxValue;
    private final State state;
    public Printer(int step , PrinterType cPrinterType , PrinterType nPrinterType , int value , int maxValue , State state){
        this.state  = state;
        this.currentPrinterType = cPrinterType;
        this.nextPrinterType = nPrinterType;
        this.step = step;
        this.value = value;
        this.maxValue = maxValue;
    }
    @SneakyThrows
    @Override
    public void run() {
        while(value <= maxValue){
            synchronized(state){
                while(state.getNextPrinterType() != currentPrinterType){
                    state.wait();
                }
                System.out.println("Printer : " + currentPrinterType.toString() + " value :" + value);
                value += step;
                state.setNextPrinterType(nextPrinterType);
                state.notifyAll();
            }
        }
    }
    
}
