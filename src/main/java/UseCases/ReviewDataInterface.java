package UseCases;

import Entities.Building;
import Entities.Review;
import Entities.User;

import java.util.ArrayList;

public interface ReviewDataInterface {

    void addReviewInfo(User user, Building building, Review review);

    ArrayList<Review> retrieveReviews(String code);


}
