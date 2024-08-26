package com.mano;

import lombok.Data;

@Data
public class State {
    private PrinterType nextPrinterType;
    public State(PrinterType type){
        this.nextPrinterType = type;
    }
}
