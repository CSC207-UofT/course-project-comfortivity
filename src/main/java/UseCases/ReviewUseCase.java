package UseCases;

import Entities.Building;
import Entities.Review;
import Entities.User;

import java.util.ArrayList;

public class ReviewUseCase {

    ReviewDataInterface reviewDataInterface;

    /**
     * Instantiates Review with rating and comment
     * @param rating the star_rating of a Review
     * @param comment the comment of a Review
     * @return returns an instance of Review with rating and comment
     */
    public static Review loadReview(int rating, String comment) {
        return new Review(rating, comment);
    }

    /**
     * Adds review to User and Building instances and also the database
     * @param user user is the author of the review
     * @param building the building being reviewed
     * @param review the review written by the user for the building
     * @param rdi ReviewDataInterface
     */
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
