package Requests;
import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;
import Interfaces.*;
import Mapping.*;
public class NewReviewRequest implements RequestInterface{
    //Todo I just made these public so it would compile. Maybe make them private and make getters instead?
    public int student_id;
    public Review review;
    public Building revbuilding;

    public NewReviewRequest(int student_id, Review review, Building reviewed) {
        this.student_id = student_id;
        this.review = review;
        this.revbuilding = reviewed;
    }
    
    public NewReviewRequest(int student_id, int starrating, Building reviewed) {
        this.student_id = student_id;
        Review review = new Review(starrating, "");
        this.review = review;
        this.revbuilding = reviewed;
    }
}