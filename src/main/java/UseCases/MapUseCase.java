package UseCases;

import Entities.Building;
import Entities.schoolMap;
import UIDataManaging.UIController;

import java.util.ArrayList;

public class MapUseCase {

    public static schoolMap loadMap() {
        return schoolMap.retrieveMapInfo();
    }

    public static schoolMap retrieveMap(){
        //move to MapUseCase
        schoolMap campusMap = UIController.loadMap();
        return campusMap;
    }
}
