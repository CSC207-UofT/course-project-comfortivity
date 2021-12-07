package BuilderClasses;

import BuilderClasses.UserBuilder;
import Entities.Building;
import Requests.NewUserRequest;
import Requests.RetrieveProfileRequest;

import java.util.HashMap;

public class UserBuilderDirector {
    UserBuilder builder;

    public void startUserBuild(NewUserRequest newUserRequest, UserBuilder builder){
        this.builder = builder;
        builder.createUser(newUserRequest.student_id, newUserRequest.name);
    }

    public void startUserBuild(RetrieveProfileRequest retrieveProfileRequest, UserBuilder builder){
        this.builder = builder;
        builder.createUser(retrieveProfileRequest.student_id);
    }

    public void updateUserPreferences(HashMap<String, Boolean> preferences){
        this.builder.loadPreferences(preferences);
    }

    public void addUserPreferences(String filter, Boolean yesno){
        this.builder.addUserPreferences(filter, yesno);
    }

    public void updateUserLocation(String curr_location){
        this.builder.loadCurrLocation(curr_location);
    }

    public void updateUserReviews(HashMap<Building, String> user_reviews){
        this.builder.loadReviews(user_reviews);
    }

    public void addUserReview(Building building, String review){
        this.builder.addUserReview(building, review);
    }
}
