package UseCases;

import Entities.User;

public interface UserDataInterface {

    void addNewUserInfo(String name, int id);

    void updateUserName(String name, int id);


}