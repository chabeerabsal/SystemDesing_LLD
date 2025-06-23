package Service.Parking;

import Modeller.Slot.Slot;
import Modeller.Ticket.Ticket;
import Modeller.Vehicle.Vehicle;
import Modeller.Vehicle.VehicleType;
import Service.SlotManager;
import Service.Ticket.IssueTicket;

public class ParkingService {
   private SlotManager slotManager;
  private IssueTicket issueTicket;
   public ParkingService(SlotManager slotManager, IssueTicket issueTicket) {
       this.slotManager = slotManager;
       this.issueTicket = issueTicket;
   }




    public Ticket parkVehicle(Vehicle vehicle) {
        VehicleType type = vehicle.getVechicletype();
        Slot slot = slotManager.getAvailableSlot(type);
        if(slot == null){
            System.out.println("No parking slot available");
            return null;
        }
        slot.markOccupied();

            Ticket ticket=issueTicket.createTicket(vehicle, slot);


         return ticket;


    }}