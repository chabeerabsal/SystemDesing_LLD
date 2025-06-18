package Modeller;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketNumber;      // Unique ID like T1, T2
    private Vehicle vehicle;          // The parked vehicle
    private Slot slot;                // Assigned slot
    private LocalDateTime entryTime;

    public Ticket(String ticketNumber, Vehicle vehicle, Slot slot, LocalDateTime entryTime) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = entryTime;
    }
    public String getTicketNumber() {
        return ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Slot getSlot() {
        return slot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", vehicle=" + vehicle +
                ", slot=" + slot +
                ", entryTime=" + entryTime +
                '}';
    }
}
