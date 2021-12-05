package Entities;
import java.util.*;
import Interfaces.*;
import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;

// public class Building implements Buildable {
public class Building {
    private String code;
    private String name;
    private String address;
    private int star_rating;
    private boolean group;
    private boolean individual;
    private boolean bathrooms;
    private boolean water;
    private boolean food;
    private boolean accessibility;

//TODO can we implement a getTopReview() method?

//    public static Collection<Building> load_buildings() {
//        DataManager dm = new DataManager();
//        Collection<Building> bldgs_to_return = dm.buildingReturn();
//        return bldgs_to_return;
//        // Eventually it'll involve something like this, for now I'll just be like
//
//
//    }
//    public Building(){
//        this.name = "";
//        this.address = "";
//        this.star_rating = 0;
//        this.bathrooms = false;
//
//    }
//
//    public Building(String name, String address){
//        this.name = name;
//        this.address = address;
//        this.star_rating = 0;
//        this.bathrooms = false;
//
//    }
    public Building() {
        this.code = "";
        this.name = "";
        this.address = "";
        this.star_rating = 0;
        this.group = false;
        this.individual = false;
        this.bathrooms = false;
        this.water = false;
        this.food = false;
        this.accessibility = false;
    }
//    public Building(String name, String address, boolean bathrooms, int starRating){
//        this.name = name;
//        this.address = address;
//        this.bathrooms = bathrooms;
//        this.star_rating = starRating;
//
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = star_rating;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    public boolean isIndividual() {
        return individual;
    }

    public void setIndividual(boolean individual) {
        this.individual = individual;
    }

    public boolean isBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(boolean bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isAccessibility() {
        return accessibility;
    }

    public void setAccessibility(boolean accessibility) {
        this.accessibility = accessibility;
    }
//    public String getName() {return this.name;}
//    public HashMap<String, Object> getAttributes() {
//        HashMap<String, Object> attributes = new HashMap<String, Object>();
//        attributes.put("address", this.address);
//        attributes.put("starRating", this.star_rating);
//        attributes.put("bathrooms", this.bathrooms);
//        return attributes;
//
//
//    }

}
