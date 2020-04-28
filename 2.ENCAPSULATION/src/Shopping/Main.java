package Shopping;

import java.awt.dnd.InvalidDnDOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] peopleString = reader.readLine().split(";");
        Map<String, Person> people = new LinkedHashMap<>();
        for (String p:peopleString
             ) {
            String name = p.split("=")[0];
            double money = Double.parseDouble(p.split("=")[1]);
            try {
                Person person = new Person(name,money);
                people.put(name, person);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        String[] productString = reader.readLine().split(";");
        Map<String, Product> products = new LinkedHashMap<>();
        for (String p:productString
             ) {
            String name = p.split("=")[0];
            double cost = Double.parseDouble(p.split("=")[1]);
            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        String[] input = reader.readLine().split("\\s");
        while (!input[0].equals("END")){
            String personName = input[0];
            String productName = input[1];
            try {
                people.get(personName).buyProduct(products.get(productName));
                System.out.printf("%s bought %s%n",personName,productName);;
            }catch (InvalidDnDOperationException ex){
                System.out.println(ex.getMessage());
            }catch (NullPointerException ex){
                return;
            }
            input = reader.readLine().split("\\s");
        }
        people.values().forEach(person-> System.out.println(person.toString()));
    }
}
