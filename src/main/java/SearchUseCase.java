public class SearchUseCase{
    String building;
    String user;
    String map;

    public SearchUseCase(String building, String user, String map) {
        this.building = building;
        this.user = user;
        this.map = map;
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