package UseCases;
import java.util.Collection;
import java.util.ArrayList;
import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;
import Interfaces.*;
import Mapping.*;
public class SearchUseCase{
    String building;
    String user;
    String map;
    
    public SearchUseCase(String building, String user, String map) {
        this.building = building;
        this.user = user;
        this.map = map;
    }
    
    public static ArrayList<Building> search(SearchRequest req) {
        // Take the searchRequest and filter the given list of buildings based on how far they are from the User specified in the request. If they
        // are further than the filter distance provided, they are removed from the list. Return the new list.
        // Note that this implementation is static and does not use the actual instance variables of SearchUseCase. In a later implementation, we may change this
        // to specify the user location or for other reasons that makes the code more consistent.
        // THIS IS TEMPORARY.
        ArrayList<Building> filteredBuildings = new ArrayList<Building>();
        return filteredBuildings;
    }

    public String getBuilding() {
        return this.building;
    }

    public String getUser() {
        return user;
    }

    public String getMap() {
        return map;
    }
}
