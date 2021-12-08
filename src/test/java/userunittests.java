import Entities.User;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

class UserTest {
    User user;

    public static void main(String[] args) {
        UserTest hey = new UserTest();
        hey.setUp();
        hey.testCreateUser();
    }
    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void testCreateUser() {
        User newUSER = new User("Mary", "1002345678");
        assertEquals(attributes.get("name"), "Mary");
        System.out.println("gotit");
    }
    public void testCreateUser() {
        User newUSER = new User("Peter", "1009876543");
        assertEquals(attributes.get("studentNumber"), "1009876543");
        System.out.println("gotit");
}