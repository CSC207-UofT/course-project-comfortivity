package UseCases;


public interface UserDataInterface {

    void updateNewUserInfo(String name, int id);

    String retrieveUserName(int id);

}