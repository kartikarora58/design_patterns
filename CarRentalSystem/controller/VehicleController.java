package CarRentalSystem.controller;

import CarRentalSystem.Slot;
import CarRentalSystem.Vehicle;
import CarRentalSystem.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class VehicleController {
    List<Vehicle> vehicleList_;

    VehicleController()
    {
        this.vehicleList_ = new ArrayList<>();
    }

    public Vehicle createVehicle(Vehicle vehicle)
    {
        vehicleList_.add(vehicle);
        return vehicle;
    }

    public void addBookingSlot(Vehicle vehicle, Slot slot)
    {
        vehicle.getSlotList().add(slot);
    }
}
