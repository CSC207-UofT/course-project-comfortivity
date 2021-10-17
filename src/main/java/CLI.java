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

    private static ArrayList<Building> retrievebuildings(){
        BuildingInfoRequest buildingInfoRequest = new BuildingInfoRequest();
        //Building[] buildingslist = (Building[]) processRequest(buildingInfoRequest);
        ArrayList<Building> buildingslist = new ArrayList<Building>();
        // buildingslist.set(0, new Building("Whitney Hall"));
        return buildingslist;
    }

    private static ArrayList<Building> initiate_search(User userprofile, ArrayList<Building> buildings_list){
        Scanner sc = new Scanner(System.in);
        System.out.print("What's your next main activity.\n" +
                "Enter 'study' for Study\n" +
                "Enter 'chill' for Relaxation\n" +
                "Enter 'eat' for Eating\n");
        String activity = sc.nextLine();
        System.out.print("What search radius would you want?");
        int search_radius = sc.nextInt();
        //TODO: This should probably pass the userprofile itself rather than the student number, for search's sake
        SearchRequest searchRequest = new SearchRequest(userprofile.getStudentNumber(),
                search_radius, buildings_list);
        //ArrayList<Building> preference_building_list = SearchUseCase.search(searchRequest);
        ArrayList<Building> preference_building_list = new ArrayList<Building>();
        return preference_building_list;

// initiate search, get filters
    }

    public static Building get_preferred_building(ArrayList<Building> buildingList){
        Building preferred_building = buildingList.get(0);
        buildingList.remove(0);
        return preferred_building;
    }

    private static void initiate_review(User userProfile, ArrayList<Building> buildings_list){
        Scanner sc = new Scanner(System.in);
        System.out.print("Press '1' to review Building 1");
        String building = sc.nextLine();
        System.out.print("Rate it from 1 - 5");
        int starrating = sc.nextInt();
        NewReviewRequest newReviewRequest = new NewReviewRequest(user_Profile.getStudentNumber(), starrating,
                buildings_list.get(0));
    }

    public static void main(String[] args)
    {
//        CLI cli = new CLI();
        //TODO make this next line work again
        ArrayList<Building> BuildingList = retrievebuildings();
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
            ArrayList<Building> building_selections = (ArrayList<Building>) initiate_search(user_Profile, BuildingList);
            //TODO i commented this System.out.println("Your building is: " + building_selections.get(0).getAddress());
            System.out.println("Your building is " + "Whitney Hall at " + "85 St George St");
        } else if (user_choice == 2) {
            initiate_review(user_Profile, BuildingList);
            System.out.println("Thank you");
        } else{
            System.out.println("Pick either '1' or '2'");
        }

    }
}

