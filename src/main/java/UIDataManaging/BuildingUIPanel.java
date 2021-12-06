package UIDataManaging;
import Entities.Building;

import javax.swing.*;




public class BuildingUIPanel extends JPanel {

    public BuildingUIPanel(Building building) {
        super();
        JLabel nameLabel = new JLabel(building.getName());
        JLabel addressLabel = new JLabel(building.getAddress());
        JLabel starLabel = new JLabel("       " + building.getStarRating() + " stars");

        JLabel reviewLabel = new JLabel(building.getTopReview().getComment());
        JPanel upperPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel lowerPanel = new JPanel();
        upperPanel.add(nameLabel);
        upperPanel.add(starLabel);
        lowerPanel.add(reviewLabel);
        middlePanel.add(addressLabel);
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));
        this.add(upperPanel);
        this.add(middlePanel);
        this.add(lowerPanel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
