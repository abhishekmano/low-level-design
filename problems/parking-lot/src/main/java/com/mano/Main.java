package com.mano;

import com.mano.models.Level;
import com.mano.models.ParkingLot;
import com.mano.models.ParkingSpot;
import com.mano.models.vehicles.Bike;
import com.mano.models.vehicles.Car;
import com.mano.models.vehicles.Truck;
import com.mano.services.ParkingLevelBuilder;
import com.mano.services.ParkingSpotManager;

public class Main {
    public static void main(String[] args) {
        ParkingLot instance = ParkingLot.getInstance();
        ParkingSpotManager manager = instance.parkingSpotManager;

        ParkingLevelBuilder builder = new ParkingLevelBuilder(1,1);
        builder.addBikeParking(2);
        builder.addCarParking(1);
        builder.addTruckParking(1);
        Level level1 = builder.build();
        manager.addLevel(level1);
        builder = new ParkingLevelBuilder(2, 2);
        builder.addBikeParking(1);
        builder.addCarParking(3).addTruckParking(0);

        Level level2 = builder.build();
        manager.addLevel(level2);

        Car car1 = new Car(123);
        Car car2 = new Car(234);
        Bike bike1 = new Bike(555);
        Truck truck1 = new Truck(666);
        Truck truck2 = new Truck(777);

        //
        manager.ShowAvailability();
        ParkingSpot slot = manager.FindParkingSlot(car1.getType());
        if(slot == null){
            System.out.println("No Available Slot");
        }
        else{
            manager.AssignParkingSlot(car1, slot);
        }

        //
        manager.ShowAvailability();
        slot = manager.FindParkingSlot(car2.getType());
        if(slot == null){
            System.out.println("No Available Slot");
        }
        else{
            manager.AssignParkingSlot(car2, slot);
        }
        manager.ShowAvailability();

        //
        slot = manager.FindParkingSlot(truck1.getType());
        if(slot == null){
            System.out.println("No Available Slot");
        }
        else{
            manager.AssignParkingSlot(truck1, slot);
        }
        manager.ShowAvailability();
        
        slot = manager.FindParkingSlot(truck2.getType());
        if(slot == null){
            System.out.println("No Available Slot");
        }
        else{
            manager.AssignParkingSlot(truck2, slot);
        }
        manager.ShowAvailability();
        
    }
}