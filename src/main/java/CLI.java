import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.List;

public class CLI {
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
        Scanner sc = new Scanner(System.in);
        //Todo fix this
        UIController.askTheUser("Press '1' to review " + buildingToReview.getName());
        String building = sc.nextLine();

        // todo i should probably make it so it doesn't crash if it's not an int
        int starrating = Integer.valueOf(UIController.askTheUser("Rate it from 1-5"));
        NewReviewRequest newReviewRequest = new NewReviewRequest(user_Profile.getStudentNumber(), starrating,
                buildingToReview);
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

