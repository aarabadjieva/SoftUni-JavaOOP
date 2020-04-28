package HotelReservations;

public class PriceCalculator {

   public static double calculate(ReservationDetails details){
       return  (details.getPricePerDay()*details.getSeason().getValue())*
               (1-details.getType().getDiscount())*
               details.getNumberOfDays();
    }
}
