package Gateways;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

import Entities.Building;
import UseCases.BuildingDataInterface;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Projections;

public class BuildingGateway implements BuildingDataInterface {

    @Override
    public Building retrieveBuildingInfo(String code) {
        Building building = new Building();
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("comfortivity");
            MongoCollection<Document> collection = database.getCollection("buildings");
            building.setCode(code);
            try {
                String name = collection.distinct("name", eq("code", code), String.class).first();
                building.setName(name);
            } catch (MongoException me) {
                System.err.println("An error occurred: " + me);
            }
            try {
                String address = collection.distinct("address", eq("code", code), String.class).first();
                building.setAddress(address);
            } catch (MongoException me) {
                System.err.println("An error occurred: " + me);
            }
            try {
                Boolean group = collection.distinct("group", eq("code", code), Boolean.class).first();
                building.setGroup(Boolean.TRUE.equals(group));
            } catch (MongoException me) {
                System.err.println("An error occurred: " + me);
            }
            try {
                Boolean individual = collection.distinct("individual", eq("code", code), Boolean.class).first();
                building.setIndividual(Boolean.TRUE.equals(individual));
            } catch (MongoException me) {
                System.err.println("An error occurred: " + me);
            }
            try {
                Boolean bathroom = collection.distinct("bathroom", eq("code", code), Boolean.class).first();
                building.setGroup(Boolean.TRUE.equals(bathroom));
            } catch (MongoException me) {
                System.err.println("An error occurred: " + me);
            }
            try {
                Boolean water = collection.distinct("water", eq("code", code), Boolean.class).first();
                building.setGroup(Boolean.TRUE.equals(water));
            } catch (MongoException me) {
                System.err.println("An error occurred: " + me);
            }
            try {
                Boolean food = collection.distinct("food", eq("code", code), Boolean.class).first();
                building.setGroup(Boolean.TRUE.equals(food));
            } catch (MongoException me) {
                System.err.println("An error occurred: " + me);
            }
            try {
                Boolean accessibility = collection.distinct("accessibility", eq("code", code), Boolean.class).first();
                building.setGroup(Boolean.TRUE.equals(accessibility));
            } catch (MongoException me) {
                System.err.println("An error occurred: " + me);
            }
            return building;
        }
    }
}