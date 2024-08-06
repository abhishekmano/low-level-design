package com.mano.services;

import com.mano.models.Level;

public class ParkingLevelBuilder {
    private Level level;
    private int id;
    private int floor;
    private int bikeCount;
    private int carCount;
    private int truckCount ;
    public ParkingLevelBuilder(int id , int floor){
        this.id = id;
        this.floor = floor;
        bikeCount = 0;
        carCount = 0;
        truckCount = 0;
    }
    public ParkingLevelBuilder addCarParking(int count){
        carCount += count;
        return this;
    }
    public ParkingLevelBuilder addBikeParking(int count){
        bikeCount += count;
        return this;
    }
    public ParkingLevelBuilder addTruckParking(int count){
        truckCount += count;
        return this;
    }
    public Level build(){
        level =  new Level(id , floor , bikeCount ,carCount , truckCount);
        return level;
    }
    

}
