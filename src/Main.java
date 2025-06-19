import Modeller.*;
import Service.ParkingService;

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

        // 4. Par   k the vehicle
        Ticket ticket = service.parkVehicle(vehicle);

        // 5. Print the ticket
        if (ticket != null) {
            System.out.println("Ticket generated: " + ticket);
        } else {
            System.out.println("No available slot found for this vehicle.");
        }
    }
}