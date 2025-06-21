package Modeller;

import java.time.LocalDateTime;

public class PrintRecipt {
    private Ticket ticket;
    private LocalDateTime entryTime;
    private LocalDateTime ExitTime;
    private long duration;
    private double fees;

    public PrintRecipt(Ticket ticket, LocalDateTime entryTime, LocalDateTime exitTime, long duration, double fees) {
        this.ticket = ticket;
        this.entryTime = entryTime;
        ExitTime = exitTime;
        this.duration = duration;
        this.fees = fees;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return ExitTime;
    }

    @Override
    public String toString() {
        return ticket.toString()+""+entryTime.toString() + " " + ExitTime.toString()+" "+duration+" "+fees;
    }
}
