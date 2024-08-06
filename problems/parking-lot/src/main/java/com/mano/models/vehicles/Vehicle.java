package com.mano.models.vehicles;

public abstract class Vehicle {
    protected int vehicleId;
    protected VehicleType type; 
    public Vehicle(){

    }
    public Vehicle(VehicleType vehicleType){
        type = vehicleType;
    }
    public Vehicle(int id , VehicleType vehicleType){
        vehicleId = id;
        type = vehicleType;
    }
    public VehicleType getType(){
        return type;
    }
    public int getId(){
        return vehicleId;
    }
}

