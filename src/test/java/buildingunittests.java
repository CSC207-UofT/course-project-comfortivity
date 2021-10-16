import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.HashMap;

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
    }

    @Test
    public void testCreateBuilding() {
        Building newBLDG = new Building("Whitney Hall", "85 St George St");
        HashMap attributes = newBLDG.getAttributes();
        assertEquals(attributes.get("address"), "85 St George St");
        System.out.println("eatshit");
    }
}