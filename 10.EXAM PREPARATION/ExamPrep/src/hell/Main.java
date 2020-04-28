package hell;

import hell.core.InputReaderImpl;
import hell.core.ManagerImpl;
import hell.core.OutputWriterImpl;
import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.ItemImpl;
import hell.interfaces.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){

        InputReader reader = new InputReaderImpl();
        Manager manager = new ManagerImpl();
        String cmd = reader.readLine();
        while (!cmd.equals("Quit")){
            List<String> info = Arrays.stream(cmd.split("\\s")).collect(Collectors.toList());
            String result = "";
            switch (info.get(0)){
                case "Hero":
                    result = manager.addHero(info);
                    break;
                case "Item":
                    result = manager.addItem(info);
                    break;
                case "Recipe":
                    result = manager.addRecipe(info);
                    break;
                case "Inspect":
                    result = manager.inspect(info);
                    break;
            }
            System.out.println(result);
            cmd = reader.readLine();
        }
        System.out.println(manager.quit());
    }

}
