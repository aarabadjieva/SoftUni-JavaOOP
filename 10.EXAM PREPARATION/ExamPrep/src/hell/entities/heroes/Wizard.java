package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Wizard extends HeroImpl {
   //private static final int STRENGTH = 25;
   //private static final int AGILITY = 25;
   //private static final int INTELLIGENCE = 100;
   //private static final int HIT_POINTS = 100;
   //private static final int DAMAGE = 250;

    public Wizard(String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {
        super(name, strength, agility, intelligence, hitPoints, damage, inventory);
    }


    // public Wizard(String name) {
   //     super(name);
   //     this.setName(name);
   //     this.setStrength(Wizard.STRENGTH);
   //     this.setAgility(Wizard.AGILITY);
   //     this.setIntelligence(Wizard.INTELLIGENCE);
   //     this.setHitPoints(Wizard.HIT_POINTS);
   //     this.setDamage(Wizard.DAMAGE);
   // }
}
