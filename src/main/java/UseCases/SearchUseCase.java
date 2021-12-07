package UseCases;

import Entities.Building;
import Entities.User;
import Entities.schoolMap;
import Interfaces.InterfaceRequest;
import UseCases.UserUseCase;

import java.util.ArrayList;

public class SearchUseCase {
    public InterfaceRequest SearchRequest;

    public static float building_points(Building building, User user, Float filterDistance) {
        int count = 0;
        if (user.getPreferences().get("Group")) {
            if (building.isGroup()) {
                count += 1;
            }
        }
        if (user.getPreferences().get("Food")){
            if (building.isFood()){
                count += 1;
            }
        }
        if (user.getPreferences().get("Privacy")){
            if(building.isIndividual()){
                count += 1;
            }
        }
        if (user.getPreferences().get("Bathroom")){
            if(building.isBathrooms()){
                count += 1;
            }
        }
        if (user.getPreferences().get("Water")){
            if(building.isWater()){
                count +=1;
            }
        }
        if (user.getPreferences().get("Accessibility")){
            if(building.isAccessibility()){
                count += 1;
            }
        }
        if (UserUseCase.findDistance(user.getlocation(), building) <= 25/100 * filterDistance) {
            count += 1;
        }
        if (UserUseCase.findDistance(user.getlocation(), building) <= 50/100 * filterDistance) {
            count += 1;
        }
        if (UserUseCase.findDistance(user.getlocation(), building) <= 75/100 * filterDistance) {
            count += 1;
        }
        if (UserUseCase.findDistance(user.getlocation(), building) <= filterDistance) {
            count += 1;
        }
        return count / 10 * 100;

    }

    public static void arrangeArrays(ArrayList<Building> ordered_buildings, ArrayList<Float> ordered_points, Building building,
                                     Float point){
        int index = 0;
        if (ordered_buildings.size() == 0){
            ordered_buildings.add(building);
            ordered_points.add(point);
        }else {
            for (Float sel_point:ordered_points){
                if (point <= sel_point){
                    ordered_buildings.add(index, building);
                    ordered_points.add(index, point);
                }
            }
        }
    }

    public static ArrayList<Building> search(User user, float filterDistance){
        ArrayList<Building> ordered_buildings = new ArrayList<>();
        ArrayList<Float> ordered_points = new ArrayList<>();
        schoolMap schoolmap = new schoolMap();
        ArrayList<Building> buildings = schoolmap.getAllBuildings();
        for (Building building: buildings){
            float point = building_points(building, user, filterDistance);
            arrangeArrays(ordered_buildings, ordered_points, building, point);
        }
        return ordered_buildings;
    }
}

