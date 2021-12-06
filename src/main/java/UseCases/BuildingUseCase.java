package UseCases;

import Entities.Building;
import Entities.schoolMap;
import UIDataManaging.GUI;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

public class BuildingUseCase {

    BuildingDataInterface buildingDataInterface;

    public static Building loadBuilding(String code, BuildingDataInterface bdi) {
//        building.setCode((String) info.get(0));
//        building.setName((String) info.get(1));
//        building.setAddress((String) info.get(2));
//        building.setStar_rating((Integer) info.get(3));
//        building.setGroup((Boolean) info.get(4));
//        building.setIndividual((Boolean) info.get(5));
//        building.setBathrooms((Boolean) info.get(6));
//        building.setWater((Boolean) info.get(7));
//        building.setFood((Boolean) info.get(8));
//        building.setAccessibility((Boolean) info.get(9));
//        bdi.retrieveBuildingInfo(code);
        return bdi.retrieveBuildingInfo(code);
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
