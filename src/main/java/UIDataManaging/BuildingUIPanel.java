package UIDataManaging;
import Entities.Building;

import javax.swing.*;




public class BuildingUIPanel extends JPanel {

    public BuildingUIPanel(Building building) {
        super();
        JLabel nameLabel = new JLabel(building.getName());
        JLabel addressLabel = new JLabel(building.getAddress());
        JLabel starLabel = new JLabel("       " + building.getStar_rating() + " stars");
        //TODO this and put it into the panel
        // JLabel reviewLabel = new JLabel(building.getTopReview());
        JPanel upperPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        upperPanel.add(nameLabel);
        upperPanel.add(starLabel);
        middlePanel.add(addressLabel);
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));
        this.add(upperPanel);
        this.add(middlePanel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
