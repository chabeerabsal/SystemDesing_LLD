package Service;

import Modeller.*;

import java.time.Duration;
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

    public PrintRecipt unParkVechicle(String ticketNumber) {

          Ticket ticket = activeTickets.get(ticketNumber);
          if(ticket == null)
              System.out.println("Ticket Not Found");
          else {
              Slot slot = ticket.getSlot();
              LocalDateTime exitTime = ticket.getEntryTime().plusMinutes(90);
              slot.markAvailable();
              System.out.println("Unparking Slot Available" + slot.toString());
              LocalDateTime entryTime = ticket.getEntryTime();
              activeTickets.remove(ticketNumber);
              long duration = Duration.between(entryTime, exitTime).toMinutes();
            double fees=  calculateFees(duration);

          return new PrintRecipt(ticket,entryTime,exitTime,duration,fees);
    }
          return null;
    }

    private double calculateFees(long durationMinutes) {
        double ratePerHour = 10.0;
        long hours = (durationMinutes + 59) / 60;  // round up to next hour
        return ratePerHour * hours;
    }
}
