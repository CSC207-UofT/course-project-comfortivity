import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class DataManager {

    public static void updateNewReview(int id, Review review, Building building) {
        // Take the new review, the building for which the review is, and user's student number
        // to update the review for that user or add a review for that building if not already there in the file.
        // THIS IS TEMPORARY.
    }

    public static void updateNewUser(int id, String name) {
        // Take the new user's student number and name to update the name of the user with that student number or
        // add the student number with the name if it doesn't exist already in the file.
        // THIS IS TEMPORARY.

    }

    public static ArrayList<Object> profileReturn(int studentNumber) {
        // Load the data from the given file corresponding to the student with number studentNumber
        // into a Collection object info and return it.
        // THIS IS TEMPORARY.
        ArrayList<Object> studentdata = new ArrayList<Object>();
        return studentdata;
    }

    public static ArrayList<Object> buildingReturn() {
        // Load all the data for the buildings from the given file as elements of a Collection object, with each
        // element corresponding to a building's information.
        // THIS IS TEMPORARY.
        ArrayList<Object> buildings = new ArrayList<Object>();
        return buildings;
    }
}