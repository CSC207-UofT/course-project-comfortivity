package Entities.Users;

import java.util.HashMap;
import java.io.*;

public class Users implements Serializable{
    private HashMap<String, UserData> users;

    public Users() {
        users = new HashMap<>();
        loadData();
    }

    public void addUser(UserData user){
        users.put(user.getName(), user);
    }

    public String viewUser(UserData user) {
        if (users.containsKey(user.getName())) {
            return users.get(user.getName()).getStudentNumber();
        } else {
            return "User not found";
        }
    }

    public UserData searchName(String name){
        return users.getOrDefault(name, null);
    }

    public void saveData() {
        try {
            FileOutputStream fileOut = new FileOutputStream("users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        File file = new File("users.ser");
        if (!file.exists() || file.length() == 0) {
            System.out.println("File not available");
        } else {
            Users ud;
            try {
                FileInputStream fileIn = new FileInputStream("users.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                ud = (Users) in.readObject();
                in.close();
                fileIn.close();
                this.users = ud.users;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
