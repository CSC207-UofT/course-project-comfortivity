package UseCases;

import Gateways.schoolMap;

/**
 * Interface for schoolMap as part of the dependency injection design pattern to invert the dependency
 * between MapUseCase and schoolMap
 */
public interface SchoolMapDataInterface {

    schoolMap retrieveMapInfo();
}
