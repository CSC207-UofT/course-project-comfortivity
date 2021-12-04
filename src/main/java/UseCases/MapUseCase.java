package UseCases;

import Entities.schoolMap;

public class MapUseCase {

    public static schoolMap loadMap() {
        return new schoolMap();
    }
}
