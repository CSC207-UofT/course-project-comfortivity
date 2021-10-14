public class Building {
    private String name;
    private String address;
    private int starRating;
    private boolean bathrooms;



    public Building(){
        this.name = "";
        this.address = "";
        this.starRating = 0;
        this.bathrooms = false;

    }

    public Building(String name, String address){
        this.name = name;
        this.address = address;
        this.starRating = 0;
        this.bathrooms = false;

    }
    public Building(String name){
        this.name = name;
        this.address = "";
        this.starRating = 0;
        this.bathrooms = false;

    }
    public Building(String name, String address, boolean bathrooms, int starRating){
        this.name = name;
        this.address = address;
        this.bathrooms = bathrooms;
        this.starRating = starRating;

    }

    public int getStarRating() {
        return this.starRating
    }

    public String getAddress() {
        return this.address
    }

    public HashMap<String, Object> getAttributes() {
        HashMap<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("address", this.address);
        attributes.put("starRating", this.starRating);
        attributes.put("bathrooms", this.bathrooms);
        return attributes


    }

}