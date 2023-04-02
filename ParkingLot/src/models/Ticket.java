package models;

import java.util.Date;


public class Ticket extends BaseModel{
    Date entryTime;
    Operator operator;
    Vehicle vehicle;
    Gate gate;
    Slot parkingSlot;

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Slot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(Slot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }


}
