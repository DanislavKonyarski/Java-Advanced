package robotsTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceTests {
    private Service service;
    private Robot robot;

    @Before
    public void createService(){
        service = new Service("Pesho",2);
        robot = new Robot("Gosho");
    }

    @Test(expected = NullPointerException.class)
    public void createServiceShouldExceptionName(){
        service = new Service(" ",2);
    }
    @Test(expected = NullPointerException.class)
    public void createServiceShouldExceptionNameNull(){
        service = new Service(null,2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createServiceShouldExceptionCapacity(){
        service = new Service("Pesho",-1);
    }
    @Test
    public void testGetName(){
        assertEquals("Pesho",service.getName());
    }

    @Test
    public void testGetCapacity(){
        assertEquals(2,service.getCapacity());
    }

    @Test
    public void testGetCount(){
        service.add(robot);
        assertEquals(1, service.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldException(){
        service.add(robot);
        service.add(new Robot("Tosho"));
        service.add(new Robot("Pepi"));
    }

    @Test
    public void testAdd() {
        service.add(robot);
        service.add(new Robot("Tosho"));
        assertEquals(2,service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldException() {
        service.add(robot);
        service.add(new Robot("Tosho"));
        service.remove("Meri");
    }
    @Test
    public void testRemove() {
        service.add(robot);
        service.add(new Robot("Tosho"));
        service.remove("Tosho");
        assertEquals(1,service.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testForSaleShouldException() {
        service.add(robot);
        service.add(new Robot("Tosho"));
        service.forSale("Meri");
    }
    @Test
    public void testForSle() {
        service.add(robot);
        service.add(new Robot("Tosho"));
        service.forSale("Gosho");
        assertFalse(robot.isReadyForSale());
    }

}
