package strategy;

import enums.VehicleType;
import models.ParkingLot;
import models.Slot;

public interface SlotFindingStrategy {

     Slot findSlot(VehicleType vehicleType, ParkingLot parkingLot);
}
