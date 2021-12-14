package UI;

import Controllers.LoginOrSignup;

import java.util.Scanner;

public class MenuForSignup {
    Scanner input = new Scanner(System.in);
    private String name;
    private String password;
    LoginOrSignup loginOrSignup = new LoginOrSignup();

    public MenuForSignup(){
    }

    public void signupUser(){
        System.out.println("Input name (Input String)");
        String name = input.nextLine();
        System.out.println("Input student number as password (Use String)");
        String student_number = input.nextLine();
        loginOrSignup.signUp(name, student_number);
        System.out.println("User successfully created");
    }


}


