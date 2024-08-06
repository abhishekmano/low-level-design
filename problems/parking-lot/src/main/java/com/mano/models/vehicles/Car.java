package com.mano.models.vehicles;

public class Car extends Vehicle {
    public Car(){
        super(VehicleType.Car);
    }
    public Car(int id){
        super(id, VehicleType.Car);
    }
}
