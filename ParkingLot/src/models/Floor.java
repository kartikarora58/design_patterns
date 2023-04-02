package models;

import java.util.List;

public class Floor extends BaseModel{
    int floorNumber;
    List<Slot> parkingSlots;
    String floorManager;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<Slot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<Slot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public String getFloorManager() {
        return floorManager;
    }

    public void setFloorManager(String floorManager) {
        this.floorManager = floorManager;
    }



}
