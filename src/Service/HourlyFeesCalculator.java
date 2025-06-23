package Service;

public class HourlyFeesCalculator implements FeesCalculator {
    @Override
    public double calculateFee(long durationMinutes) {
        double ratePerHour = 10.0;
        long hours = (durationMinutes + 59) / 60;  // round up to next hour
        return ratePerHour * hours;
    }
}
