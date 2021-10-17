public class NewReviewRequest implements RequestInterface{
    int student_id;
    int review;

    public NewReviewRequest(int student_id, Review review) {
        this.student_id = 0;
        this.review = review;
    }
}
