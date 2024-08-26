package com.mano;

public class Main {
    public static void main(String[] args) {
        State state = new State(PrinterType.EVEN);
        Printer evenPrinter = new Printer(2,PrinterType.EVEN , PrinterType.ODD , 0 , 10 , state);
        Printer oddPrinter = new Printer(2,PrinterType.ODD , PrinterType.EVEN , 1 , 10 , state);
        Thread first = new Thread(evenPrinter);
        Thread second = new Thread(oddPrinter);
        first.start();
        second.start();
    }
}