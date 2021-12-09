package Gateways;

import Entities.Building;
import Entities.Review;
import Entities.User;
import UseCases.ReviewDataInterface;
import UseCases.ReviewUseCase;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class ReviewGateway implements ReviewDataInterface {

    /**
     * Adds review info to database
     * @param user user who wrote the review
     * @param building building the review is about
     * @param review the review whose info is being added to the database
     */
    @Override
    public void addReviewInfo(User user, Building building, Review review) {
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("comfortivity");
            MongoCollection<Document> collection = database.getCollection("reviews");
            try {
                InsertOneResult result = collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("rating", review.getRating())
                        .append("comment", review.getComment())
                        .append("id", user.getStudentNumber())
                        .append("building", building.getCode()));
            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
            }
        }
    }

    /**
     * Returns an ArrayList of all reviews from database for a building specified by code
     * @param code specifies building found in database
     * @return returns ArrayList of reviews
     */
    @Override
    public ArrayList<Review> retrieveReviews(String code) {
        String uri = "mongodb+srv://Comfortivity:CSC207@cluster0.rgnj6.mongodb.net/comfortivity?retryWrites=true&w=majority";
        ArrayList<Review> reviews = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("comfortivity");
            MongoCollection<Document> collection = database.getCollection("reviews");
            try {

                DistinctIterable<Integer> rating = collection.distinct(
                        "rating", Filters.eq("building", code),
                        Integer.class);
                MongoCursor<Integer> ratings = rating.iterator();

                DistinctIterable<String> comment = collection.distinct(
                        "comment", Filters.eq("building", code),
                        String.class);
                MongoCursor<String> comments = comment.iterator();

                while(ratings.hasNext()) {
                    reviews.add(ReviewUseCase.loadReview(ratings.next(), comments.next()));
                }
            } catch (MongoException me) {
                System.err.println("An error occurred: " + me);
            }
        }
        return reviews;
    }
}
