public class Building {
    private String address;
    private int starRating;
    private boolean bathrooms;



    public Building(){
        this.address = "";
        this.starRating = 0;
        this.bathrooms = false;

    }

    public Building(String address){
        this.address = address;
        this.starRating = 0;
        this.bathrooms = false;

    }

    public Building(String address, boolean bathrooms, int starRating){
        this.address = address;
        this.bathrooms = bathrooms;
        this.starRating = starRating;

    }

    public int getStarRating() {
        return this.starRating
    }


}