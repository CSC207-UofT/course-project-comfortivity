package Requests;
import Entities.Users.UserData;
import Interfaces.*;
import Mapping.*;
public class SearchRequest implements RequestInterface{
    public UserData userProfile;
    public int filterDistance;
    public schoolMap campusMap;

    public SearchRequest(UserData userProfile, int filterDistance, schoolMap campusMap) {
        this.userProfile = userProfile;
        this.filterDistance = filterDistance;
        this.campusMap = campusMap;
    }


}
