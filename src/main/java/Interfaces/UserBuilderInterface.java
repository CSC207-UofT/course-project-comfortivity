package Interfaces;

import Entities.Building;

import java.util.HashMap;

public interface UserBuilderInterface {
    void loadStudentNumber(int student_number);
    void loadName(String name);
    void loadCurrLocation(String name);
    void loadReviews(HashMap<Building, String> reviews);
    void loadPreferences(HashMap<String, Boolean> Preferences);
}