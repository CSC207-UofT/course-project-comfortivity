package Requests;


import Interfaces.RequestInterface;

public class RetrieveProfileRequest implements RequestInterface {
    public int student_id;
    //TODO i just made this public so it would compile. If you want we can make it private and use getters

    public RetrieveProfileRequest(int student_id) {
        this.student_id = student_id;
    }

}
