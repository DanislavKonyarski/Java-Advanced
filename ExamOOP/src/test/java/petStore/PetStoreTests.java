package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTests {

    private PetStore petStore;

    @Before
    public void Create() {
        petStore = new PetStore();
    }

    @Test
    public void testGetAnimals() {
        Animal animal = new Animal("Kari", 5, 100);
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        petStore.addAnimal(animal);
        assertEquals(animals, petStore.getAnimals());
    }

    @Test
    public void testGetCount() {
        Animal animal = new Animal("Kari", 5, 100);
        petStore.addAnimal(animal);
        assertEquals(1, petStore.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms() {
        Animal animal = new Animal("Kari", 5, 100);
        petStore.addAnimal(animal);
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        assertEquals(animals, petStore.findAllAnimalsWithMaxKilograms(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimal() {
        petStore.addAnimal(null);
    }

    @Test
    public void testGetTheMostExpensiveAnimal() {
        Animal animal = new Animal("Kari", 5, 100);
        Animal animal1 = new Animal("Kudjo",20,5);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal1);
        assertEquals(animal,petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testFindAllAnimalBySpecie(){
        Animal animal = new Animal("Kari", 5, 100);
        Animal animal1 = new Animal("Kudjo",20,5);
        petStore.addAnimal(animal);
        petStore.addAnimal(animal1);
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        assertEquals(animals,petStore.findAllAnimalBySpecie("Kari"));

    }
}

