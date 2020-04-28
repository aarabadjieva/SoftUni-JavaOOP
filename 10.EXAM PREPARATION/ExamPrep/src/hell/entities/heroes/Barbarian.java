package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Barbarian extends HeroImpl {
  //  private static final int STRENGTH = 90;
  //  private static final int AGILITY = 25;
  //  private static final int INTELLIGENCE = 10;
  //  private static final int HIT_POINTS = 350;
  //  private static final int DAMAGE = 150;

    public Barbarian(String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {
        super(name, strength, agility, intelligence, hitPoints, damage, inventory);
    }

  // public Barbarian(String name) {
  //     super(name);
  //     this.setName(name);
  //     this.setStrength(Barbarian.STRENGTH);
  //     this.setAgility(Barbarian.AGILITY);
  //     this.setIntelligence(Barbarian.INTELLIGENCE);
  //     this.setHitPoints(Barbarian.HIT_POINTS);
  //     this.setDamage(Barbarian.DAMAGE);
  //}

}
