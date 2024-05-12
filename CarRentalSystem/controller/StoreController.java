package CarRentalSystem.controller;

import CarRentalSystem.Store;
import CarRentalSystem.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class StoreController {

    List<Store> storeList_;

    StoreController()
    {
        this.storeList_ = new ArrayList<>();
    }

    public Store createStore(Store store)
    {
        this.storeList_.add(store);
        return store;
    }

    public void assignVehicle(Store store, Vehicle vehicle)
    {
        store.getVehicleList().add(vehicle);
    }
}
