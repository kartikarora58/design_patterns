package carRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {

    List<Vehicle> vehicleList_;

    public List<Vehicle> findVehiclesBydStoreId(int storeId)
    {
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle: this.vehicleList_)
        {
            if(vehicle.getStore().id == storeId)
                vehicles.add(vehicle);
        }
        return vehicles;
    }

}
