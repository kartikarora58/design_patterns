package org.elevator_car;

import java.util.Collections;
import java.util.PriorityQueue;

public class ElevatorController implements Runnable {

    ElevatorCar elevator;
    PriorityQueue<Integer> minQ;
    PriorityQueue<Integer> maxQ;

    private Object lock = new Object();

    ElevatorController(ElevatorCar elevator) {
        this.elevator = elevator;
        this.minQ = new PriorityQueue<>();
        this.maxQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void submitRequest(int floor) {

        if(floor == elevator.floor)
            return;
        if(floor> elevator.floor)
        {
            if(!minQ.contains(floor))
                minQ.add(floor);
        }
        else{
            if(!maxQ.contains(floor))
                maxQ.add(floor);
        }
        lock.notifyAll();
    }

    @Override
    public void run() {
        startElevator();
    }

    private void startElevator()
    {
        while(true)
        {

            while (minQ.isEmpty() && maxQ.isEmpty()) {
                System.out.println("elevator is in Idle state " + elevator.id);
                elevator.direction = Direction.IDLE;
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            elevator.direction = Direction.UP;
            while(!minQ.isEmpty())
            {
                int floor = minQ.remove();
                System.out.println("Serving floor: " + floor + " by elevator:" + elevator.id + " currentFloor: " + elevator.floor);
                elevator.moveElevator(floor);
            }
            elevator.direction = Direction.DOWN;
            while(!maxQ.isEmpty())
            {
                int floor = maxQ.remove();
                System.out.println("Serving floor: " + floor + " by elevator:" + elevator.id + " currentFloor: " + elevator.floor);
                elevator.moveElevator(floor);
            }

        }
    }
}
