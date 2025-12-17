package elevator.entity;

import elevator.enums.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ElevatorContoller implements Runnable{
    private static PriorityQueue<Integer> minQue = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxQue = new PriorityQueue<>();
    private static List<Integer> requests = new ArrayList<>();

    public void processRequest(Integer floorNo){

    }

    @Override
    public void run() {
        elevatorRun();
    }

    private void elevatorRun() {

    }
}
