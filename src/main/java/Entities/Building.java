package Entities;
import Interfaces.Buildable;
import UIDataManaging.DataManager;

import java.util.*;


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
