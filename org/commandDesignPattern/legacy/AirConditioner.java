package org.commandDesignPattern.legacy;

// problems
// violation of single responsibility principle
// multiple commands are linked to one single class
// if new commands are introduced, the client has to be aware about those commands
// if we want to undo any commands then, it becomes very difficult
public class AirConditioner {
    boolean isOn;
    int temperature;

    public void turnOn() {
        this.isOn = true;
        System.out.println("Air conditioner is turned on");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("Air conditioner is turned off");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Air conditioner temperature is "+this.temperature);
    }

}
