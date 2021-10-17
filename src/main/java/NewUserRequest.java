public class NewUserRequest implements RequestInterface{
    int student_id;
    String name;

    public NewUserRequest(int student_id, String name) {
        this.name = name;
        this.student_id = 0;
    }

