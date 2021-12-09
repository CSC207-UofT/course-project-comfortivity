import Entities.Building;
import Entities.Review;
import Entities.User;
import Gateways.schoolMap;
import UseCases.SearchUseCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Search_unit_tests {
    User user;

    public static void main(String[] args) {
        ReviewTest hey = new ReviewTest();
        hey.setUp();
        hey.testCreateReview();
        hey.testCreateReviewSet();
    }
    @Before
    public void setUp() {
        Review review;
        user = new User("Gesi", 10005748);
        user.setLocation("81 St. Mary Street");
        HashMap<String, Boolean> preferences = new HashMap<>();
        preferences.put("Group", true);
        preferences.put("Food", true);
        preferences.put("Water", true);
        preferences.put("Bathroom", true);
        preferences.put("Accessibility", false);
        preferences.put("Privacy", true);
        user.setPreferences(preferences);
        HashMap<Building, Review> reviewMap = new HashMap<>();
        user.setReviews(reviewMap);
    }


    @Test
    public void testSearch() {
//        schoolMap schoolmap = new schoolMap();
        schoolMap schoolmap = schoolMap.retrieveMapInfo();
        ArrayList<Building> searchResult = SearchUseCase.search(user, (float) 50.1, schoolmap);
        System.out.println(searchResult);
    }
}
