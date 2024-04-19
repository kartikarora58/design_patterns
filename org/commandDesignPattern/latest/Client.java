package org.commandDesignPattern.latest;

public class Client {
    public static void main(String[] args) {
        Airconditioner airconditioner = new Airconditioner();
        Remote remote = new Remote();
        remote.setCommand(new TurnOnAcCommand(airconditioner));
        remote.pressButton();
        remote.setCommand(new TurnOffAcCommand(airconditioner));
        remote.pressButton();
        remote.undo();
    }
}
