package com.mano.models.vehicles;

public class Truck extends Vehicle {
    public Truck(){
        super(VehicleType.Truck);
    }
    public Truck(int id){
        super(id, VehicleType.Truck);
    }
}
