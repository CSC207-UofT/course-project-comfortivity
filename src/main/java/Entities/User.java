import java.util.HashMap;

public class User {
    public int studentNumber;
    private String name;
    private String location;
    private HashMap<Building, String> reviews;
    private HashMap<String, Boolean> preferences;


    public User(){}

    public User(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.location = "";
        this.reviews = new HashMap<Building, String>();
        this.preferences = new HashMap<String, Boolean>();
    }


    public void setStudentNumber(int studentNum){
        this.studentNumber = studentNum;
    }

    public String getlocation(){
        return this.location;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCurrLocation(String location){
        this.location = location;
    }

    public void setReviews(HashMap<Building, String> reviews){
        this.reviews = reviews;
    }

    public void setPreferences(HashMap<String, Boolean> preferences){
        this.preferences = preferences;
    }

    public void updatePreferences(String filter, Boolean yesno) {
        this.preferences.put(filter, yesno);
    }

    public void updateReviews(Building key, String review) {
        this.reviews.put(key, review);
    }

    public int getStudentNumber() {
        return this.studentNumber;
    }

    public HashMap<String, Boolean> getPreferences(){
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