package Requests;

import Entities.Building;
import Entities.Review;
import Interfaces.InterfaceRequest;

public class NewReviewRequests implements InterfaceRequest {
    // Request class that contains information to process needed for the code to process new reviews
    public int student_id;
    public Review review;
    public Building revbuilding;

    public NewReviewRequests(int studentNumber, Review review, Building buildingToReview) {
        this.student_id = studentNumber;
        this.review = review;
        this.revbuilding = buildingToReview;
    }
}
