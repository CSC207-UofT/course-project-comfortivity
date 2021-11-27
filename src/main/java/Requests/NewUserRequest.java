package Requests;
import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;
import Interfaces.*;
import Mapping.*;
import Interfaces.*;
public class NewUserRequest implements RequestInterface {
    public int student_id;
    //TODO i just made these public so it would compile. If you want we can make them private and use getters
    public String name;

    public NewUserRequest(int student_id, String name) {
        this.name = name;
        this.student_id = student_id;
    }


}
