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
    public static Building getBuildingToReview(schoolMap campusMap) throws IOException, InterruptedException {
        String answer = askTheUser("Which building do you want to review?");
        ArrayList<Building> buildings = campusMap.getAllBuildings();
        for(Building building : buildings){
            if(building.getName() == answer){
                return building;
            }
        }
        answer = askTheUser("Not found. Try again. Some available buildings are " + buildings.get(0).getName());
        for(Building building : buildings){
            if(building.getName() == answer){
                return building;
            }
        }
        return getBuildingToReview(campusMap);

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
