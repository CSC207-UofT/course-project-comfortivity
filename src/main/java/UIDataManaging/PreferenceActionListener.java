package UIDataManaging;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;



public class PreferenceActionListener implements ActionListener {
    JButton confirmButton;
    JFrame preferenceFrame;
    JCheckBox groupBox;
    JCheckBox tablesBox;
    JCheckBox privacyBox;
    JCheckBox bathroomBox;
    JCheckBox waterBox;
    JCheckBox foodBox;
    JCheckBox accessibilityBox;
    public Boolean preferenceFrameStillOpen;

    public PreferenceActionListener() throws IOException {
        /**
         As you might guess, this method prompts a user response to the question prompt passed into it.
         it returns the user's answer.
         You can optionally pass in a param that is the length of answer the thing will accept
         */
        this.groupBox = new JCheckBox("Group Study Space");
        this.tablesBox = new JCheckBox("Tables");
        this.privacyBox = new JCheckBox("Private Study Space");
        this.bathroomBox = new JCheckBox("Bathrooms");
        this.waterBox = new JCheckBox("Water Fountains");
        this.foodBox = new JCheckBox("Food");
        this.accessibilityBox = new JCheckBox("Accessibility");
        JPanel lowerPanel = new JPanel();
        JPanel higherPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel masterPanel = new JPanel();
        JLabel promptLabel = new JLabel("Which of these things do you want to REQUIRE?");
        this.confirmButton = new JButton("Confirm");
        this.confirmButton.addActionListener(this);
        higherPanel.add(promptLabel);
        middlePanel.add(this.groupBox);
        middlePanel.add(this.tablesBox);
        middlePanel.add(this.privacyBox);
        middlePanel.add(this.bathroomBox);
        middlePanel.add(this.waterBox);
        middlePanel.add(this.accessibilityBox);
        lowerPanel.add(confirmButton);
        masterPanel.add(higherPanel);
        masterPanel.add(middlePanel);
        masterPanel.add(lowerPanel);
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));

        this.preferenceFrame = new JFrame("Preferences Screen");
        this.preferenceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.preferenceFrame.setSize(300,300);
        this.preferenceFrame.add(masterPanel);
        this.preferenceFrame.setVisible(true);
        this.preferenceFrameStillOpen = true;



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.preferenceFrame.dispatchEvent(new WindowEvent(this.preferenceFrame, WindowEvent.WINDOW_CLOSING));
        this.preferenceFrame.setVisible(false);
        this.preferenceFrameStillOpen = false;

    }

    public HashMap getPreferences(){
        HashMap preferences = new HashMap();
        preferences.put("Group", groupBox.isSelected());
        preferences.put("Tables", tablesBox.isSelected());
        preferences.put("Privacy", privacyBox.isSelected());
        preferences.put("Bathroom", bathroomBox.isSelected());
        preferences.put("Water", waterBox.isSelected());
        preferences.put("Accessibility", accessibilityBox.isSelected());
        return preferences;
    }
}

