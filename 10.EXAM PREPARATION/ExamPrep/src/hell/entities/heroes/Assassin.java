package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Assassin extends HeroImpl {
  // private static final int STRENGTH = 25;
  // private static final int AGILITY = 100;
  // private static final int INTELLIGENCE = 15;
  // private static final int HIT_POINTS = 150;
  // private static final int DAMAGE = 300;

    public Assassin(String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {
        super(name, strength, agility, intelligence, hitPoints, damage, inventory);
    }


    // public Assassin(String name) {
  //     super(name);
  //     this.setName(name);
  //     this.setStrength(Assassin.STRENGTH);
  //     this.setAgility(Assassin.AGILITY);
  //     this.setIntelligence(Assassin.INTELLIGENCE);
  //     this.setHitPoints(Assassin.HIT_POINTS);
  //     this.setDamage(Assassin.DAMAGE);
  // }
}
