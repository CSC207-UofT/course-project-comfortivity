package Gateways;

import Entities.User;
import UseCases.UserDataInterface;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


import static com.mongodb.client.model.Filters.eq;

public class UserGateway implements UserDataInterface {

    @Override
    public void updateNewUserInfo(String name, int id) {
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("comfortivity");
            MongoCollection<Document> collection = database.getCollection("users");
            Bson projectionFields = Projections.fields(
                    Projections.include("id"),
                    Projections.excludeId());
            Document doc = collection.find(eq("id", id))
                    .projection(projectionFields)
                    .first();
            if (doc == null) {
                try {
                    InsertOneResult result = collection.insertOne(new Document()
                            .append("_id", new ObjectId())
                            .append("id", id)
                            .append("name", name));
                    System.out.println("Success! Inserted document id: " + result.getInsertedId());
                } catch (MongoException me) {
                    System.err.println("Unable to insert due to an error: " + me);
                }
            } else {
                Bson updates = Updates.combine(Updates.set("name", name));
                try {
                    collection.updateOne(doc, updates);
                } catch (MongoException me) {
                    System.err.println("Unable to update due to an error: " + me);
                }
            }
        }
    }

    @Override
    public String retrieveUserName(int id) {
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("comfortivity");
            MongoCollection<Document> collection = database.getCollection("users");
            return collection.distinct("name", eq("id", id), String.class).first();
        }
    }

}