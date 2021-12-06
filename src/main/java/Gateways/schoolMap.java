package Gateways;
import java.util.HashMap;
import java.util.ArrayList;


import static com.mongodb.client.model.Filters.eq;

import Entities.Building;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

//move to gateway package
public class schoolMap extends HashMap{


    public static schoolMap retrieveMapInfo(){
        schoolMap new_map = new schoolMap();
//        new_map.put("A1", new ArrayList<Building>());
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";
        String output = "";
        for (char alphabet = 'A'; alphabet <= 'F'; alphabet++) {
            for (int i = 1; i <= 5; i++) {
                int location = alphabet + i;
                String code = String.valueOf(location);
                try (MongoClient mongoClient = MongoClients.create(uri)) {
                    MongoDatabase database = mongoClient.getDatabase("comfortivity");
                    MongoCollection<Document> collection = database.getCollection("map");
                    Bson projectionFields = Projections.fields(Projections.include("location"), Projections.excludeId());
                    Document doc = collection.find(eq("location", code))
                            .projection(projectionFields)
                            .sort(Sorts.descending("location"))
                            .first();
                    if (doc == null) {
                        System.out.println("No results found.");
                    } else {
                        new_map.put(code, doc);
                    }
                }
            }
        }
        return new_map;
    }

    public void addBuilding(String coord, Building bldg){
        ((ArrayList)((HashMap) this).get(coord)).add(bldg);
    }

    public ArrayList<Building> getAllBuildings(){
        ArrayList<Building> buildings = new ArrayList<Building>();
        for(Object key : this.keySet()){

            for(Object building : (ArrayList) this.get(key)){
                buildings.add((Building) building);
            }
        }

    return buildings;
    }
}

