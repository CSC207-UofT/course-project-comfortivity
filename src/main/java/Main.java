import java.awt.*;
import java.io.IOException;
import java.util.*;
import Exceptions.InvalidInputException;
import UI.MenuLoginOrSignup;

public class Main {
    public static void main(String[] args) throws InvalidInputException {
        MenuLoginOrSignup menuLoginOrSignup = new MenuLoginOrSignup();
        menuLoginOrSignup.loginOrSignup();
    }


}

