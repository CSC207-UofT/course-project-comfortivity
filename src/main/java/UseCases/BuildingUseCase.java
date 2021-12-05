package UseCases;

import Entities.Building;

public class BuildingUseCase {

    public static Building loadBuilding(Building building) {
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
}
