import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class schoolMap extends HashMap{


    public static void Load_Map(){
        // hardcoded for now, but in the future this will draw from data files i expect.
        schoolMap new_map = new schoolMap();
        new_map.put("A1", new ArrayList<Building>());
        new_map.put("B1", new ArrayList<Building>());
        new_map.put("C1", new ArrayList<Building>());
        new_map.put("D1", new ArrayList<Building>());
        new_map.put("E1", new ArrayList<Building>());
        new_map.put("F1", new ArrayList<Building>());
        new_map.put("A2", new ArrayList<Building>());
        new_map.put("B2", new ArrayList<Building>());
        new_map.put("C2", new ArrayList<Building>());
        new_map.put("D2", new ArrayList<Building>());
        new_map.put("E2", new ArrayList<Building>());
        new_map.put("F2", new ArrayList<Building>());
        new_map.put("A3", new ArrayList<Building>());
        new_map.put("B3", new ArrayList<Building>());
        new_map.put("C3", new ArrayList<Building>());
        new_map.put("D3", new ArrayList<Building>());
        new_map.put("E3", new ArrayList<Building>());
        new_map.put("F3", new ArrayList<Building>());
        new_map.put("A4", new ArrayList<Building>());
        new_map.put("B4", new ArrayList<Building>());
        new_map.put("C4", new ArrayList<Building>());
        new_map.put("D4", new ArrayList<Building>());
        new_map.put("E4", new ArrayList<Building>());
        new_map.put("F4", new ArrayList<Building>());
        new_map.put("A5", new ArrayList<Building>());
        new_map.put("B5", new ArrayList<Building>());
        new_map.put("C5", new ArrayList<Building>());
        new_map.put("D5", new ArrayList<Building>());
        new_map.put("E5", new ArrayList<Building>());
        new_map.put("F5", new ArrayList<Building>());

    }

    public void addBuilding(String coord, Building bldg){
        ((ArrayList)((HashMap) this).get(coord)).add(bldg);
    }
}
