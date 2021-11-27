package UIDataManaging;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;
import Interfaces.*;
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
        return(CLI.getListContainingEmptyBuilding().get(0));
    }
    public static User processRequest(RetrieveProfileRequest req) {
        return DataManager.profileReturn(req.student_id);
    }
}
