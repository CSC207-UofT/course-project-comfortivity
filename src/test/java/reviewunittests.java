import Entities.Review;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

class ReviewTest {
    Review review;

    public static void main(String[] args) {
        ReviewTest hey = new ReviewTest();
        hey.setUp();
        hey.testCreateReview();
    }
    @Before
    public void setUp() {
        review = new Review();
    }

    @Test
    public void testCreateReview() {
        Review newREVIEW = new Review("5", "decent study area");
        assertEquals(attributes.get("rate"), "5");
        System.out.println("nice");
    }
    public void testCreateReview() {
        Review newREVIEW = new Review("0", "dont come");
        assertEquals(attributes.get("comment"), "dont come");
        System.out.println("nice");
    }
}