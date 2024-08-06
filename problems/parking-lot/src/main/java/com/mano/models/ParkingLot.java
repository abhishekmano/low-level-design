package com.mano.models;

import java.util.List;

import com.mano.services.ParkingSpotManager;

public class ParkingLot {
    private static ParkingLot instance;
    public ParkingSpotManager parkingSpotManager;
    private ParkingLot(){
        parkingSpotManager = new ParkingSpotManager();
    };
    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            return new ParkingLot();
        }
        else return instance;
    }
}
