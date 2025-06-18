package Modeller;

public class Slot {
    private String slotId;            // e.g., C1, B2
    private VehicleType type;         // CAR or BIKE
    private SlotStatus status;// AVAILABLE or OCCUPIED

    public Slot(String slotId, VehicleType type, SlotStatus status) {
        this.slotId = slotId;
        this.type = type;
        // this.status = status;
    }
    public void markOccupied() {
        this.status = SlotStatus.OCCUPIED;
    }

    public void markAvailable() {
        this.status = SlotStatus.AVAILABLE;
    }

    public String getSlotId() {
        return slotId;
    }



    public SlotStatus getStatus() {
        return status;
    }



    public VehicleType getType() {
        return type;
    }


}
