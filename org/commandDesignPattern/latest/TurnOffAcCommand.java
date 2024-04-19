package org.commandDesignPattern.latest;

public class TurnOffAcCommand implements Command{
    Airconditioner airconditioner_;

    TurnOffAcCommand(Airconditioner airconditioner)
    {
        airconditioner_ = airconditioner;
    }
    @Override
    public void execute() {
        airconditioner_.turnOff();
    }

    public void undo()
    {
        airconditioner_.turnOn();
    }
}
