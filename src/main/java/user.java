import java.util.Map;
import java.util.List;

public class User {
    private int studentNumber;
    private String name;
    private String location;
    private HashMap reviews;
    private HashMap preferences;

    public User(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.location = "";
        this.reviews = new HashMap<Building, Review>();
        this.preferences = new HashMap<String, boolean>;
    }

    public void updatePrefernces(String key, boolean whetherNeeded) {
        this.preferences.push(key, whetherNeeded)
    }
    
    public void HashMap getPreferences(){
        return this.preferences
    }
    
}