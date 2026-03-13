package org.elevator_car;

import java.util.List;

public class ExternalButton  {

    ElevatorAssignStrategy strategy;
    List<ElevatorController> elevatorControllerList;

    ExternalButton(List<ElevatorController> elevatorControllerList)
    {
        this.strategy = new NearestElevatorStrategy();
        this.elevatorControllerList = elevatorControllerList;
    }

    void assignElevator(int floor,Direction direction)
    {
        ElevatorController elevatorController = strategy.getElevator(floor,direction,elevatorControllerList);
    }
}
