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
        Review review;
    }

    @Test
    public void testCreateReview() {
        review = new Review(5, "decent study area");
        assertEquals(review.getRating(), 5);
        assertEquals(review.getComment(), "nice");
        System.out.println("Works");
    }
    public void testCreateReviewSet() {
        review = new Review(0, "dont come");
        review.setComment("Please come");
        review.setRating(0);
        assertEquals(review.getRating(), 0);
        assertEquals(review.getComment(), "Please come");
        System.out.println("nice");
    }
}