public class NewReviewRequest implements RequestInterface{
    int student_id;
    Review review;
    Building revbuilding;

    public NewReviewRequest(int student_id, Review review, Building reviewed) {
        this.student_id = student_id;
        this.review = review;
        this.revbuilding = reviewed;
    }
}
