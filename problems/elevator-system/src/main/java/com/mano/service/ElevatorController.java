package com.mano.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.mano.model.Direction;
import com.mano.model.ElevatorCar;

import lombok.Data;

@Data
public class ElevatorController {
    private ElevatorCar elevator;
    //Should be in ascending order
    private PriorityQueue<Integer> goUp;
    //Should be in descending order
    private PriorityQueue<Integer> goDown;
    private Queue<Integer> pendingJobs ;
    public ElevatorController(ElevatorCar elevator){
        goUp = new PriorityQueue<>();
        goDown = new PriorityQueue<>( new Descending());
        pendingJobs = new LinkedList<>(); 
    }
    //Please not floor here is the starting floor only destination selection happens in the internal buttons
    public boolean acceptRequest(int floor, Direction direction){
        int currentFloor = elevator.getCurrentFloor();
        Direction liftDirection = elevator.getDirection();
        if(direction != liftDirection){
            if(direction == Direction.UP){
                goUp.add(floor);
            }
            else{
                goDown.add(floor);
            }
        }
        else if(direction == Direction.UP){
            if(floor > currentFloor){
                goUp.add(floor);
            }               
            else{
                pendingJobs.add(floor);
            }
        }
        else{
            if(floor < currentFloor){
                goDown.add(floor);
            }
            else{
                pendingJobs.add(floor);
            }
        }
        return true;
    }
    public void control(){
        Direction liftDirection = elevator.getDirection();
        if(liftDirection == Direction.UP){
            if(goUp.size() == 0){
                elevator.setDirection(Direction.DOWN);
                while(pendingJobs.size() != 0){
                    goUp.add(pendingJobs.remove());
                }
                
            }
        }
        else{

        }
    }

}
class Descending implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o2);
    }

}
