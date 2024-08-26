package com.mano.service;

import java.util.HashMap;

import com.mano.model.Direction;

public class ExternalDispatcher {
    HashMap<Integer,ElevatorController> map ;
    public boolean submitRequest(int elevatorId , int floorNumber, Direction direction){
        if(map.containsKey(elevatorId)){
            map.get(elevatorId).acceptRequest(floorNumber, direction);
            return true;
        }
        else{
            return false;
        }
        
    }
}
