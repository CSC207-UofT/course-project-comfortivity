package Entities;
public class Review {
    int rating;
    String comment;

    public Review(int rate, String comment) {
        this.rating = rate;
        this.comment = comment;
        
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
