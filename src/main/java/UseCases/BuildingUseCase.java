package UseCases;

import Entities.Building;
import Entities.schoolMap;
import UIDataManaging.GUI;

import java.io.IOException;
import java.util.ArrayList;

public class BuildingUseCase {

    public static Building loadBuilding() {
        return new Building();
    }

    public static int findDistance(Building startBuilding, Building endBuilding) {
        // query collection buildings for alphanumeric locations of startBuilding and endBuilding
        // convert alphanumeric locations to two digits by assigning numeric value to letter
        // for example "D5" becomes 4 and 5
        // subtract sum of endBuilding from sum of startBuilding
        // return the absolute value as distance
        return 5;
    }

    public static void loadAllBuildings() {

    }

    public static Building getBuildingToReview(schoolMap campusMap) throws IOException, InterruptedException
    /**
     asks the user which building they want to review, checks if it exists, asks again/recurses if it doesn't
     */
    {
        String answer = GUI.genericPromptUserResponse("Which building do you want to review?");
        ArrayList<Building> buildings = campusMap.getAllBuildings();
        for(Building building : buildings){
            if(building.getName() == answer){
                return building;
            }
        }
        answer = GUI.genericPromptUserResponse("Not found. Try again. Some available buildings are " + buildings.get(0).getName());
        for(Building building : buildings){
            if(building.getName() == answer){
                return building;
            }
        }
        return getBuildingToReview(campusMap);

    }
}
