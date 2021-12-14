package UseCases.User;

import Entities.Users.UserData;

public interface UserManaging {

    void addUser(String name, String studentNumber);

    UserData getUser(String name);

    boolean checkIfUserExist(String name);

    boolean checkLogInInfo(String name, String studentNumber);
}
