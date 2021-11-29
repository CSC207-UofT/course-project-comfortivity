
public class NewUserRequest implements InterfaceRequest {
    int student_id;
    String name;

    public NewUserRequest(int student_id, String name) {
        this.name = name;
        this.student_id = student_id;
    }


}
