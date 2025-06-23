package Service;

import Modeller.PrintRecipt;
import Modeller.Slot;
import Modeller.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class UnParkVehicle {
    private IssueTicket issueTicket;
    private FeesCalculator feesCalculator;

    public UnParkVehicle(IssueTicket issueTicket,FeesCalculator feesCalculator) {
        this.issueTicket = issueTicket;
        this.feesCalculator = feesCalculator;
    }

    public PrintRecipt unParkVechicle(String ticketNumber) {

        Ticket ticket = issueTicket.getTicket(ticketNumber);
        if(ticket == null)
            System.out.println("Ticket Not Found");
        else {
            Slot slot = ticket.getSlot();
            LocalDateTime exitTime = ticket.getEntryTime().plusMinutes(90);
            slot.markAvailable();
            System.out.println("Unparking Slot Available" + slot.toString());
            LocalDateTime entryTime = ticket.getEntryTime();
            issueTicket.removeTicket(ticketNumber);
            long duration = Duration.between(entryTime, exitTime).toMinutes();
            double fees=  feesCalculator.calculateFee(duration);

            return new PrintRecipt(ticket,entryTime,exitTime,duration,fees);
        }
        return null;
    }
}
