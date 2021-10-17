import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class User {
    public int studentNumber;
    private String name;
    private String location;
    private HashMap reviews;
    private HashMap preferences;

    public User(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.location = "";
        // this.reviews = new HashMap<Building, Review>();
        this.preferences = new HashMap<String, Object>();
    }

    public void updatePrefernces(String key, boolean whetherNeeded) {
        this.preferences.put(key, whetherNeeded);
    }

    public int getStudentNumber() {
        return this.studentNumber;
    }
    public HashMap getPreferences(){
        return this.preferences;
    }
    public String getName(){
        return this.name;
    }
    public static User load_user(int studentNumber) {
        // info will be some sort of collection, don't exactly know how it'll be so i'll parse later I guess.


        //info = DataManager.ProfileReturn(studentNumber);
        //return new User(info);

        // THIS IS JUST TEMPORARY

        return new User("Michael", 3);
    }
    
}