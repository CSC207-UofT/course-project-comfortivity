public class SearchUseCase{
    String building;
    String user;
    String map;
    
    public SearchUseCase(String building, String user, String map) {
        this.building = building;
        this.user = user;
        this.map = map;
    }
    
    public Collection<Building> search(int id, double dist, ArrayList<Building> buildings) {
        // Take the 
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
