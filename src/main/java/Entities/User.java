package Entities;

import java.util.HashMap;

public class User {
    // an instance of the User class contains the information of the current user under which the code is being run
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
        this.reviews = new HashMap<>();
        this.preferences = new HashMap<>();
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

    public void setLocation(String location){
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

}