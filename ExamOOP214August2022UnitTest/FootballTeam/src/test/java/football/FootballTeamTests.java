package football;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FootballTeamTests {
    private Footballer footballer;
    private FootballTeam footballTeam;

    @Before
    public void creadFootballTeam() {
        footballer = new Footballer("Stefan");
        footballTeam = new FootballTeam("team on Stefan", 2);
    }

    @Test(expected = NullPointerException.class)
    public void testCreadFootbalTeamShouldExeptionForInvalidName() {
        footballTeam = new FootballTeam(" ", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreadFootbalTeamShouldExeptionForInvalidVacantPosition() {
        footballTeam = new FootballTeam("team on Stefan", -1);
    }

    @Test
    public void testGetName() {
        assertEquals(footballTeam.getName(), "team on Stefan");
    }

    @Test
    public void testGetVacantPosition() {
        assertEquals(footballTeam.getVacantPositions(), 2);
    }

    @Test
    public void testGetCount() {

        assertEquals(0, footballTeam.getCount());
    }

    @Test
    public void testAddFootball() {
        footballTeam.addFootballer(footballer);
        assertEquals(footballTeam.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerShoulReturnExeption() {
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer);
    }

    @Test
    public void testRemoveFootballer() {
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("Stefan");
        assertEquals(footballTeam.getCount(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerShouldReturnExeption() {
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("Gosho");
    }

    @Test
    public void testFootballerForSale() {
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("Stefan");
        assertEquals(footballer.isActive(), false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testtestFootballerForSaleShouldReturnExeption() {
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale("Gosho");
    }
}
