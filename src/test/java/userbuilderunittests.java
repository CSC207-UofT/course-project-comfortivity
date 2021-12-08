import Entities.UserBuilder;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.HashMap;

import static org.junit.Assert.*;

class UserBuilderTest {
    UserBuilder ublder;

    public static void main(String[] args) {
        UserBuilderTest hey = new UserBuilderTest();
        hey.setUp();
        hey.testCreateUserBuilder();
    }
    @Before
    public void setUp() {
        ublder = new UserBuilder();
    }

    @Test
    public void testCreateUserBuilder() {
        UserBuilder newUBLDER = new UserBuilder("1002345432", "Steve", "85 St George St", "<Whitney Hall, bad",
                "<food, no>");
        HashMap attributes = newUBLDER.getAttributes();
        assertEquals(attributes.get("curr_location"), "85 St George St");
        System.out.println("done");
    }
}