package UseCases;

import Entities.Building;
import Entities.Review;
import Entities.User;

import java.util.ArrayList;

/**
 * Interface for ReviewGateway as part of the dependency injection design pattern to invert the dependency
 * between ReviewUseCase and ReviewGateway
 */

public interface ReviewDataInterface {

    void addReviewInfo(User user, Building building, Review review);

    ArrayList<Review> retrieveReviews(String code);


}
