package Requests;


import Entities.User;
import Gateways.schoolMap;
import Interfaces.InterfaceRequest;


public class SearchRequest implements InterfaceRequest {
    public User userProfile;
    public int filterDistance;
    public schoolMap campusMap;

    public SearchRequest(User userProfile, int filterDistance, schoolMap campusMap) {
        this.userProfile = userProfile;
        this.filterDistance = filterDistance;
        this.campusMap = campusMap;
    }


}
