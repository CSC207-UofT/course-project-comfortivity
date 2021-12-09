package UseCases;

import Entities.Building;
import Entities.User;
import Gateways.schoolMap;
import Interfaces.InterfaceRequest;
import UseCases.UserUseCase;

import java.util.ArrayList;
import java.util.Collection;

public class SearchUseCase {
    public InterfaceRequest SearchRequest;

    public static float building_points(Building building, User user, Float filterDistance) {
        // helper function for search function. Takes a building and a user instance, and gives it a score based on how
        // much of a good match the building was for the user's search request.
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
        // point corresponds to building's point gotten from building_points. Point is then placed in a sorted manner in
        // ordered_points and then building is placed at the same index in ordered_buildings as points was in ordered_points.
        int index = 0;
        if (ordered_buildings.size() == 0){
            ordered_buildings.add(building);
            ordered_points.add(point);
        }else {
            for (Float sel_point:ordered_points){
                if (point <= sel_point){
                    ordered_buildings.add(index, building);
                    ordered_points.add(index, point);
                    return;
                }
            }
        }
    }

    public static ArrayList<Building> search(User user, float filterDistance){
        // returns a list of buildings sorted in order of preference based on the users search filters and requests.
        ArrayList<Building> ordered_buildings = new ArrayList<>();
        ArrayList<Float> ordered_points = new ArrayList<>();
        //todo make this os it uses an actual thing or will it do it automatically idrk
        schoolMap schoolmap = new schoolMap();
        ArrayList<Building> buildings = schoolmap.getAllBuildings();
        for (Building building: buildings){
            float point = building_points(building, user, filterDistance);
            arrangeArrays(ordered_buildings, ordered_points, building, point);
        }
        return ordered_buildings;
    }
}

