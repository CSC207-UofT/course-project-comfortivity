package UIDataManaging;

import Entities.Building;
import Entities.Review;
import Entities.User;
import Gateways.UserGateway;
import Requests.NewReviewRequests;
import Requests.NewUserRequest;
import Requests.RetrieveProfileRequest;
import UseCases.UserUseCase;

import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;




public class UIController {

    public static void welcomeTheUser() throws IOException, InterruptedException
    /**
     * produces the welcome screen and finishes running when they close it
     */
    {
        GUI.displayWelcomeScreen();
    }

    public static String askTheUser(String prompt) throws IOException, InterruptedException
    /**
     * displays a window that asks the user the given string and returns the answer
     */
    {
        return GUI.genericPromptUserResponse(prompt);
    }




    public static void processRequest(NewUserRequest req)
    /**
     * processes an updatenewuser request (updates a user)
     */
    {
        UserUseCase.updateUser(req.name, req.student_id, new UserGateway());
    }

    public static void displaySearchResultFrame(ArrayList<Building> buildings)
    /**
        Given a list of buildings, passes them into the GUI to display
     */
    {

        GUI.displaySearchResultFrame(buildings);
    }

    public static User processRequest(RetrieveProfileRequest req)
    /**
    asks the appropriate use case to return the profile for the given student id
     */
    {
        return UserUseCase.loadUser(req.student_id, new UserGateway());
    }

    public static String askForLocation() throws InterruptedException, IOException
    /**
    asks the user for their current location according to a map we have shown in the GUI
     */
    {
        return GUI.promptTheirLocation();
    }

    public static HashMap askForPreferences() throws InterruptedException, IOException
    /**
     * Gets, from GUI, the user's filters they want to apply to their search
     */
    {
        return GUI.promptTheirPreferences();
    }

    public static Review getThemToReview(Building building) throws InterruptedException, IOException
    /**
     * asks the user to review a given building using the GUI class
     */
    {
        return GUI.getThemToReview(building);
    }
}
