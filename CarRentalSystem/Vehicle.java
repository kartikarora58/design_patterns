package CarRentalSystem;

import CarRentalSystem.enums.VehicleStatus;
import CarRentalSystem.enums.VehicleType;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    int id;
    String name;
    YearMonth yearOfManufacturing_;
    int kmsDriven;
    VehicleStatus vehicleStatus_;
    VehicleType vehicleType_;
    int hourlyRate;
    List<Slot> slotList_;

    public Vehicle(
            int id, String name, String yearOfManufacturing, int kmsDriven, VehicleType vehicleType, int hourlyRate) {
        this.id = id;
        this.name = name;
        this.yearOfManufacturing_ = YearMonth.parse(yearOfManufacturing);
        this.kmsDriven = kmsDriven;
        this.vehicleType_ = vehicleType;
        this.hourlyRate = hourlyRate;
        this.slotList_ = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public YearMonth getYearOfManufacturing() {
        return yearOfManufacturing_;
    }

    public void setYearOfManufacturing(YearMonth yearOfManufacturing) {
        yearOfManufacturing_ = yearOfManufacturing;
    }

    public int getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(int kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus_;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        vehicleStatus_ = vehicleStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType_;
    }

    public void setVehicleType(VehicleType vehicleType) {
        vehicleType_ = vehicleType;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public List<Slot> getSlotList() {
        return slotList_;
    }

    public void setSlotList(List<Slot> slotList) {
        slotList_ = slotList;
    }

}
