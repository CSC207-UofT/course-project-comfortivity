package UseCases;

import Entities.Building;
import Gateways.schoolMap;
import UIDataManaging.GUI;

import java.io.IOException;
import java.util.ArrayList;

public class BuildingUseCase {

    BuildingDataInterface buildingDataInterface;

    public static Building loadBuilding(String code, BuildingDataInterface bdi) {

        return bdi.retrieveBuildingInfo(code);
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
        if (buildings.size() == 0){
            return new Building();
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
