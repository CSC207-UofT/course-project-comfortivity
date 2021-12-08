package Entities;

import Requests.NewUserRequest;
import Requests.RetrieveProfileRequest;

import java.util.HashMap;

public class UserBuilderDirector {
    // The Director class for the Builder design pattern of the User class. This acts as an extra layer of encapsulation,
    // as the client code would make calls to this method instead of directly to the User class, but also carry out more
    // complex calls than the builder class would, like instantiating a whole instance of User, depending on the amount
    // information given.
    UserBuilder builder;

    public UserBuilderDirector(UserBuilder userBuilder) {
        this.builder = userBuilder;
    }

    public User startUserBuild(int studentId, String name){
        builder.loadStudentNumber(studentId);
        builder.loadName(name);
        return builder.returnUser();
    }

    public User startUserBuild(int student_id, String name, String curr_location,
                               HashMap<Building, String> reviews, HashMap<String, Boolean> preferences){
        builder.loadStudentNumber(student_id);
        builder.loadName(name);
        builder.loadCurrLocation(curr_location);
        builder.loadReviews(reviews);
        builder.loadPreferences(preferences);
        return builder.returnUser();
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
