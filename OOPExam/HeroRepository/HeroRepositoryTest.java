package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroRepositoryTest {

    private Hero hero;
    private Hero hero2;
    private Item item;
    private Item item2;
    private HeroRepository hp;

    @Before
    public void beforeEach(){
        this.hp = new HeroRepository();
        this.item = Mockito.mock(Item.class);
        Mockito.when(item.getAgility()).thenReturn(5);
        Mockito.when(item.getStrength()).thenReturn(5);
        Mockito.when(item.getIntelligence()).thenReturn(5);
        this.hero = Mockito.mock(Hero.class);
        Mockito.when(hero.getName()).thenReturn("Name");
        Mockito.when(hero.getLevel()).thenReturn(2);
        Mockito.when(hero.getItem()).thenReturn(item);
        this.item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getAgility()).thenReturn(6);
        Mockito.when(item2.getStrength()).thenReturn(6);
        Mockito.when(item2.getIntelligence()).thenReturn(6);
        this.hero2 = Mockito.mock(Hero.class);
        Mockito.when(hero2.getName()).thenReturn("Name");
        Mockito.when(hero2.getLevel()).thenReturn(2);
        Mockito.when(hero2.getItem()).thenReturn(item2);

    }
    @Test
    public void constructorShouldCreate(){
        HeroRepository heroRepository = new HeroRepository();
        assertEquals(0, heroRepository.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addHeroShouldThrowIfDataContainsHero(){
        this.hp.add(this.hero);
        this.hp.add(this.hero);
    }

    @Test
    public void addHeroShouldAddCorrectly(){
        this.hp.add(hero);
        assertEquals(1,this.hp.getCount());
    }

    @Test
    public void removeHeroShouldRemoveCorrectly(){
        this.hp.add(hero);
        this.hp.add(hero2);
        this.hp.remove(hero.getName());
        assertEquals(1, this.hp.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowIfHeroWithThisNameDoesNotExist(){
        this.hp.remove(hero.getName());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowIfThereIsNoBestHero(){
        this.hp.getHeroWithHighestStrength();
    }

    @Test
    public void getHeroWithHighestStrengthShouldFindCorrectBestStrength(){
        this.hp.add(this.hero);
        this.hp.add(this.hero2);
        assertEquals(this.hero2.getItem().getStrength(),
                this.hp.getHeroWithHighestStrength().getItem().getStrength());
    }
    @Test
    public void getHeroWithHighestStrengthShouldReturnCorrectHero(){
        this.hp.add(this.hero);
        this.hp.add(this.hero2);
        assertEquals(this.hero2,this.hp.getHeroWithHighestStrength());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrowIfThereIsNoBestHero(){
        this.hp.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestAgilityShouldReturnCorrectHero(){
        this.hp.add(hero);
        this.hp.add(this.hero2);
        assertEquals(this.hero2,this.hp.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowIfThereIsNoBestHero(){
        this.hp.getHeroWithHighestIntelligence();
    }

    @Test
    public void getHeroWithHighestIntelligenceShouldReturnCorrectHero(){
        this.hp.add(this.hero);
        this.hp.add(this.hero2);
        assertEquals(this.hero2,this.hp.getHeroWithHighestIntelligence());
    }

    @Test
    public void getCountShouldReturnCorrectCount(){
        this.hp.add(hero);
        assertEquals(1,this.hp.getCount());
    }

    @Test
    public void toStringShouldReturnCorrectString(){
        this.hp.add(hero);
        assertEquals(this.hero.toString(),this.hp.toString());
    }


}