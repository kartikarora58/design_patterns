package org.commandDesignPattern.latest;


// here we will encapsulate each command.
// user will just execute the command.
// user will be unaware of how the command will be executed.
// store each command as well, in
public class Airconditioner {
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
