package UIDataManaging;

import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import Entities.User;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;


import java.net.UnknownHostException;

public class MongoDB {
    public static void main(String[] args) {
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";
        // User user = new User("Abe", 16);
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database = mongoClient.getDatabase("comfortivity");
            MongoCollection<Document> collection = database.getCollection("users");
            // newUser(mongoClient, user);
            try {
                InsertOneResult result = collection.insertOne(new Document()
                        .append("name", "Abe").append("id", "16"));

                System.out.println("Success! Inserted document id: " + result.getInsertedId());
            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
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