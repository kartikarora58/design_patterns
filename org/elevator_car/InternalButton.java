package org.elevator_car;

public class InternalButton {

    ElevatorController controller;

    void submitRequest(int floor)
    {
        controller.submitRequest(floor);
    }


}
