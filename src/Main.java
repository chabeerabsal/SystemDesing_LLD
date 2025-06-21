import Modeller.*;
import Service.ParkingService;

import java.time.Duration;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ParkingService service = new ParkingService();

        // 2. Add slots
        service.addSlot(new Slot("C1", VehicleType.CAR, SlotStatus.AVAILABLE));
        service.addSlot(new Slot("C2", VehicleType.CAR, SlotStatus.AVAILABLE));
        service.addSlot(new Slot("B1", VehicleType.BIKE, SlotStatus.AVAILABLE));

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
        PrintRecipt printRecipt=service.unParkVechicle(ticket1.getTicketNumber());
        if (printRecipt != null) {
            System.out.println(printRecipt.toString());
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