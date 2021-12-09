import Entities.Building;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

class BuildingTest {
    Building bldg;

    public static void main(String[] args) {
        BuildingTest hey = new BuildingTest();
        hey.setUp();
        hey.testCreateBuilding();
    }
    @Before
    public void setUp() {
        bldg = new Building();
        bldg.setName("Sorbara");
        bldg.setAddress("81 St. Mary Street");
    }



    @Test
    public void testCreateBuilding() {
        assertEquals(bldg.getCode(), "");
        assertEquals(bldg.getName(), "Sorbara");
        assertEquals(bldg.getAddress(), "81 St. Mary Street");
        System.out.println("Works");
    }
}