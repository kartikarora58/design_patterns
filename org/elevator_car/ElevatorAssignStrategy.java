package org.elevator_car;

import java.util.List;

public interface ElevatorAssignStrategy {
    ElevatorController getElevator(int floor, Direction direction, List<ElevatorController> elevatorControllerList);
}
