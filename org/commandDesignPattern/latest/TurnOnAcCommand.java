package org.commandDesignPattern.latest;

public class TurnOnAcCommand implements Command {

    Airconditioner airconditioner_;

    TurnOnAcCommand(Airconditioner airconditioner)
    {
        airconditioner_ = airconditioner;
    }
    @Override
    public void execute() {
        airconditioner_.turnOn();
    }

    public void undo()
    {
        airconditioner_.turnOff();
    }
}
