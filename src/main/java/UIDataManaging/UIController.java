package UIDataManaging;

import Entities.Building;
import Entities.Review;
import Entities.User;
import Entities.schoolMap;
import Requests.NewReviewRequest;
import Requests.NewUserRequest;
import Requests.RetrieveProfileRequest;

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


    public static void processRequest(NewReviewRequest req)
    /**
     * processes a newuser request in the datamanager (makes a user, i mean)
     */
    {
        DataManager.updateNewReview(req.student_id, req.review, req.revbuilding);
    }

    public static void processRequest(NewUserRequest req)
    /**
     * processes an updatenewuser request (updates a user)
     */
    {
        DataManager.updateNewUser(req.student_id, req.name);
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
    asks the datamanager to return the profile for the given student id
     */
    {
        return DataManager.profileReturn(req.student_id);
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
