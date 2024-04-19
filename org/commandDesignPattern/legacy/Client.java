package org.commandDesignPattern.legacy;

public class Client {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.setTemperature(44);
        airConditioner.turnOff();
    }
}
