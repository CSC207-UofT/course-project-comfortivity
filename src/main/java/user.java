import java.util.Map;
import java.util.List;

public class User {
    private int studentNumber;
    private String name;
    private String location;
    private HashMap reviews;
    private HashMap filters;

    public User(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.location = "";
        this.reviews = new HashMap<Building, Review>();
        this.filters = new HashMap<String, boolean>;
    }

}