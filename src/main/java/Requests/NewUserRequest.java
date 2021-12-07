package Requests;


import Interfaces.InterfaceRequest;

public class NewUserRequest implements InterfaceRequest {
    public int student_id;
    //TODO i just made these public so it would compile. If you want we can make them private and use getters
    public String name;

    public NewUserRequest(int student_id, String name) {
        this.name = name;
        this.student_id = student_id;
    }


}
