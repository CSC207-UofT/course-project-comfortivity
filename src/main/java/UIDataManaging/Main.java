package UIDataManaging;

import java.io.IOException;
import java.util.*;

import Entities.User;
import Entities.Building;
import Gateways.schoolMap;
import UseCases.MapUseCase;

public class Main {
    private static User userProfile;
    private static Collection<Building> BuildingList;

//    public CLI(){
//        UserProfile = null;
//        BuildingList = null;
//    }
//    public CLI(User userprofile, Collection<Building> buildinglist){
//        UserProfile = userprofile;
//        BuildingList = buildinglist;
//    }






    //public static ArrayList<Building> getListContainingEmptyBuilding() {
       // /**
       //  * return a list containing just a building object that explains that no buildings were found with the right
       //  * criteria for the search
       //  */
        //Building emptyBuilding = new Building("no building found", "none match specifications");
        //ArrayList<Building> listContainingEmptyBuilding = new ArrayList<Building>();
        //listContainingEmptyBuilding.add(emptyBuilding);
        //return listContainingEmptyBuilding;
    //}





    public static void main(String[] args) throws IOException, InterruptedException {
//        CLI cli = new CLI();
        UIController.welcomeTheUser();
        schoolMap campusMap = MapUseCase.loadMap();
        userProfile = DialogueController.beginLoginSequence();
        DialogueController.takeUserOrders(userProfile, campusMap);


    }

}

