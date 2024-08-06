package com.mano.models;

import com.mano.models.vehicles.Vehicle;
import com.mano.models.vehicles.VehicleType;

public class ParkingSpot {
    private int id;
    private Vehicle vehicle;
    private VehicleType type ;
    private boolean isEmpty;
    public ParkingSpot(int id ,VehicleType type){
        this.id = id;
        this.type = type; 
        this.isEmpty = true;
    }
    public synchronized boolean ParkVehicle(Vehicle toPark){
        if(toPark.getType() != type) return false;
        if(!isEmpty) return false;
        isEmpty = false;
        vehicle = toPark;
        return true;
    }
    public synchronized boolean UnparkVehicle(){
        if(isEmpty) return false;
        isEmpty = true;
        vehicle = null;
        return true;
    }
    public VehicleType getType(){
        return type;
    }
    public boolean getIsEmpty(){
        return isEmpty;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public int getId(){
        return id;
    }
}
