import java.util.Map;
import java.util.List;

public class schoolMap extends HashMap{


    public schoolMap(){
        super();
        this.put("A1", new ArrayList<Building>());
        this.put("B1", new ArrayList<Building>());
        this.put("C1", new ArrayList<Building>());
        this.put("D1", new ArrayList<Building>());
        this.put("E1", new ArrayList<Building>());
        this.put("F1", new ArrayList<Building>());
        this.put("A2", new ArrayList<Building>());
        this.put("B2", new ArrayList<Building>());
        this.put("C2", new ArrayList<Building>());
        this.put("D2", new ArrayList<Building>());
        this.put("E2", new ArrayList<Building>());
        this.put("F2", new ArrayList<Building>());
        this.put("A3", new ArrayList<Building>());
        this.put("B3", new ArrayList<Building>());
        this.put("C3", new ArrayList<Building>());
        this.put("D3", new ArrayList<Building>());
        this.put("E3", new ArrayList<Building>());
        this.put("F3", new ArrayList<Building>());
        this.put("A4", new ArrayList<Building>());
        this.put("B4", new ArrayList<Building>());
        this.put("C4", new ArrayList<Building>());
        this.put("D4", new ArrayList<Building>());
        this.put("E4", new ArrayList<Building>());
        this.put("F4", new ArrayList<Building>());
        this.put("A5", new ArrayList<Building>());
        this.put("B5", new ArrayList<Building>());
        this.put("C5", new ArrayList<Building>());
        this.put("D5", new ArrayList<Building>());
        this.put("E5", new ArrayList<Building>());
        this.put("F5", new ArrayList<Building>());

    }

    public void addBuilding(string coord, Building bldg){
        this.get(coord).add(bldg)
    }
}