package UseCases;

import Entities.Building;
import Entities.User;
import Entities.UserBuilder;
import Entities.UserBuilderDirector;

public class UserUseCase {

    UserDataInterface userDataInterface;

    /**
     * Updates user info in the database with new info
     * @param name new name to update user info with
     * @param id unique id to identify user
     * @param udi UserDataInterface
     */
    public static void updateUser(String name, int id, UserDataInterface udi) {
        udi.updateNewUserInfo(name, id);
    }

    /**
     * Instantiates User found in database
     * @param id unique id to identify user
     * @param udi UserDataInterface
     * @return returns an instance of User identified by id
     */
    public static User loadUser(int id, UserDataInterface udi) {
        UserBuilder userBuilder = new UserBuilder();
        UserBuilderDirector userBuilderDirector = new UserBuilderDirector(userBuilder);
        return userBuilderDirector.startUserBuild(id, udi.retrieveUserName(id));
    }

    /**
     * Returns the distance between two locations start and finish (distance is represented by horizontal and
     * vertical gridspaces)
     * @param start location of user
     * @param finish location of building
     * @return returns distnace between user and building
     */
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