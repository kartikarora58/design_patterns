package strategy;

import enums.SlotStatus;
import enums.VehicleType;
import models.Floor;
import models.ParkingLot;
import models.Slot;

public class SimpleSlotFinding implements SlotFindingStrategy{

    @Override
    public Slot findSlot(VehicleType vehicleType, ParkingLot parkingLot) {
        for(Floor floor:parkingLot.getParkingFloors())
        {
            for(Slot slot:floor.getParkingSlots())
            {
                if(slot.getSupportedVehicleTypes().contains(vehicleType) && slot.getStatus().equals(SlotStatus.AVAILABLE))
                    return slot;
            }
        }

        return null;
    }
}
