package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarShopTests {

    private CarShop carShop;
    private Car car;

    @Before
    public void CreateCarshop(){
        carShop = new CarShop();
        car = new Car("Passat",200,1000.0);
        carShop.add(car);
    }

    @Test
    public void testGetCars(){
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        assertEquals(cars,carShop.getCars());
    }
    @Test
    public void testGetCount(){
    assertEquals(1,carShop.getCount());
    }
    @Test
    public void testFindAllCarsWithMaxHorsePower(){
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        assertEquals(cars,carShop.findAllCarsWithMaxHorsePower(199));
    }

    @Test(expected =  NullPointerException.class)
    public void testAddShouldThrowException(){
        carShop.add(null);
    }
    @Test
    public void testAdd(){
        carShop.add(new Car("Ford",50,100));
        assertEquals(2,carShop.getCount());
    }

    @Test
    public void testRemove(){
        carShop.remove(car);
        assertEquals(0,carShop.getCount());
    }
    @Test
    public void testGetTheMostLuxuryCar(){
        carShop.add(new Car("Ford",50,100));
        assertEquals(car,carShop.getTheMostLuxuryCar());
    }

    @Test
    public void testFindAllCarByModel(){
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        assertEquals(cars,carShop.findAllCarByModel("Passat"));
    }
}

