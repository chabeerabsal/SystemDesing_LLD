package Service;

import Modeller.Slot;
import Modeller.Ticket;
import Modeller.Vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class IssueTicket {
    private int ticketCounter = 1;
    private Map<String, Ticket> activeTickets = new HashMap<>();

    public Ticket createTicket(Vehicle vehicle, Slot slot) {
        String ticketNumber = "T" + ticketCounter++;
        Ticket ticket = new Ticket(ticketNumber, vehicle, slot, LocalDateTime.now());
        activeTickets.put(ticketNumber, ticket);
        return ticket;
    }

    public Ticket getTicket(String ticketNumber) {
        return activeTickets.get(ticketNumber);
    }

    public void removeTicket(String ticketNumber) {
        activeTickets.remove(ticketNumber);
    }
}
