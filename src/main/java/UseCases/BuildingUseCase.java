package UseCases;

import Entities.Building;

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

    public static int findDistance(Building startBuilding, Building endBuilding) {
        // convert alphanumeric locations to two digits by assigning numeric value to letter
        // for example "D5" becomes 4 and 5
        // subtract sum of endBuilding from sum of startBuilding
        // return the absolute value as distance
        int a = startBuilding.getCode().charAt(0) - 64;
        int b = startBuilding.getCode().charAt(1);
        int c = endBuilding.getCode().charAt(0) - 64;
        int d = endBuilding.getCode().charAt(1);
        return Math.abs((a + b) - (c + d));
    }

    public static void loadAllBuildings() {

    }
}
