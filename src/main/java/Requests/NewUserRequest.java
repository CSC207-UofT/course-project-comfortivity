package Requests;
import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;
import Interfaces.*;
import Mapping.*;
import Interfaces.*;
public class NewUserRequest implements RequestInterface {
    int student_id;
    String name;

    public NewUserRequest(int student_id, String name) {
        this.name = name;
        this.student_id = student_id;
    }


}
