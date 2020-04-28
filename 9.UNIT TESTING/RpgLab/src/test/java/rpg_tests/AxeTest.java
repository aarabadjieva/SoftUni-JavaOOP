package rpg_tests;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;
import static rpg_tests.Constants.*;

public class AxeTest {

    private Dummy dummy;

    @Before
    public void beforeEach(){
         dummy = new Dummy(BASE_HP,BASE_XP);
    }

    @Test
    public void axeShouldLoseDurabilityAfterAttack(){
        Axe axe = new Axe(BASE_ATTACK,BASE_DURABILITY);
        axe.attack(dummy);
        assertEquals("Axe durability after attack is not correct",BASE_DURABILITY-1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void axeCannotAttackIfBroken(){
        Axe axe = new Axe(BASE_ATTACK,1);
        axe.attack(dummy);
        axe.attack(dummy);
    }
}
