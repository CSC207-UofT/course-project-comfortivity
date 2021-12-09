package UIDataManaging;

import Entities.*;
import Gateways.schoolMap;
import Requests.NewUserRequest;
import Requests.RetrieveProfileRequest;
import Requests.SearchRequest;
import UseCases.BuildingUseCase;
import UseCases.ReviewUseCase;
import UseCases.SearchUseCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DialogueController {


    public static User beginLoginSequence() throws IOException, InterruptedException
    /**
     * walks the user through the process of making their account or logging into it
     */
    {

        String ans1 = UIController.askTheUser("Do you have an account? Y/N");
        //reads string
        if (ans1.equals("N")) {
            return newProfile();

        } else if (ans1.equals("Y")) {
            return retrieveProfile();
        } else {
            ans1 = UIController.askTheUser("Please type Y or N");
            if (ans1.equals("N")) {
                return newProfile();

            } else {
                return retrieveProfile();
            }}
    }


    private static ArrayList<Building> initiate_search(User userprofile, schoolMap campusMap) throws IOException, InterruptedException
    /**
     * starts to guide the user through the search function, asking the requisite questions, etc
     */
    {
        String checkLocation = new String();
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
        // String activity = UIController.askTheUser("What's your next main activity. study chill or eat");


        int search_radius = Integer.valueOf(UIController.askTheUser("What search radius would you want"));
        SearchRequest searchRequest = new SearchRequest(userprofile,
                search_radius, campusMap);

        return SearchUseCase.search(userprofile, search_radius);


// initiate search, get filters
    }

    public static void takeUserOrders(User userProfile, schoolMap campusMap) throws IOException, InterruptedException
    /**
     * asks the user whether they want to search or review, then does that
     */
    {

        String user_choice = UIController.askTheUser("What would you like to do next? Type SEARCH or REVIEW");
        if (user_choice.equals("SEARCH")) {
            ArrayList<Building> building_selections = initiate_search(userProfile, campusMap);
            if (building_selections.size() == 0 ){
                UIController.askTheUser("No results found.");

            }
            UIController.displaySearchResultFrame(building_selections);
            //Fully implement according to the above this is skeleton
        } else if (user_choice.equals("REVIEW")) {
            initiate_review(userProfile, campusMap);


        } else {
            takeUserOrders(userProfile, campusMap);
        }

    }

    private static void initiate_review(User userProfile, schoolMap campusMap) throws IOException, InterruptedException
    /**
     * starts to guide the user through the review process
     */
    {
        Building buildingToReview = BuildingUseCase.getBuildingToReview(campusMap);
        Review review = UIController.getThemToReview(buildingToReview);
        DataManager.updateNewReview(userProfile.getStudentNumber(), review, buildingToReview);
        ReviewUseCase.review(userProfile, buildingToReview, review);
    }

    private static User newProfile() throws IOException, InterruptedException
    /**
     * guides the user through making a profile
     */
    {
        //creates new instances of user
        UserBuilder userBuilder = new UserBuilder();
        UserBuilderDirector userBuilderDirector = new UserBuilderDirector(userBuilder);

        //move to UserUseCase
        int student_number = Integer.valueOf(UIController.askTheUser("What's your student number"));//reads input
        String name = UIController.askTheUser("What's your Full Name");
        NewUserRequest UserRequestToPass = new NewUserRequest(student_number, name);
        UIController.processRequest(UserRequestToPass);

        return userBuilderDirector.startUserBuild(student_number, name);
//        return new User(name, student_number);
    }


    private static User retrieveProfile() throws IOException, InterruptedException
    /**
     * walks the user through logging in
     */
    {

        // move to UserUseCase
        int student_number= Integer.valueOf(UIController.askTheUser("What's your student number"));
        RetrieveProfileRequest retrieveProfileRequest = new RetrieveProfileRequest(student_number);

        return UIController.processRequest(retrieveProfileRequest); // return[student_number, name]
    }

}
