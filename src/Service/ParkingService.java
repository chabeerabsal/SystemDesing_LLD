package Service;

import Modeller.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class ParkingService {
    private Map<VehicleType, List<Slot>> parkingSlots = new HashMap<VehicleType,List<Slot>>();
    private int ticketCounter=0;
    public Ticket parkVehicle(Vehicle vehicle)
    {
         VehicleType type= vehicle.getVechicletype();
         List<Slot> slotList = parkingSlots.get(type);
         if(slotList == null)
         {
             System.out.println("Slot Type Not Found");
             return null;
         }
         for (Slot slot : slotList) {
             if(slot.getStatus()== SlotStatus.AVAILABLE)
             {
              slot.markOccupied();
                 String ticketNumber = "T" + ticketCounter++;
                 Ticket ticket = new Ticket(ticketNumber, vehicle, slot, LocalDateTime.now());

                 // 5. Store ticket
                 activeTickets.put(ticketNumber, ticket);

                 return ticket;
             }
         }



    }
}
