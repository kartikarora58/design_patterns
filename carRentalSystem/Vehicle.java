package carRentalSystem;

import java.util.Date;

public class Vehicle {
    int id;
    int number;
    String name;
    VehicleType vehicleType_;
    Date manufacturedData;
    int kmsDriven;
    Store store;
    VehicleStatus vehicleStatus_;

    public Vehicle(
            int id, int number, String name, VehicleType vehicleType, Date manufacturedData, int kmsDriven,
            Store store,VehicleStatus vehicleStatus) {
        this.id = id;
        this.number = number;
        this.name = name;
        vehicleType_ = vehicleType;
        this.manufacturedData = manufacturedData;
        this.kmsDriven = kmsDriven;
        this.store = store;
        this.vehicleStatus_ = vehicleStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getVehicleType() {
        return vehicleType_;
    }

    public void setVehicleType(VehicleType vehicleType) {
        vehicleType_ = vehicleType;
    }

    public Date getManufacturedData() {
        return manufacturedData;
    }

    public void setManufacturedData(Date manufacturedData) {
        this.manufacturedData = manufacturedData;
    }

    public int getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(int kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }



}
