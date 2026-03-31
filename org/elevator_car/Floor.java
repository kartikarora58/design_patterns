package org.elevator_car;

public class Floor {
    int id;
    ExternalButton button;

    void pressButton(Direction direction) {
        button.assignElevator(this.id, direction);
    }
}
