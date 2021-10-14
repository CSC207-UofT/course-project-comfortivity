import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class BuildingTest {
    Building bldg;

    @Before
    public void setUp() {
        bldg = new Building();
    }

    @Test(timeout = 50)
    public void testCreateBuilding() {
        newBLDG = new Building("Whitney Hall", "85 St George St");
        attributes = newBLDG.getAttributes();
        assert attributes.get("address") == "Whitney Hall"
    }
}