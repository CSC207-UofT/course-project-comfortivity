package UIDataManaging;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;
import Interfaces.*;
import Entities.User;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import Mapping.*;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.eq;

public class DataManager {

    public static String connectionString = "mongodb+srv://Comfortivity:<CSC207>@cluster0.rgnj6.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
    public static MongoClient mongoClient = MongoClients.create(connectionString);
    public static MongoDatabase database = mongoClient.getDatabase("Comfortivity");

    public static void updateNewReview(int id, Review review, Building building) {
        // Take the new review, the building for which the review is, and user's student number
        // to update the review for that user or add a review for that building if not already there in the file.
        // THIS IS TEMPORARY.
        MongoCollection<Document> collection = database.getCollection("reviews");
        InsertOneResult result = collection.insertOne(new Document().append("comment",
                review.getComment()).append("rating", review.getRating()).append("building",
                building.getName()).append("id", id));
    }

    public static schoolMap loadMapFromFile(){
        schoolMap mapToReturn = new schoolMap();
        return mapToReturn;

    }

    public static void updateNewUser(int id, String name) {
        // Take the new user's student number and name to update the name of the user with that student number or
        // add the student number with the name if it doesn't exist already in the file.
        // THIS IS TEMPORARY.
        MongoCollection<Document> collection = database.getCollection("users");
        Bson projectionFields = Projections.fields(Projections.include("id"), Projections.excludeId());
        Document doc = collection.find(eq("id", id)).first();
        if (doc == null) {
            InsertOneResult result = collection.insertOne(new Document().append("name", name).append("id", id));
        }
        else {
            Bson query = eq("id", id);
            Document replaceDocument = new Document().append("name", name).append("id", id);
            ReplaceOptions opts = new ReplaceOptions().upsert(true);
            UpdateResult result = collection.replaceOne(query, replaceDocument, opts);
        }
    }

    public static User profileReturn(int studentNumber) {
        // Load the data from the given file corresponding to the student with number studentNumber
        // into a Collection object info and return it.
        // THIS IS TEMPORARY.
        User studentdata = new User("jeff", 100);
        return studentdata;
    }

    public static ArrayList<Building> buildingReturn() {
        // Load all the data for the buildings from the given file as elements of a Collection object, with each
        // element corresponding to a building's information.
        // THIS IS TEMPORARY.
        ArrayList<Building> buildings = new ArrayList<Building>();
        return buildings;
    }
}
