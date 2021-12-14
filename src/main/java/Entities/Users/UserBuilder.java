package Entities.Users;

import Entities.Users.UserData;

public class UserBuilder {
    /**
     * Builder for user entity
     */
    private final UserData u;

    public UserBuilder() {
        this.u = new UserData();
    }

    public void setName(String n) {
        u.setName(n);
    }

    public void setStudentNumber(String studentNumber){
        u.setStudentNumber(studentNumber);
    }

    public void setLocation(String location){
        u.setLocation(location);
    }

    public UserData getUser() {
        return u;
    }
}
