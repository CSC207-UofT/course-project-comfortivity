package UIDataManaging;

import java.io.IOException;
import java.util.*;

import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;
import Interfaces.*;
import Mapping.*;

public class Main {
    private static User user_Profile;
    private static Collection<Building> BuildingList;

//    public CLI(){
//        UserProfile = null;
//        BuildingList = null;
//    }
//    public CLI(User userprofile, Collection<Building> buildinglist){
//        UserProfile = userprofile;
//        BuildingList = buildinglist;
//    }

    private static User newprofile() throws IOException, InterruptedException {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        int student_number = Integer.valueOf(UIController.askTheUser("What's your student number"));//reads input
        String name = UIController.askTheUser("What's your Full Name");
        NewUserRequest UserRequestToPass = new NewUserRequest(student_number, name);
        UIController.processRequest(UserRequestToPass);

        return new User(name, student_number);
    }

    private static User retrieveprofile() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        int student_number= Integer.valueOf(UIController.askTheUser("What's your student number"));
        RetrieveProfileRequest retrieveProfileRequest = new RetrieveProfileRequest(student_number);

        return UIController.processRequest(retrieveProfileRequest); // return[student_number, name]
    }

    private static schoolMap retrieveMap(){
        schoolMap campusMap = DataManager.loadMapFromFile();
        ArrayList<Building> buildingslist = new ArrayList<Building>();
        return campusMap;
    }

    private static ArrayList<Building> initiate_search(User userprofile, schoolMap campusMap) throws IOException, InterruptedException {
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
        Scanner sc = new Scanner(System.in);
        String activity = UIController.askTheUser("What's your next main activity. study chill or eat");


        int search_radius = Integer.valueOf(UIController.askTheUser("What search radius would you want"));
        SearchRequest searchRequest = new SearchRequest(userprofile,
                search_radius, campusMap);
        ArrayList<Building> preference_building_list = SearchUseCase.search(searchRequest);
        if(preference_building_list.toArray().length == 0){
            return getListContainingEmptyBuilding();
        }
        return preference_building_list;

// initiate search, get filters
    }

    public static ArrayList<Building> getListContainingEmptyBuilding() {
        /**
         * return a list containing just a building object that explains that no buildings were found with the right
         * criteria for the search
         */
        Building emptyBuilding = new Building("no building found", "none match specifications");
        ArrayList<Building> listContainingEmptyBuilding = new ArrayList<Building>();
        listContainingEmptyBuilding.add(emptyBuilding);
        return listContainingEmptyBuilding;
    }

    public static Building get_preferred_building(ArrayList<Building> buildingList){
        Building preferred_building = buildingList.get(0);
        buildingList.remove(0);
        return preferred_building;
    }

    private static void initiate_review(User userProfile, schoolMap campusMap) throws IOException, InterruptedException {
        Building buildingToReview = UIController.getBuildingToReview(campusMap);
        Review review = UIController.getThemToReview(buildingToReview);
        NewReviewRequest newReviewRequest = new NewReviewRequest(user_Profile.getStudentNumber(), review,
                buildingToReview);
        //todo whatever we do when a request is made to then implement said request idk exactly what.
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        CLI cli = new CLI();
        UIController.welcomeTheUser();
        schoolMap campusMap = retrieveMap();
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        String ans1 = UIController.askTheUser("Do you have an account? Y/N");
        //reads string
        if (ans1.equals("N")) {
            user_Profile = newprofile();

        } else if (ans1.equals("Y")) {
            User userinfo = retrieveprofile();
            user_Profile = userinfo;
        } else {
            UIController.askTheUser("Please type Y or N");
            if (ans1.equals("N")) {
                user_Profile = newprofile();

            } else {
                User userinfo = retrieveprofile();
                user_Profile = userinfo;
            }}


            int user_choice = Integer.valueOf(UIController.askTheUser("What would you like to do next? 1: search, 2: review"));
            if (user_choice == 1) {
                ArrayList<Building> building_selections = (ArrayList<Building>) initiate_search(user_Profile, campusMap);
                UIController.displaySearchResultFrame(building_selections);
                //Fully implement according to the above this is skeleton
            } else if (user_choice == 2) {
                initiate_review(user_Profile, campusMap);

            } else {
                System.out.println("didn't work bra");// TODO: UIController.displayClosingScreen();
            }
        }


}

