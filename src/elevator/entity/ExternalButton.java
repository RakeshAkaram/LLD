package elevator.entity;

import elevator.enums.Direction;

public class ExternalButton {
    private Direction direction;
    private ExternalDispatcher externalDispatcher;

    public void submitButton(Integer floorNo){
        ElevatorContoller elevatorContoller = externalDispatcher.fetchElevatorController(floorNo,direction);
        elevatorContoller.processRequest(floorNo);
    }
}
