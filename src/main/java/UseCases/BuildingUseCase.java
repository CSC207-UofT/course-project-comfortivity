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

    public static void loadAllBuildings() {

    }
}
