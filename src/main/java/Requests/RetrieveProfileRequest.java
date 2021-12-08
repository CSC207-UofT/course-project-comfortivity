package Requests;


import Interfaces.InterfaceRequest;

public class RetrieveProfileRequest implements InterfaceRequest {
    // a request class that contains the information needed for the code to retrieve an already created profile
    public int student_id;


    public RetrieveProfileRequest(int student_id) {
        this.student_id = student_id;
    }

}
