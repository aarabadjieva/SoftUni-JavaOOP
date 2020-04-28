package rpg_tests;

import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;
import rpg_tests.fakes.FakeAxe;
import rpg_tests.fakes.FakeTarget;

import static org.junit.Assert.assertEquals;
import static rpg_tests.Constants.BASE_XP;

public class HeroTest {

    @Test
    public void shouldReceiveXpWhenTargetDies(){
        Hero hero = new Hero(new FakeAxe(), "Name");
        Target target = new FakeTarget();
        hero.attack(target);
        assertEquals(hero.getExperience(), BASE_XP);
    }

    @Test
    public void shouldGetLootAfterKillingTarget(){
        Weapon loot = new FakeAxe();
        Hero hero = new Hero(new FakeAxe(), "Name");
        Target target = Mockito.mock(Target.class);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.getLoot()).thenReturn(loot);
        hero.attack(target);

        assertEquals(loot, hero.getInventory().get(0));
    }
}
