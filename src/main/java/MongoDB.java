import com.mongodb.*;

import java.net.UnknownHostException;

public class MongoDB {
    public static MongoClient mongoClient;
    // creates Client
    public static DB database;
    // creates database inside Client
    public static DBCollection test;
    // creates collection inside database
    public static void main(String[] args) throws UnknownHostException {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        // throws UnknownHostException
        database = mongoClient.getDB("Comfortivity");
        test = database.getCollection("test");
        User user = new User("Abe", 16);
        DBObject query = new BasicDBObject();
        // query can be any or all of 3 user attributes ("name", "ID", "preferences")
        DBCursor cursor = test.find(query);
        test.findAndModify(query, convert(user));
        cursor = test.find(query);
        System.out.println(cursor.one());
    }

    public static DBObject convert(User user){
        return new BasicDBObject("name", user.getName()).append("ID",
                user.getStudentNumber()).append("preferences", user.getPreferences());
    }
}