package Entities.Users;
import java.util.HashMap;

public class UserData implements java.io.Serializable {
    public String studentNumber;
    private String name;
    private String location;
    private HashMap reviews;
    private HashMap preferences;

    public UserData(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.location = "";
        // this.reviews = new HashMap<Building, Review>();
        this.preferences = new HashMap<String, Object>();
    }

    public UserData() {
    }

    public boolean check_password(String studentNumber){
        return studentNumber.equals(studentNumber);
    }

    // Setter methods
    public void setName(String name){this.name = name;}
    public void setStudentNumber(String studentNumber){this.studentNumber = studentNumber;}
    public void setLocation(String location){this.location = location;}
    public void setPreferences(String key, boolean whetherNeeded) {
        this.preferences.put(key, whetherNeeded);
    }

    // Getter methods
    public String getName(){
        return this.name;
    }
    public String getStudentNumber() {
        return this.studentNumber;
    }
    public String userInfo() {
        return "User Name: " + this.name + "\n" +
                "student number: " + this.studentNumber + "\n" +
                "Location: " + this.location + "\n" +
                "Reviews: " + this.reviews +
                "Preferences: " + this.preferences;
    }


    public void updatePrefernces(String key, boolean whetherNeeded) {
        this.preferences.put(key, whetherNeeded);
    }

    public HashMap getPreferences(){
        return this.preferences;
    }
    public void setPreferences(HashMap preferences){
        this.preferences = preferences;
    }


    public boolean checkPassword(String input_password) {
        return studentNumber.equals(input_password);
    }
    
}
