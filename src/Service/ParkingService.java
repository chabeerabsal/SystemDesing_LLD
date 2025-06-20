package Service;

import Modeller.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class ParkingService {
    private Map<VehicleType, List<Slot>> parkingSlots = new HashMap<VehicleType,List<Slot>>();
    private int ticketCounter=1;
    public void addSlot(Slot slot) {
        VehicleType type = slot.getType();
        parkingSlots.putIfAbsent(type, new ArrayList<>());
        parkingSlots.get(type).add(slot);
    }

    private Map<String, Ticket> activeTickets = new HashMap<>();
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

System.out.println("No parking slot available");
         return null;

    }

    public LocalDateTime unParkVechicle(String c1, VehicleType vehicleType) {
        ;
            List<Slot> slot=parkingSlots.get(vehicleType);

                for(Slot slot1 : slot)
                {
                    if(slot1.getType()==vehicleType){
                    if(slot1.getSlotId().equals(c1)) {
                        slot1.markAvailable();
                        //parkingSlots.get(vehicleType).remove(slot1);
                        System.out.println("Parking Slot " + slot1.getSlotId() + " " + slot1.getStatus());
                        // for(Map.entry())
                        // List<Slot> slott= entry.getValue());
                    }
                    System.out.println(slot1.getSlotId() + " " + slot1.getStatus()+" "+slot1.getType());
                }
            }

        return LocalDateTime.now();
    }
}
