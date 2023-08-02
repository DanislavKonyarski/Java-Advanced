package archeologicalExcavations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcavationTests {
 private Excavation excavation;
 private Archaeologist archaeologist;
@Before
public void creadExcavation(){
    excavation = new Excavation("Pesho",2);
    archaeologist = new Archaeologist("Gosho", 2.2);
}
    @Test
    public void TestCreateExcavationShouldReturnExeption(){
       Excavation excavation = new Excavation("Pesho",1);
    }
    @Test
    public void testGetCount(){
    excavation.addArchaeologist(archaeologist);
    assertEquals(excavation.getCount(),1);
    }
}
