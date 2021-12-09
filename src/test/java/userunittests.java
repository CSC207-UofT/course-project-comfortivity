import Entities.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

class UserTest {
    User user;
    UserBuilder userBuilder;
    UserBuilderDirector userBuilderDirector;

    public static void main(String[] args) {
        UserTest hey = new UserTest();
        hey.setUp();
        hey.testCreateUser();
    }

    @Before
    public void setUp() {
        userBuilder = new UserBuilder();
        userBuilderDirector = new UserBuilderDirector(userBuilder);
    }

    @Test
    public void testCreateUser() {
        user = userBuilderDirector.startUserBuild(10027378, "Mary");
        assertEquals(user.getName(), "Mary");
        assertEquals(user.getStudentNumber(), 10027378);
        System.out.println("Works");
    }

    public void testCreateUserLarge() {
        Review review = new Review(1, "Good");
        HashMap<Building, Review> reviewmap = new HashMap<>();
        HashMap<String, Boolean> preferences = new HashMap<>();
        user = userBuilderDirector.startUserBuild(10027378, "Mary", "81 St. Mary Street", reviewmap, preferences);
        assertEquals(user.getName(), "Mary");
        assertEquals(user.getStudentNumber(), 10027378);
        System.out.println("Works");
    }
}