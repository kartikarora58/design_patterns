package repository;

import models.Gate;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLotMap = new HashMap<>();
    private Map<Gate,ParkingLot>  parkingLotGateMap = new HashMap<>();

    public ParkingLot save(ParkingLot parkingLot)
    {
        parkingLotMap.put(parkingLot.getId(),parkingLot);
        for(Gate gate:parkingLot.getParkingGates())
        {
            parkingLotGateMap.put(gate,parkingLot);
        }

        return parkingLot;
    }

    public ParkingLot findParkingLotByGate(Gate gate)
    {
        return parkingLotGateMap.get(gate);
    }
}
