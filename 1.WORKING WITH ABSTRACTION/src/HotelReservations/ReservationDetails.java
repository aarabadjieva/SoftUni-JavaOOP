package HotelReservations;

public class ReservationDetails {
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private DiscountType type;

    public ReservationDetails(double pricePerDay, int numberOfDays, Season season, DiscountType type) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.type = type;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Season getSeason() {
        return season;
    }

    public DiscountType getType() {
        return type;
    }
}
