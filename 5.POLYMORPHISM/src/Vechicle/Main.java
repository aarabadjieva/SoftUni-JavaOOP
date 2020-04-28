package Vechicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split("\\s");
        String[] truckInfo = scanner.nextLine().split("\\s");
        String[] busInfo = scanner.nextLine().split("\\s");
        Vechicle car = new Car(Double.valueOf(carInfo[1]),Double.valueOf(carInfo[2]),Integer.valueOf(carInfo[3]));
        Vechicle truck = new Truck(Double.valueOf(truckInfo[1]),Double.valueOf(truckInfo[2]),Integer.valueOf(truckInfo[3]));
        Bus bus = new Bus(Double.valueOf(busInfo[1]),Double.valueOf(busInfo[2]),Integer.valueOf(busInfo[3]));
        List<Vechicle> vechicles = new ArrayList<>(){{add(car);add(truck);add(bus);}};
        int commands = Integer.parseInt(scanner.nextLine());
        while (commands-->0){
            String[] cmd = scanner.nextLine().split("\\s");
            switch (cmd[0]){
                case "Drive":
                    for (Vechicle vechicle:vechicles
                         ) {
                        if (vechicle.getClass().getSimpleName().equals(cmd[1])){
                            System.out.println(vechicle.drive(Double.parseDouble(cmd[2])));
                        }
                    }
                    break;
                case "Refuel":
                    for (Vechicle vechicle:vechicles
                    ) {
                        if (vechicle.getClass().getSimpleName().equals(cmd[1])){
                            try {
                                vechicle.refuel(Double.parseDouble(cmd[2]));
                            }catch (IllegalArgumentException ex){
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(bus.driveEmpty(Double.parseDouble(cmd[2])));
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
