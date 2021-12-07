package UseCases;

import Gateways.schoolMap;
import UIDataManaging.DataManager;

public class MapUseCase {

    public static schoolMap loadMap() {
        return schoolMap.retrieveMapInfo();
    }

    public static schoolMap retrieveMap(){
        //move to MapUseCase
        schoolMap campusMap = DataManager.loadMapFromFile();
        return campusMap;
    }
}
