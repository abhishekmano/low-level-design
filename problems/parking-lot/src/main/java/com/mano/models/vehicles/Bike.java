package com.mano.models.vehicles;

public class Bike extends Vehicle {
    public Bike(){
        super(VehicleType.Bike);
    }
    public Bike(int id){
        super(id, VehicleType.Bike);
    }
}
