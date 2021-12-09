package UseCases;

/**
 * Interface for UserGateway as part of the dependency injection design pattern to invert the dependency
 * between UserUseCase and UserGateway
 */
public interface UserDataInterface {

    void updateNewUserInfo(String name, int id);

    String retrieveUserName(int id);

}