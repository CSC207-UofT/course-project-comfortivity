import Entities.Review;
import Entities.User;
import Entities.UserBuilder;
import Entities.UserBuilderDirector;
import Entities.Building;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

class UserTest {
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

        User user = userBuilderDirector.startUserBuild(1005637, "Nnamdi Azikiwe");
        assertEquals(user.getStudentNumber(), 1005637);
        assertEquals(user.getName(), "Nnamdi Azikiwe");
        System.out.println("Works");
    }

    public void testCreateUserLarge() {
        HashMap<Building, String> reviews = new HashMap<>();
        HashMap<String, Boolean> preferences = new HashMap<>();
        User user = userBuilderDirector.startUserBuild(1005637, "Nnamdi Azikiwe", "81 St. Maru Stree", reviews, preferences);
        assertEquals(user.getStudentNumber(), 1005637);
        assertEquals(user.getName(), "Nnamdi Azikiwe");
        assertEquals(user.getlocation(), "81 St. Mary Street");
        assertEquals(user.getReviews(), reviews);
        assertEquals(user.getPreferences(), preferences);
    }
}