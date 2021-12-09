package UseCases;

import Entities.Building;
import Entities.User;

public class UserUseCase {

    UserDataInterface userDataInterface;

    public static void updateUser(String name, int id, UserDataInterface udi) {
        udi.updateNewUserInfo(name, id);
    }

    public static int findDistance(String start, Building finish) {
        // convert alphanumeric locations to two digits by assigning numeric value to letter
        // for example "D5" becomes 4 and 5
        // subtract sum of endBuilding from sum of startBuilding
        // return the absolute value as distance
        int a = start.charAt(0) - 64;
        int b = start.charAt(1);
        int c = finish.getCode().charAt(0) - 64;
        int d = finish.getCode().charAt(1);
        return Math.abs((a + b) - (c + d));
    }
}