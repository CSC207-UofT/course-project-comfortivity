package BuilderClasses;

import Entities.Building;
import Entities.User;
import Interfaces.UserBuilderInterface;

import java.util.HashMap;

public class UserBuilder implements UserBuilderInterface {
    private final User user = new User();

    public User createUser(int student_id, String name){
        this.loadStudentNumber(student_id);
        this.loadName(name);
        return user;
    }

    public User createUser(int student_id){
        this.loadStudentNumber(student_id);
        return user;
    }

    public User createUser(int student_id, String name, String curr_location,
                           HashMap<Building, String> reviews, HashMap<String, Boolean> preferences){
        this.loadStudentNumber(student_id);
        this.loadName(name);
        this.loadCurrLocation(curr_location);
        this.loadReviews(reviews);
        this.loadPreferences(preferences);
        return user;
    }

    public void loadStudentNumber(int student_number){
        user.setStudentNumber(student_number);
    }

    public void loadName(String name) {
        user.setName(name);
    }
    public void loadCurrLocation(String curr_location){
        user.setLocation(curr_location);
    }
    public void loadReviews(HashMap<Building, String> building_to_review){
        user.setReviews(building_to_review);
    }

    public void addUserReview(Building building, String review){
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