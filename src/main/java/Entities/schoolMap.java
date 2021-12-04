package Entities;
import java.util.HashMap;
import java.util.ArrayList;

import UIDataManaging.*;

import static com.mongodb.client.model.Filters.lt;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

//move to entities package
public class schoolMap extends HashMap{


    public static void retrieveMap(){
        // hardcoded for now, but in the future this will draw from data files i expect.
        schoolMap new_map = new schoolMap();
//        new_map.put("A1", new ArrayList<Building>());
//        new_map.put("B1", new ArrayList<Building>());
//        new_map.put("C1", new ArrayList<Building>());
//        new_map.put("D1", new ArrayList<Building>());
//        new_map.put("E1", new ArrayList<Building>());
//        new_map.put("F1", new ArrayList<Building>());
//        new_map.put("A2", new ArrayList<Building>());
//        new_map.put("B2", new ArrayList<Building>());
//        new_map.put("C2", new ArrayList<Building>());
//        new_map.put("D2", new ArrayList<Building>());
//        new_map.put("E2", new ArrayList<Building>());
//        new_map.put("F2", new ArrayList<Building>());
//        new_map.put("A3", new ArrayList<Building>());
//        new_map.put("B3", new ArrayList<Building>());
//        new_map.put("C3", new ArrayList<Building>());
//        new_map.put("D3", new ArrayList<Building>());
//        new_map.put("E3", new ArrayList<Building>());
//        new_map.put("F3", new ArrayList<Building>());
//        new_map.put("A4", new ArrayList<Building>());
//        new_map.put("B4", new ArrayList<Building>());
//        new_map.put("C4", new ArrayList<Building>());
//        new_map.put("D4", new ArrayList<Building>());
//        new_map.put("E4", new ArrayList<Building>());
//        new_map.put("F4", new ArrayList<Building>());
//        new_map.put("A5", new ArrayList<Building>());
//        new_map.put("B5", new ArrayList<Building>());
//        new_map.put("C5", new ArrayList<Building>());
//        new_map.put("D5", new ArrayList<Building>());
//        new_map.put("E5", new ArrayList<Building>());
//        new_map.put("F5", new ArrayList<Building>());
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("comfortivity");
            MongoCollection<Document> collection = database.getCollection("map");
            Bson projectionFields = Projections.fields(Projections.include("title", "imdb"), Projections.excludeId());
        }
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
    if(buildings.size() == 0){
        return Main.getListContainingEmptyBuilding();
    }
    return buildings;
    }
}

