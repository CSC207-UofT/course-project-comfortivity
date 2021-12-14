package Controllers;

import UseCases.User.UserManager;

public class LoginOrSignup {
    /**
     * Controller for login/sign up
     */
    UserManager um;
    public LoginOrSignup() {
        this.um = new UserManager();
    }

    public Boolean checkIfUserExist(String name){
        return um.checkIfUserExist(name);
    }

    public boolean loggedin(String name, String student_number) {
        return um.checkLogInInfo(name, student_number);
    }

    public void signUp(String name, String student_number){
        um.addUser(name, student_number);
    }
}
