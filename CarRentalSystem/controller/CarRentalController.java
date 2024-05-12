package CarRentalSystem.controller;

import CarRentalSystem.Vehicle;
import CarRentalSystem.enums.VehicleType;
import org.cricbuzz.Over;

public class CarRentalController {

    BookingController bookingController_;
    StoreController storeController_;
    UserController userController_;
    VehicleController vehicleController_;

    CarRentalController(BookingController bookingController, StoreController storeController,UserController userController,VehicleController vehicleController)
    {
        this.bookingController_ = bookingController;
        this.storeController_ = storeController;
        this.userController_ = userController;
        this.vehicleController_ = vehicleController;
    }

    public Vehicle createVehicle(int id, String name, String yearOfManufacturing, int kmsDriven, VehicleType vehicleType, int hourlyRate)
    {
        Vehicle vehicle = new Vehicle(id,name,yearOfManufacturing,kmsDriven, vehicleType,hourlyRate);
        vehicleController_.createVehicle(vehicle);
        return vehicle;
    }

}
