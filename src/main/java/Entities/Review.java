package Entities;
public class Review {
    int rating;
    String comment;
    
    public Review(int rate) {
        this.rating = rate;
        this.comment = "";   
    }
    
    public Review(int rate, String comment) {
        this.rating = rate;
        this.comment = comment;
        
    }
}
