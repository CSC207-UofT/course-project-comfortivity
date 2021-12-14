package UseCases.User;

import Entities.Users.UserBuilder;
import Entities.Users.UserData;
import Entities.Users.Users;

public class UserManager implements UserManaging, java.io.Serializable{
    Users users = new Users();

    public void addUser(String name, String studentNumber) {
        UserBuilder um = new UserBuilder();
        um.setName(name);
        um.setStudentNumber(studentNumber);
        UserData u = um.getUser();
        users.addUser(u);
        saveData();
    }

    public UserData getUser(String name) {
        return null;
    }

    private void saveData(){users.saveData();};

    public boolean checkIfUserExist(String name) {
        return (users.searchName(name) != null);
    }

    /**
     * @param name name of user
     * @param studentNumber studentnumber of user
     * @return if the login info exists
     */
    public boolean checkLogInInfo(String name, String studentNumber) {
        if (users.searchName(name) != null) {
            return users.searchName(name).check_password(studentNumber);
        }
        return false;
    }
}
