package hell.core;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.HeroImpl;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<String, Hero> heroes;
    public ManagerImpl(){
        this.heroes = new LinkedHashMap<>();
    }


    @Override
    public String addHero(List<String> arguments) {
       Hero hero = null;
       String name = arguments.get(1);
       String type = arguments.get(2);
   //    switch (type){
   //        case "Assassin":
   //            hero = new Assassin(name);
   //            break;
   //        case "Barbarian":
   //            hero = new Barbarian(name);
   //            break;
   //        case "Wizard":
   //            hero = new Wizard(name);
   //            break;
   //    }
   //    heroes.put(name, hero);
        return String.format("Created %s - %s",type,
                name);
    }

    @Override
    public String addItem(List<String> arguments) {
        String heroName = arguments.get(2);
        String itemName = arguments.get(1);
        Item item = new CommonItem(itemName,Integer.parseInt(arguments.get(3)),
                Integer.parseInt(arguments.get(4)),Integer.parseInt(arguments.get(5)),
                Integer.parseInt(arguments.get(6)),Integer.parseInt(arguments.get(7)));
        this.heroes.get(heroName).addItem(item);
        return String.format("Added item - %s to Hero - %s",itemName,heroName);
    }

    @Override
    public String addRecipe(List<String> arguments) {
        List<String> neededItems = arguments.subList(8,arguments.size());
        String heroName = arguments.get(2);
        String recipeName = arguments.get(1);
        Recipe recipe = new RecipeItem(recipeName,Integer.parseInt(arguments.get(3)),
                Integer.parseInt(arguments.get(4)),Integer.parseInt(arguments.get(5)),
                Integer.parseInt(arguments.get(6)),Integer.parseInt(arguments.get(7)),
                neededItems);
        this.heroes.get(heroName).addRecipe(recipe);
        return String.format("Added recipe - %s to Hero - %s",recipeName,heroName);
    }

    @Override
    public String inspect(List<String> arguments) {
        String heroName = arguments.get(1);
        HeroImpl hero = (HeroImpl) this.heroes.get(heroName);
        return hero.toString();
    }

    @Override
    public String quit() {
        return "NotReady";
    }
}
