package com.mano.models;

import java.util.ArrayList;
import java.util.List;

import com.mano.models.vehicles.Vehicle;
import com.mano.models.vehicles.VehicleType;

public class Level {
    private int id;
    private int floorNumber;
    private List<ParkingSpot> spots;
    public Level(int id , int floor , int bike , int car , int truck){
        this.id = id;
        floorNumber = floor;
        spots = new ArrayList<>();
        for(int idx = 0 ; idx < bike ; ++idx){
            spots.add( new ParkingSpot(idx,VehicleType.Bike));            
        }
        for(int idx = 0 ; idx < car ; ++idx){
            spots.add( new ParkingSpot(bike + idx ,VehicleType.Car));            
        }
        for(int idx = 0 ; idx < truck ; ++idx){
            spots.add( new ParkingSpot( bike + car + idx ,  VehicleType.Truck));            
        }
    }
    public int getId(){return id;}
    public int getFloor(){return floorNumber;}
    public ParkingSpot getFreeParkingSpot(VehicleType type){
        for (ParkingSpot parkingSpot : spots) {
            if(parkingSpot.getType() == type && parkingSpot.getIsEmpty() == true){
                return parkingSpot;
            }
        }
        return null;
    }
    public boolean unparkVehicle(Vehicle vehicle){
        for (ParkingSpot parkingSpot : spots) {
            if(vehicle == parkingSpot.getVehicle()){
                parkingSpot.UnparkVehicle();
                return true;
            }
        }
        return false;
    }
    public void showParkingLevel(){
        System.out.println("Level " + floorNumber );
        for (ParkingSpot parkingSpot : spots) {
            System.out.println("Spot " +  parkingSpot.getId() + ": " + parkingSpot.getType() + "Type " + (parkingSpot.getIsEmpty() ? "Available" : "Occupied Id:" + parkingSpot.getVehicle().getId() ) );
        }
    }
}
