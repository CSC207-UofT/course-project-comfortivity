import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.HashMap;

import static org.junit.Assert.*;

class BuildingTest {
    Building bldg;

    @Before
    public void setUp() {
        bldg = new Building();
    }

    @Test(timeout = 50)
    public void testCreateBuilding() {
        Building newBLDG = new Building("Whitney Hall", "85 St George St");
        HashMap attributes = newBLDG.getAttributes();
        assert attributes.get("address") == "Whitney Hall";
    }
}