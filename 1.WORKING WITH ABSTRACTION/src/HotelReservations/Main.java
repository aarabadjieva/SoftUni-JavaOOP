package HotelReservations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //50.25 5 Summer VIP
        String[] input = scanner.nextLine().split("\\s");
        double price = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        DiscountType type = DiscountType.valueOf(input[3]);

        ReservationDetails details = new ReservationDetails(price,days,season,type);
        System.out.printf("%.2f%n",PriceCalculator.calculate(details));
    }
}
