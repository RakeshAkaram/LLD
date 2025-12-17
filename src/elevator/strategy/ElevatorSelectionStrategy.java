package elevator.strategy;

import elevator.entity.ElevatorContoller;
import elevator.enums.Direction;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorContoller selectElevator(List<ElevatorContoller> elevatorContollerList, Integer floorNo, Direction direction);
}
