package UseCases;

import Gateways.schoolMap;

public class MapUseCase {

    SchoolMapDataInterface schoolMapDataInterface;

    /**
     * Instantiates schoolMap of buildings in database
     * @param smdi SchoolMapDataInterface
     * @return returns an instance of schoolMap from database
     */
    public static schoolMap loadMap(SchoolMapDataInterface smdi) {
        return smdi.retrieveMapInfo();
    }
}
