package InterfacePerson;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> persons = new LinkedHashMap<>();
        while(people-->0){
            String[] info = scanner.nextLine().split("\\s");
            switch (info.length){
                case 4:
                    Citizen citizen = new Citizen(info[0],Integer.parseInt(info[1]),info[2],info[3]);
                    persons.put(citizen.getName(),citizen);
                    break;
                case 3:
                    Rebel rebel = new Rebel(info[0],Integer.parseInt(info[1]),info[2]);
                    persons.put(rebel.getName(),rebel);
                    break;
            }
        }
        String name = scanner.nextLine();
        while (!name.equals("End")){
            if (persons.containsKey(name)){
                persons.get(name).buyFood();
            }
            name = scanner.nextLine();
        }
        int totalFood = 0;
        for (Buyer person:persons.values()
             ) {
            totalFood+=person.getFood();
        }
        System.out.println(totalFood);
    }
}
