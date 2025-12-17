package elevator.entity;

import elevator.enums.Direction;
import elevator.strategy.ElevatorSelectionStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalDispatcher {
    private List<ElevatorContoller> elevatorContollerList = new ArrayList<>();
    private ElevatorSelectionStrategy elevatorSelectionStrategy;
    public ElevatorContoller fetchElevatorController(Integer floorNo, Direction direction){
        return elevatorSelectionStrategy.selectElevator(elevatorContollerList,floorNo,direction);
    }
    public void registerElevatorController(ElevatorContoller elevatorContoller){
        elevatorContollerList.add(elevatorContoller);
    }
}
