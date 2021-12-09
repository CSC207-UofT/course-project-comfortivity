package UseCases;

import Entities.Building;
import Entities.Review;
import Entities.User;

public class ReviewUseCase {

    public static void review(User user, Building building, Review review){
        user.updateReviews(building, review);
        building.addReview(review);


    }
}
