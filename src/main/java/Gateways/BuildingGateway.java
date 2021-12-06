package Gateways;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

import Entities.Building;
import UseCases.BuildingDataInterface;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

public class BuildingGateway implements BuildingDataInterface {

    @Override
    public Building retrieveBuildingInfo(String code) {
        Building building = new Building();
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("comfortivity");
            MongoCollection<Document> collection = database.getCollection("buildings");
            Bson projectionFields = Projections.fields(
                    Projections.include("code"),
                    Projections.excludeId());
            Document doc = collection.find(eq("code", code))
                    .projection(projectionFields)
                    .first();
            if (doc == null) {
                System.out.println("sorry nothing found");
            } else {
                building.setCode(code);
                building.setName((String) doc.get("name"));
                building.setAddress((String) doc.get("address"));
                building.setStar_rating((Integer) doc.get("star_rating"));
                building.setGroup((Boolean) doc.get("group"));
                building.setIndividual((Boolean) doc.get("individual"));
                building.setBathrooms((Boolean) doc.get("bathrooms"));
                building.setWater((Boolean) doc.get("water"));
                building.setFood((Boolean) doc.get("food"));
                building.setAccessibility((Boolean) doc.get("accessibility"));
                //System.out.println(doc.toJson());
            }
            return building;
        }
    }
}