package magicGameTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MagicianTests {

    private Magic magicMeri;
    private Magic magicGaby;
    private Magician magician;

    @Before
    public void create() {
        magicMeri = new Magic("Dani", 2);
        magicGaby = new Magic("Gaby", 2);
        magician = new Magician("Meri", 50);
    }

    @Test(expected = NullPointerException.class)
    public void createShouldException() {
        magician = new Magician("  ", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldExceptionHealth() {
        magician = new Magician("Dani", -1);
    }

    @Test
    public void testGetUsername() {
        assertEquals(magician.getUsername(), "Meri");
    }

    @Test
    public void testGetHealth() {
        assertEquals(50, magician.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicShouldException() {
        magician.addMagic(null);
    }

    @Test
    public void testRemoveMagic() {
        magician.addMagic(magicMeri);
        magician.removeMagic(magicMeri);
        assertEquals(0, magician.getMagics().size());
    }

    @Test
    public void testGetMagic(){
        magician.addMagic(magicMeri);
        magician.addMagic(magicGaby);
        assertEquals(magicGaby,magician.getMagic("Gaby"));
    }
    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldException(){
        magician.takeDamage(51);
        magician.takeDamage(10);
    }
    @Test
    public void testTakeDamage() {
        magician.takeDamage(10);
        assertEquals(magician.getHealth(),40);
    }

}