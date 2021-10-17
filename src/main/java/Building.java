import java.util.*;

public class Building {
    private String building_name;
    private String address;
    private int star_rating;
    private boolean bathrooms;



    public static Collection<Object> load_buildings() {
        DataManager dm = new DataManager();
        Collection<Object> bldgs_to_return = Collections.singleton(dm.buildingReturn());
        return bldgs_to_return;
        // Eventually it'll involve something like this, for now I'll just be like


    }
    public Building(){
        this.building_name = "";
        this.address = "";
        this.star_rating = 0;
        this.bathrooms = false;

    }

    public Building(String name, String address){
        this.building_name = name;
        this.address = address;
        this.star_rating = 0;
        this.bathrooms = false;

    }
    public Building(String name){
        this.building_name = name;
        this.address = "";
        this.star_rating = 0;
        this.bathrooms = false;

    }
    public Building(String name, String address, boolean bathrooms, int starRating){
        this.building_name = name;
        this.address = address;
        this.bathrooms = bathrooms;
        this.star_rating = starRating;

    }

    public int getStarRating() {
        return this.star_rating;
    }

    public String getAddress() {
        return this.address;
    }

    public HashMap<String, Object> getAttributes() {
        HashMap<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("address", this.address);
        attributes.put("starRating", this.star_rating);
        attributes.put("bathrooms", this.bathrooms);
        return attributes;


    }

}