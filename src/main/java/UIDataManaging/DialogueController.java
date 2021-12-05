package UIDataManaging;

import Entities.Building;
import Entities.Review;
import Entities.User;
import Entities.schoolMap;
import Requests.NewReviewRequest;
import Requests.NewUserRequest;
import Requests.RetrieveProfileRequest;
import Requests.SearchRequest;
import UseCases.SearchUseCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DialogueController {


    public static User beginLoginSequence() throws IOException, InterruptedException {

        String ans1 = UIController.askTheUser("Do you have an account? Y/N");
        //reads string
        if (ans1.equals("N")) {
            return newprofile();

        } else if (ans1.equals("Y")) {
            User userinfo = retrieveprofile();
            return userinfo;
        } else {
            UIController.askTheUser("Please type Y or N");
            if (ans1.equals("N")) {
                return newprofile();

            } else {
                User userinfo = retrieveprofile();
                return userinfo;
            }}
    }


    private static ArrayList<Building> initiate_search(User userprofile, schoolMap campusMap) throws IOException, InterruptedException {
        String checkLocation = new String();
        //move to SearchUseCase
        List<String> validLocations = Arrays.asList("A1", "B1", "C1", "D1", "E1", "F1",
                "A2", "B2", "C2", "D2", "E2", "F2",
                "A3", "B3", "C3", "D3", "E3", "F3",
                "A4", "B4", "C4", "D4", "E4", "F4",
                "A5", "B5", "C5", "D5", "E5", "F5");
        while (!validLocations.contains(checkLocation)){
            checkLocation = UIController.askForLocation();
        }


        userprofile.setLocation(checkLocation);
        userprofile.setPreferences(UIController.askForPreferences());
        Scanner sc = new Scanner(System.in);
        String activity = UIController.askTheUser("What's your next main activity. study chill or eat");


        int search_radius = Integer.valueOf(UIController.askTheUser("What search radius would you want"));
        SearchRequest searchRequest = new SearchRequest(userprofile,
                search_radius, campusMap);
        ArrayList<Building> preference_building_list = SearchUseCase.search(searchRequest);

        return preference_building_list;

// initiate search, get filters
    }

    public static void takeUserOrders(User userProfile, schoolMap campusMap) throws IOException, InterruptedException {

        String user_choice = UIController.askTheUser("What would you like to do next? Type SEARCH or REVIEW");
        if (user_choice == "SEARCH") {
            ArrayList<Building> building_selections = (ArrayList<Building>) initiate_search(userProfile, campusMap);
            if (building_selections.size() == 0 ){
                UIController.askTheUser("No results found.");

            }
            UIController.displaySearchResultFrame(building_selections);
            //Fully implement according to the above this is skeleton
        } else if (user_choice == "REVIEW") {
            initiate_review(userProfile, campusMap);

        } else {
            takeUserOrders(userProfile, campusMap);
        }

    }

    private static void initiate_review(User userProfile, schoolMap campusMap) throws IOException, InterruptedException {
        Building buildingToReview = UIController.getBuildingToReview(campusMap);
        Review review = UIController.getThemToReview(buildingToReview);
        NewReviewRequest newReviewRequest = new NewReviewRequest(userProfile.getStudentNumber(), review,
                buildingToReview);
        //move out to a usecase
        //todo MAKE THIS THEN ADD THE REQUEST TO THE STUFF
    }

    private static User newprofile() throws IOException, InterruptedException {
        //move to UserUseCase
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        int student_number = Integer.valueOf(UIController.askTheUser("What's your student number"));//reads input
        String name = UIController.askTheUser("What's your Full Name");
        NewUserRequest UserRequestToPass = new NewUserRequest(student_number, name);
        UIController.processRequest(UserRequestToPass);

        return new User(name, student_number);
    }


    private static User retrieveprofile() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        // move to UserUseCase
        int student_number= Integer.valueOf(UIController.askTheUser("What's your student number"));
        RetrieveProfileRequest retrieveProfileRequest = new RetrieveProfileRequest(student_number);

        return UIController.processRequest(retrieveProfileRequest); // return[student_number, name]
    }

}
