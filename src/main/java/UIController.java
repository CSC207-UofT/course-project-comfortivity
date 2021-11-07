import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;


public class UIController {

    public static void welcomeTheUser() throws IOException {
        GUI.displayWelcomeScreen();
    }
    public static void welcomingFinished() {

    }
    public static void processRequest(NewReviewRequest req) {
        DataManager.updateNewReview(req.student_id, req.review, req.revbuilding);
    }

    public static void processRequest(NewUserRequest req) {
        DataManager.updateNewUser(req.student_id, req.name);
    }

    public static Building getBuildingToReview(schoolMap campusMap) {
        return(CLI.getListContainingEmptyBuilding().get(0));
    }
    public static User processRequest(RetrieveProfileRequest req) {
        return DataManager.profileReturn(req.student_id);
    }
}
