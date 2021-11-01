import java.util.List;
public class SearchRequest implements RequestInterface{
    public User userProfile;
    public int filterDistance;
    public schoolMap campusMap;

    public SearchRequest(User userProfile, int filterDistance, schoolMap campusMap) {
        this.userProfile = userProfile;
        this.filterDistance = filterDistance;
        this.campusMap = campusMap;
    }


}
