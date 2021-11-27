package UIDataManaging;

import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

import Entities.*;
import Requests.*;
import Mapping.*;


public class UIController {

    public static void welcomeTheUser() throws IOException, InterruptedException {
        GUI.displayWelcomeScreen();
    }

    public static String askTheUser(String prompt) throws IOException, InterruptedException {
        return GUI.genericPromptUserResponse(prompt);
    }

    public static void welcomingFinished() {

    }
    public static void processRequest(NewReviewRequest req) {
        DataManager.updateNewReview(req.student_id, req.review, req.revbuilding);
    }

    public static void processRequest(NewUserRequest req) {
        DataManager.updateNewUser(req.student_id, req.name);
    }

    public static void displaySearchResultFrame(ArrayList<Building> buildings){
        GUI.displaySearchResultFrame(buildings);
    }
    public static Building getBuildingToReview(schoolMap campusMap) {
        return(Main.getListContainingEmptyBuilding().get(0));
        //todo make this actually go the right way actually
    }
    public static User processRequest(RetrieveProfileRequest req) {
        return DataManager.profileReturn(req.student_id);
    }

    public static String askForLocation() throws InterruptedException, IOException {
        return GUI.promptTheirLocation();
    }

    public static HashMap askForPreferences() throws InterruptedException, IOException {
        return GUI.promptTheirPreferences();
    }

    public static Review getThemToReview(Building building) throws InterruptedException, IOException {
        return GUI.getThemToReview(building);
    }
}
