package Gateways;
import java.util.HashMap;
import java.util.ArrayList;

import Entities.Building;
import UseCases.BuildingDataInterface;
import UseCases.BuildingUseCase;
import UseCases.SchoolMapDataInterface;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class schoolMap extends HashMap<String, ArrayList<Building>> implements SchoolMapDataInterface {

    /**
     * Instantiates schoolMap based on all buildings from database
     * @return returns an instance of schoolMap built from all buildings in database
     */
    @Override
    public schoolMap retrieveMapInfo(){
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
                        new_map.put(address, buildings);
                    } catch (MongoException me) {
                        System.err.println("An error occurred: " + me);
                    }
                }
            }
        }
        return new_map;
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

