package UIDataManaging;

import Entities.Building;

import javax.swing.*;
import java.util.ArrayList;


public class SearchResultUIFrame extends JFrame {

    public SearchResultUIFrame(ArrayList<Building> buildings){
        super("Search Results");
        JPanel ourPanel = new JPanel();
        for (Building building : buildings) {
            JPanel newPanel = new BuildingUIPanel(building);
            ourPanel.add(newPanel);
        }
        ourPanel.setLayout(new BoxLayout(ourPanel, BoxLayout.Y_AXIS));
        this.add(ourPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,100 * buildings.size());

    }
}
