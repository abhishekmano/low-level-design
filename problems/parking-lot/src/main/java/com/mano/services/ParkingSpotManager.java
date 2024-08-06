package com.mano.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.mano.models.*;
import com.mano.models.vehicles.Vehicle;
import com.mano.models.vehicles.VehicleType;

public class ParkingSpotManager {
    public List<Level> parkingLevels;
    public HashMap<VehicleType ,ParkingSpot> available ;
    public HashMap<VehicleType,ParkingSpot> occupied;
    public ParkingSpotManager(){
        parkingLevels = new ArrayList<>();
    }
    public ParkingSpotManager(List<Level> spots){
        parkingLevels = spots;
    }
    public void addLevel(Level level){
        parkingLevels.add(level);
    }
    public ParkingSpot FindParkingSlot(VehicleType type){
        for (Level level : parkingLevels) {
            ParkingSpot spot = level.getFreeParkingSpot(type);
            if(spot != null) return spot;
        }
        return null;
    }
    public boolean AssignParkingSlot(Vehicle vehicle , ParkingSpot slot){
       if(slot!= null){
        return  slot.ParkVehicle(vehicle);
       }     
       return false;
    }
    public boolean ReleaseParkingSlot(Vehicle vehicle){
        for (Level level : parkingLevels) {
            if(level.unparkVehicle(vehicle)) return true;
        }
        return false;
    }
    public void ShowAvailability(){
        System.out.println("-----------------------");
        for (Level level : parkingLevels) {
            level.showParkingLevel();
        }
        System.out.println("-----------------------\n");
    }
}
