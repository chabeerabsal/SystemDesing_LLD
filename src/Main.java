import Modeller.Slot.Slot;
import Modeller.Slot.SlotStatus;
import Modeller.Ticket.PrintRecipt;
import Modeller.Ticket.Ticket;
import Modeller.Vehicle.Vehicle;
import Modeller.Vehicle.VehicleType;
import Service.*;
import Service.Fees.HourlyFeesCalculator;
import Service.Parking.ParkingService;
import Service.Parking.UnParkVehicle;
import Service.Ticket.IssueTicket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        SlotManager slotManager = new SlotManager();
        IssueTicket issueTicket = new IssueTicket();
        HourlyFeesCalculator hourlyFeesCalculator = new HourlyFeesCalculator();

        // 2. Add slots
        slotManager.addSlot(new Slot("C1", VehicleType.CAR, SlotStatus.AVAILABLE));
        slotManager.addSlot(new Slot("C2", VehicleType.CAR, SlotStatus.AVAILABLE));
        slotManager.addSlot(new Slot("B1", VehicleType.BIKE, SlotStatus.AVAILABLE));
        ParkingService service = new ParkingService(slotManager, issueTicket);
        UnParkVehicle unParkVehicle = new UnParkVehicle(issueTicket, hourlyFeesCalculator);
        // 3. Create a vehicle
        Vehicle vehicle = new Vehicle("TN23AB1234", VehicleType.CAR);
        Vehicle vehicle1 = new Vehicle("TN23AB1232", VehicleType.CAR);
        Vehicle vehicle2 = new Vehicle("TN23AB1234", VehicleType.BIKE);

        // 4. Par   k the vehicle
        Ticket ticket = service.parkVehicle(vehicle);
        Ticket ticket1 = service.parkVehicle(vehicle1);
        Ticket ticket2 = service.parkVehicle(vehicle2);

        // 5. Print the ticket
        if (ticket != null) {
            System.out.println("Ticket generated: " + ticket);
        } else {
            System.out.println("No available slot found for this vehicle.");
        }
        //   LocalDateTime exiteTime=service.unParkVechicle("C1",VehicleType.CAR);

        try {
            Thread.sleep(5000);  // 5000 ms = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
       }

            PrintRecipt printRecipt = unParkVehicle.unParkVechicle(ticket.getTicketNumber());
            if (printRecipt != null) {
                System.out.println(printRecipt);
            }
//        Vehicle vehicle3 = new Vehicle("TN23AB1234", VehicleType.BIKE);
//        Ticket ticket3 = service.parkVehicle(vehicle3);
//
//        // 5. Print the ticket
//        if (ticket3 != null) {
//            System.out.println("Ticket generated: " + ticket3);
//        } else {
//            System.out.println("No available slot found for this vehicle.");
//        }
//        Ticket ticket4 = service.parkVehicle(vehicle3);
//
//        // 5. Print the ticket
//        if (ticket4 != null) {
//            System.out.println("Ticket generated: " + ticket4);
//        } else {
//            System.out.println("No available slot found for this vehicle.");
//        }



        }
    }
