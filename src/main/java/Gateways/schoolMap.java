package Gateways;
import java.util.HashMap;
import java.util.ArrayList;


import static com.mongodb.client.model.Filters.eq;

import Entities.Building;
import UseCases.BuildingDataInterface;
import UseCases.BuildingUseCase;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

//move to gateway package
public class schoolMap extends HashMap<String, ArrayList<Building>> {


    public static schoolMap retrieveMapInfo(){
        schoolMap new_map = new schoolMap();
//        new_map.put("A1", new ArrayList<Building>());
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";
        String output = "";
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
                            System.out.println(results.next());
                        }
                        new_map.put(address, buildings);
                    } catch (MongoException me) {
                        System.err.println("An error occurred: " + me);
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

