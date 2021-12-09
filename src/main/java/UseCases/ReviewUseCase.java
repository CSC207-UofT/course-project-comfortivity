package UseCases;

import Entities.Building;
import Entities.Review;
import Entities.User;

import java.util.ArrayList;

public class ReviewUseCase {

    ReviewDataInterface reviewDataInterface;

    public static Review loadReview(int rating, String comment) {
        return new Review(rating, comment);
    }

    public static void review(User user, Building building, Review review, ReviewDataInterface rdi){
        user.updateReviews(building, review);
        building.addReview(review);
        rdi.addReviewInfo(user, building, review);
    }

    /**
     * Returns an ArrayList of all reviews for a building.
     * @param code code of the building we want to see reviews of
     * @param rdi ReviewDataInterface
     * @return an ArrayList of all reviews for building specified by code
     */
    public ArrayList<Review> loadReviews(String code, ReviewDataInterface rdi) {
        return rdi.retrieveReviews(code);
    }
}
