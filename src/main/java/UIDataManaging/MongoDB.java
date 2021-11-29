package UIDataManaging;


import Entities.User;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;


import java.net.UnknownHostException;

public class MongoDB {
//    public static MongoClient mongoClient;
//    // creates Client
//    public static DB database;
//    // creates database inside Client
//    public static DBCollection test;
//    //creates collection inside database

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://Comfortivity:<CSC207>@cluster0.rgnj6.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
        User user = new User("Abe", 16);
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            newUser(mongoClient, user);
        }
//        mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://Comfortivity:<CSC207>@cluster0.rgnj6.mongodb.net/myFirstDatabase?retryWrites=true&w=majority"));
//        database = mongoClient.getDB("Users");
//        test = database.getCollection("User");
    }

    public static void newUser(MongoClient mongoClient, User user) {
        MongoDatabase database = mongoClient.getDatabase("users");
        MongoCollection<Document> collection = database.getCollection("user");
        InsertOneResult result = collection.insertOne(new Document().append("name", user.getName()).append("id", user.getStudentNumber()));
    }

    public static DBObject convert(User user) {
        return new BasicDBObject("name", user.getName()).append("studentnumber", user.getStudentNumber());
    }
} 