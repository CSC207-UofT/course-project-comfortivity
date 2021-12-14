package UI;
import Exceptions.InvalidInputException;
import java.util.Scanner;

public class MenuLoginOrSignup {
    Scanner scanner = new Scanner(System.in);

    public MenuLoginOrSignup(){
    }

    public void loginOrSignup() throws InvalidInputException{
        System.out.println("Welcome to the UofT Building Review System");
        System.out.println("Choose 1 to Login" + "\n" + "Choose 2 to Signup" + "\n" + "Choose 3 to Exit");
        String input = scanner.nextLine();
        if (input.equals("1")){
            MenuForLogin menuForLogin = new MenuForLogin();
            menuForLogin.loginUser();
        } else if (input.equals("2")){
            MenuForSignup menuForSignup = new MenuForSignup();
            menuForSignup.signupUser();
        } else if (input.equals("3")){
            System.exit(0);
        } else {
            loginOrSignup();
        }
    }

}
