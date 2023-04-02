package models;

import enums.VehicleType;

import java.util.List;
import java.util.Map;

public class ParkingLot extends BaseModel {
    List<Floor> parkingFloors;
    List<Gate> parkingGates;
    String name;
    String address;
    Map<VehicleType,Integer> priceMap;


    public List<Floor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<Floor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getParkingGates() {
        return parkingGates;
    }

    public void setParkingGates(List<Gate> parkingGates) {
        this.parkingGates = parkingGates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<VehicleType, Integer> getPriceMap() {
        return priceMap;
    }

    public void setPriceMap(Map<VehicleType, Integer> priceMap) {
        this.priceMap = priceMap;
    }


}
