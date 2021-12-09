import Entities.UserBuilderDirector;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.HashMap;

import static org.junit.Assert.*;

class UserBuilderDirectorTest {
    UserBuilderDirector ublderd;

    public static void main(String[] args) {
        UserBuilderDirectorTest hey = new UserBuilderDirectorTest();
        hey.setUp();
        hey.testCreateUserBuilderDirector();
    }
    @Before
    public void setUp() {
        ublderd = new UserBuilderDirector();
    }

    @Test
    public void testCreateUserBuilderDirector() {
        UserBuilderDirector newUBLDERD = new UserBuilderDirector("1002340432", "Tony", "85 St George St",
                "<Whitney Hall, nice", "<food, no>");
        HashMap attributes = newUBLDERD.getAttributes();
        assertEquals(attributes.get("curr_location"), "85 St George St");
        System.out.println("yay");
    }
}