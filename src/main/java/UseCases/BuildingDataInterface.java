package UseCases;

import Entities.Building;

/**
 * Interface for BuildingGateway as part of the dependency injection design pattern to invert the dependency
 * between BuildingUseCase and BuildingGateway
 */
public interface BuildingDataInterface {

    Building retrieveBuildingInfo(String code);
}