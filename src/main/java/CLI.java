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

    private static User newprofile(){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("What's your student number");
        int student_number= sc.nextInt();              //reads input
        System.out.print("What's your Full Name");
        String name = sc.nextLine();
        NewUserRequest UserRequestToPass = new NewUserRequest(student_number, name);
        UIController.processRequest(UserRequestToPass);

        return new User(name, student_number);
    }

    private static User retrieveprofile(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What's your student number");
        int student_number= sc.nextInt();              //reads input
        RetrieveProfileRequest retrieveProfileRequest = new RetrieveProfileRequest(student_number);

        return UIController.processRequest(retrieveProfileRequest); // return[student_number, name]
    }

    private static schoolMap retrieveMap(){
        schoolMap campusMap = DataManager.loadMapFromFile();
        ArrayList<Building> buildingslist = new ArrayList<Building>();
        return campusMap;
    }

    private static ArrayList<Building> initiate_search(User userprofile, schoolMap campusMap){
        Scanner sc = new Scanner(System.in);
        System.out.print("What's your next main activity.\n" +
                "Enter 'study' for Study\n" +
                "Enter 'chill' for Relaxation\n" +
                "Enter 'eat' for Eating\n");
        String activity = sc.nextLine();
        System.out.print("What search radius would you want?");
        int search_radius = sc.nextInt();
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

    private static void initiate_review(User userProfile, schoolMap campusMap){
        Building buildingToReview = UIController.getBuildingToReview(campusMap);
        Scanner sc = new Scanner(System.in);
        System.out.print("Press '1' to review " + buildingToReview.getName());
        String building = sc.nextLine();
        System.out.print("Rate it from 1 - 5");
        int starrating = sc.nextInt();
        NewReviewRequest newReviewRequest = new NewReviewRequest(user_Profile.getStudentNumber(), starrating,
                buildingToReview);
    }

    public static void main(String[] args)
    {
//        CLI cli = new CLI();
        schoolMap campusMap = retrieveMap();
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Hello, Do you have an account? Y/N");
        String ans1= sc.nextLine();              //reads string
        if (ans1.equals("N")) {
            user_Profile = newprofile();

        } else if (ans1.equals("Y")) {
            User userinfo = retrieveprofile();
            user_Profile = userinfo;
        } else{
            System.out.println("Pick either 'Y' or 'N'");
        }


        System.out.println("What would you like to do next. \n Enter '1' to start a search. \n Enter '2' to start a " +
                "review");
        int user_choice = sc.nextInt();
        if (user_choice == 1) {
            ArrayList<Building> building_selections = (ArrayList<Building>) initiate_search(user_Profile, campusMap);
            System.out.println("Your building is: " + building_selections.get(0).getAddress());
            //Fully implement according to the above this is skeleton
        } else if (user_choice == 2) {
            initiate_review(user_Profile, campusMap);
            System.out.println("Thank you");
        } else{
            System.out.println("Pick either '1' or '2'");
        }

    }
}

