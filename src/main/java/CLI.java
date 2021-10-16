package src.main.java;

import java.util.*;


public class CLI {
    private static User UserProfile;
    private static Collection<Building> BuildingList;

//    public CLI(){
//        UserProfile = null;
//        BuildingList = null;
//    }
//    public CLI(User userprofile, Collection<Building> buildinglist){
//        UserProfile = userprofile;
//        BuildingList = buildinglist;
//    }

    private static Object[] newprofile(){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("What's your student number");
        int student_number= sc.nextInt();              //reads input
        System.out.print("What's your Full Name");
        String name = sc.nextLine();
        NewProfileRequest newProfileRequest = new NewProfileRequest(student_number, name);
        Object[] newuserprofileinfo = process_request(newProfileRequest);
        return newuserprofileinfo; // return[student_number, name]
    }

    private static Object[] retrieveprofile(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What's your student number");
        int student_number= sc.nextInt();              //reads input
        RetrieveProfileRequest retrieveProfileRequest = new RetrieveProfileRequest(student_number);
        Object[] existinguserprofileinfo = process_request(retrieveProfileRequest);
        return existinguserprofileinfo; // return[student_number, name]
    }

    private static Building[] retrievebuildings(){
        BuildingInfoRequest buildingInfoRequest = new BuildingInfoRequest();
        Building[] buildingslist = (Building[]) process_request(buildingInfoRequest);
        return buildingslist;
    }

    private static ArrayList<Building> initiate_search(User userprofile, Building[] buildings_list){
        Scanner sc = new Scanner(System.in);
        System.out.print("What's your next main activity.\n" +
                "Enter 'study' for Study\n" +
                "Enter 'chill' for Relaxation\n" +
                "Enter 'eat' for Eating\n");
        String activity = sc.nextLine();
        System.out.print("What search radius would you want?");
        int search_radius = sc.nextInt();
        SearchRequest searchRequest = new SearchRequest(UserProfile, BuildingList, activity,
                search_radius);
        ArrayList<Building> preference_building_list = process_request(searchRequest);
        return preference_building_list;

// initiate search, get filters
    }

    public static Building get_preferred_building(ArrayList<Building> buildingList){
        Building preferred_building = buildingList.get(0);
        buildingList.remove(0);
        return preferred_building;
    }

    private static void initiate_review(User userProfile, Building[] buildings_list){
        Scanner sc = new Scanner(System.in);
        System.out.print("Press '1' to review Building 1");
        String building = sc.nextLine();
        System.out.print("Rate it from 1 - 5");
        int starrating = sc.nextInt();
        NewReviewRequest newReviewRequest = new NewReviewRequest(UserProfile, building, starrating);
    }

    public static void main(String[] args)
    {
//        CLI cli = new CLI();
        Building[] BuildingList = retrievebuildings();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Hello, Do you have an account? Y/N");
        String ans1= sc.nextLine();              //reads string
        if (ans1.equals("N")) {
            Object[] userinfo = newprofile();
            UserProfile = (User)userinfo[0];
        } else if (ans1.equals("Y")) {
            Object[] userinfo = retrieveprofile();
            UserProfile = (User)userinfo[0];
        } else{
            System.out.println("Pick either 'Y' or 'N'");
        }


        System.out.print("What would you like to do next. \n Enter '1' to start a search. \n Enter '2' to start a review");
        int user_choice = sc.nextInt();
        if (user_choice == 1) {
            ArrayList<Building> building_selections = (ArrayList<Building>) initiate_search(UserProfile, BuildingList);
            System.out.println("Your building is: " + building_selections.get(0).getAddress());
        } else if (user_choice == 2) {
            initiate_review(UserProfile, BuildingList);
            System.out.println("Thank you");
        } else{
            System.out.println("Pick either '1' or '2'");
        }
    }
}

