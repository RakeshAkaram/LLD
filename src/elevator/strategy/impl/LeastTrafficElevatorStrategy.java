package elevator.strategy.impl;

import elevator.entity.ElevatorContoller;
import elevator.enums.Direction;
import elevator.strategy.ElevatorSelectionStrategy;

import java.util.List;

public class LeastTrafficElevatorStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorContoller selectElevator(List<ElevatorContoller> elevatorContollerList, Integer floorNo, Direction direction) {
        return null;
    }
}
