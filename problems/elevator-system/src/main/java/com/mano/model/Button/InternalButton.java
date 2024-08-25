package com.mano.model.Button;

import com.mano.model.Direction;
import com.mano.service.InternalDispatcher;

import lombok.Data;

@Data
public class InternalButton extends Button{
    InternalDispatcher dispatcher;
    private int elevatorId;
    @Override
    public void pressButton(int floor, Direction direction) {
            dispatcher.submitRequest(elevatorId, floor, direction);
    }

    
}
