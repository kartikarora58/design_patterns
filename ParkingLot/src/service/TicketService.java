package service;

import models.*;
import repository.ParkingLotRepository;
import strategy.SlotFindingStrategy;

import java.util.Date;

public class TicketService {

        SlotFindingStrategy slotFindingStrategy;
        ParkingLotRepository parkingLotRepository;
        TicketService(SlotFindingStrategy slotFindingStrategy,ParkingLotRepository parkingLotRepository)
        {
            this.slotFindingStrategy = slotFindingStrategy;
            this.parkingLotRepository = parkingLotRepository;
        }

        public Ticket generateTicket(Vehicle vehicle, Gate gate)
        {
            Slot slot = slotFindingStrategy.findSlot(vehicle.getVehicleType(),
                    parkingLotRepository.findParkingLotByGate(gate));

            Ticket ticket = new Ticket();
            ticket.setGate(gate);
            ticket.setOperator(gate.getOperator());
            ticket.setParkingSlot(slot);
            ticket.setVehicle(vehicle);
            ticket.setEntryTime(new Date());
            return ticket;

        }
}
