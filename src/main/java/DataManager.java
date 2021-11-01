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

    public static schoolMap loadMapFromFile(){
        schoolMap mapToReturn = new schoolMap();
        return mapToReturn;

    }

    public static void updateNewUser(int id, String name) {
        // Take the new user's student number and name to update the name of the user with that student number or
        // add the student number with the name if it doesn't exist already in the file.
        // THIS IS TEMPORARY.

    }

    public static User profileReturn(int studentNumber) {
        // Load the data from the given file corresponding to the student with number studentNumber
        // into a Collection object info and return it.
        // THIS IS TEMPORARY.
        User studentdata = new User("jeff", 100);
        return studentdata;
    }

    public static ArrayList<Building> buildingReturn() {
        // Load all the data for the buildings from the given file as elements of a Collection object, with each
        // element corresponding to a building's information.
        // THIS IS TEMPORARY.
        ArrayList<Building> buildings = new ArrayList<Building>();
        return buildings;
    }
}
