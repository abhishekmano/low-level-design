package com.mano.model;

import com.mano.model.Button.InternalButton;

import lombok.Data;

@Data
public class ElevatorCar {
    private int carId ;
    private Display display;
    private int currentFloor;
    private Direction direction;
    private Status status;
    private InternalButton internalButton;
    public void move(int floorNumber){
        currentFloor = floorNumber;
        System.err.println("Elevator car " + carId + " moved from " + currentFloor + " to " + floorNumber) ;
    }

}
