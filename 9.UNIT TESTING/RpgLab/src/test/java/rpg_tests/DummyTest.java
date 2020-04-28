package rpg_tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;
import static rpg_tests.Constants.*;

public class DummyTest {

    private Dummy dummy;

    @Before
    public void beforeEach(){
        dummy = new Dummy(BASE_HP,BASE_XP);
    }

    @Test
    public void dummyLosesHealthIfAttacked(){
        dummy.takeAttack(BASE_ATTACK);
        assertEquals(BASE_HP-BASE_ATTACK,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsIfDead(){
        dummy.takeAttack(BASE_ATTACK);
        dummy.takeAttack(BASE_ATTACK);
    }

    @Test
    public void deadDummyCanGiveXP(){
        Dummy mocked = Mockito.mock(Dummy.class);
        Mockito.when(mocked.giveExperience()).thenReturn(BASE_XP);
        assertEquals(BASE_XP,mocked.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCannotGiveXP(){
        dummy.giveExperience();
    }
}
