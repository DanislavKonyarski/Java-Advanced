package toyStore;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ToyStoryTest {

    private ToyStore toyStore;
    private Toy toy;

    @Before
    public void create() {
        toyStore = new ToyStore();
        Toy toy = new Toy("Bili","Hlapeto");
    }

    @Test
    public void testGetToyShelf() {
        Map<String, Toy> currentMap = new LinkedHashMap<>();
        currentMap.put("A", null);
        currentMap.put("B", null);
        currentMap.put("C", null);
        currentMap.put("D", null);
        currentMap.put("E", null);
        currentMap.put("F", null);
        currentMap.put("G", null);
        assertEquals(currentMap, toyStore.getToyShelf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShouldExceptionForShelfDoesntExist() throws OperationNotSupportedException {
        toyStore.addToy("Q",toy);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShouldExceptionForShelfIsAlreadyTaken() throws OperationNotSupportedException {
        toyStore.addToy("A",new Toy("aa","BB"));
        toyStore.addToy("A",toy);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyShouldExceptionForToyIsAlreadyInShelf() throws OperationNotSupportedException {
        toyStore.addToy("A",toy);
        toyStore.addToy("A",toy);
    }
    @Test
    public void testAddToy() throws OperationNotSupportedException {
        Toy currentToy = new Toy("AA","BB");
        toyStore.addToy("A",currentToy);
        Map<String, Toy> currentMap = new LinkedHashMap<>();
        currentMap.put("A",currentToy);
        currentMap.put("B", null);
        currentMap.put("C", null);
        currentMap.put("D", null);
        currentMap.put("E", null);
        currentMap.put("F", null);
        currentMap.put("G", null);
        assertEquals(currentMap,toyStore.getToyShelf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShouldExceptionForShelfDoesntExist(){
        toyStore.removeToy("Q",toy);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyShouldExceptionForToyInThatShelfDoesntExists() throws OperationNotSupportedException {
        toyStore.addToy("A",new Toy("AA","VV"));
        toyStore.removeToy("A",toy);
    }
    @Test
    public void testRemoveToy() throws OperationNotSupportedException {
        Toy currentToy = new Toy("AA","BB");
        toyStore.addToy("A",currentToy);
        assertEquals("Remove toy:BB successfully!",toyStore.removeToy("A",currentToy));
    }
}