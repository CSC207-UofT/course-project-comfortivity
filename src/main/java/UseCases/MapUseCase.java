package UseCases;

import Gateways.schoolMap;
import UIDataManaging.DataManager;

public class MapUseCase {

    SchoolMapDataInterface schoolMapDataInterface;

    public static schoolMap loadMap(SchoolMapDataInterface smdi) {
        return smdi.retrieveMapInfo();
    }
}
