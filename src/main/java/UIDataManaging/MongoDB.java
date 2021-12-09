package UIDataManaging;


import Entities.Building;
import Gateways.BuildingGateway;
import Gateways.schoolMap;
import UseCases.BuildingDataInterface;
import UseCases.BuildingUseCase;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.result.InsertOneResult;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class MongoDB {
    public static void main(String[] args) {
        schoolMap new_map = new schoolMap();
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";
        for (char alphabet = 'A'; alphabet <= 'F'; alphabet++) {
            for (int i = 1; i <= 5; i++) {
                String address = alphabet + String.valueOf(i);
                ArrayList<Building> buildings = new ArrayList<>();
                BuildingDataInterface bdi = new BuildingGateway();
                try (MongoClient mongoClient = MongoClients.create(uri)) {
                    MongoDatabase database = mongoClient.getDatabase("comfortivity");
                    MongoCollection<Document> collection = database.getCollection("buildings");
                    try {
                        DistinctIterable<String> docs = collection.distinct(
                                "code", Filters.eq("address", address),
                                String.class);
                        MongoCursor<String> results = docs.iterator();
                        while(results.hasNext()) {
                            buildings.add(BuildingUseCase.loadBuilding(results.next(), bdi));
                        }
                        // new_map.put(address, buildings);
                    } catch (MongoException me) {
                        System.err.println("An error occurred: " + me);
                }
            }
        }
    }

//    public static void newUser(MongoClient mongoClient, User user) {
//        try {
//            MongoDatabase database = mongoClient.getDatabase("comfortivity");
//            MongoCollection<Document> collection = database.getCollection("users");
//            InsertOneResult result = collection.insertOne(new Document().append("name", user.getName()).append("id", user.getStudentNumber()));
//            System.out.println("Success! Inserted document id: " + result.getInsertedId());
//        } catch (MongoException me) {
//            System.err.println("Unable to insert due to an error: " + me);
//        }
    }
} 