package Requests;


import Interfaces.InterfaceRequest;

public class NewUserRequest implements InterfaceRequest {
    //  a request class that contains the information needed for the code to create a new user
    public int student_id;
    public String name;

    public NewUserRequest(int student_id, String name) {
        this.name = name;
        this.student_id = student_id;
    }


}
