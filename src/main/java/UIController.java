import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;


public class UIController {

    public void processRequest(NewReviewRequest req) {
        DataManager.updateNewReview(req.student_id, req.review, req.revbuilding);
    }

    public void processRequest(NewUserRequest req) {
        DataManager.updateNewUser(req.student_id, req.name);
    }

    public Collection<Object> processRequest(RetrieveProfileRequest req) {
        return DataManager.profileReturn(req.student_id);
    }
}
