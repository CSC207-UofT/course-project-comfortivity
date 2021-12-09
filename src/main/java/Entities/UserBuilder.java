package Entities;

import Entities.Building;
import Entities.User;
import Interfaces.UserBuilderInterface;

import java.util.HashMap;

public class UserBuilder implements UserBuilderInterface {
    // the builder class for the User class which has a slew of methods that update the User class which allows client
    // code to update a single User instance without actually making direct calls to the User instance

    private final User user = new User();


    public void loadStudentNumber(int student_number){
        user.setStudentNumber(student_number);
    }

    public void loadName(String name) {
        user.setName(name);
    }
    public void loadCurrLocation(String curr_location){
        user.setLocation(curr_location);
    }
    public void loadReviews(HashMap<Building, Review> building_to_review){
        user.setReviews(building_to_review);
    }

    public void addUserReview(Building building, Review review){
        user.updateReviews(building, review);
    }

    public void loadPreferences(HashMap<String, Boolean> user_preferences){
        user.setPreferences(user_preferences);
    }

    public void addUserPreferences(String filters, Boolean yesnos){
        user.updatePreferences(filters, yesnos);
    }

    public User returnUser(){
        return user;
    }
}