import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class UIController {

    public void processRequest(NewReviewRequest req) {
        return DataManager.updateNewReview(req.student_id, req.review, req.building);
    }

    public void processRequest(NewUserRequest req) {
        return DataManager.updateNewUser(req.student_id, req.name);
    }

    public Collection<Object> processRequest(RetrieveProfileRequest req) {
        return DataManager.profileReturn(req.student_number);
    }
}
