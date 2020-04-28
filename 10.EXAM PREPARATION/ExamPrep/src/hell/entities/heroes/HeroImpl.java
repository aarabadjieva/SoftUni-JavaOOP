package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.*;

public abstract class HeroImpl implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

     HeroImpl(String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

   // HeroImpl(String name) {
   //     this.name = name;
   //     this.setInventory();
   // }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    protected void setAgility(int agility) {
        this.agility = agility;
    }

    protected void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    protected void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

    protected void setInventory() {
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength;
    }

    @Override
    public long getAgility() {
        return this.agility;
    }

    @Override
    public long getIntelligence() {
        return this.intelligence;
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints;
    }

    @Override
    public long getDamage() {
        return this.damage;
    }

    @Override
    public Collection<Item> getItems() {

       Map<String,Item> items = new LinkedHashMap<>();
    //  try {
    //      Field field =this.inventory.getClass()
    //              .getDeclaredField("commonItems");
    //      field.setAccessible(true);
//
    //       items = (LinkedHashMap<String, Item>) field.get(this.inventory);
    //  }catch (NoSuchFieldException|IllegalAccessException e){
//
    //  }
//

        return new ArrayList<Item>(items.values());
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

   //@Override
   //public String toString() {
   //    long totalHitPoints = this.getHitPoints() + this.inventory.getTotalHitPointsBonus();
   //    long totalDamage = this.getDamage() + this.inventory.getTotalDamageBonus();
   //    long totalStrength = this.getStrength() + this.inventory.getTotalStrengthBonus();
   //    long totalAgility = this.getAgility() + this.inventory.getTotalAgilityBonus();
   //    long totalIntelligence = this.getIntelligence() + this.inventory.getTotalIntelligenceBonus();

   //    return String.format("Hero: %s, Class: %s%n" +
   //            "HitPoints: %d, Damage: %d%n" +
   //            "Strength: %d%n" +
   //            "Agility: %d%n" +
   //            "Intelligence: %d%n" +
   //            "%s",this.getName(),
   //            this.getClass().getSimpleName(),
   //            totalHitPoints,totalDamage,
   //            totalStrength, totalAgility,
   //            totalIntelligence,this.inventory.toString());
   //}

}
