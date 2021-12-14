package UI;

import Controllers.LoginOrSignup;
import UseCases.User.UserManager;

import java.util.Scanner;

public class MenuForLogin {
    Scanner input = new Scanner(System.in);
    private String name;
    private String password;
    LoginOrSignup loginOrSignup = new LoginOrSignup();

    public MenuForLogin(){
    }

    public void loginUser(){
        boolean success = false;
        while (!success){
            System.out.println("Input name that you signed up with");
            name = input.next();

            // Check if name exists
            if (loginOrSignup.checkIfUserExist(name)) {
                input.nextLine();
            } else {
                System.out.println("Incorrect login. Try again.");
                loginUser();
            }

            // Name exists, now check for correct password
            System.out.println("Input student number as password");
            password = input.next();

            // Check if password is correct
            success = loginOrSignup.loggedin(name, password);
        }
    }

}
