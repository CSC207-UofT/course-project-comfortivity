package Requests;
import java.util.List;
import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;
import Interfaces.*;
import Mapping.*;
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
