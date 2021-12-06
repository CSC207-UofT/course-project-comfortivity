package Entities;
import Interfaces.Buildable;
import UIDataManaging.DataManager;

import java.util.*;


public class Building implements Buildable {
    private String name;
    private String address;
    private int star_rating;
    private boolean bathrooms;
    private ArrayList<Review> reviews;



    public static Collection<Building> load_buildings() {

        Collection<Building> bldgs_to_return = DataManager.buildingReturn();
        return bldgs_to_return;
        // Eventually it'll involve something like this, for now I'll just be like


    }


    public Building(){
        this.name = "";
        this.address = "";
        this.star_rating = 0;
        this.bathrooms = false;
        this.reviews = new ArrayList<Review>();

    }

    public Building(String name, String address){
        this.name = name;
        this.address = address;
        this.star_rating = 0;
        this.bathrooms = false;

    }
    public Building(String name){
        this.name = name;
        this.address = "";
        this.star_rating = 0;
        this.bathrooms = false;

    }
    public Building(String name, String address, boolean bathrooms, int starRating){
        this.name = name;
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

    public String getName() {return this.name;}
    public HashMap<String, Object> getAttributes() {
        HashMap<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("address", this.address);
        attributes.put("starRating", this.star_rating);
        attributes.put("bathrooms", this.bathrooms);
        return attributes;


    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public Review getTopReview(){
        if(this.reviews.size() > 0){
            return this.reviews.get(0);
        }
        else {
            return new Review(0, "No reviews yet");
        }
    }

}
