package Service;

import Modeller.Slot.Slot;
import Modeller.Slot.SlotStatus;
import Modeller.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlotManager {
    private Map<VehicleType, List<Slot>> parkingSlots = new HashMap<VehicleType,List<Slot>>();
    public void addSlot(Slot slot) {
        VehicleType type = slot.getType();
        parkingSlots.putIfAbsent(type, new ArrayList<>());
        parkingSlots.get(type).add(slot);
    }
    public Slot getAvailableSlot(VehicleType type) {
        List<Slot> slots = parkingSlots.get(type);
        if (slots == null) return null;
        for (Slot s : slots) {
            if (s.getStatus() == SlotStatus.AVAILABLE) return s;
        }
        return null;
    }

    public Map<VehicleType, List<Slot>> getParkingSlots() {
        return parkingSlots;
    }
}
