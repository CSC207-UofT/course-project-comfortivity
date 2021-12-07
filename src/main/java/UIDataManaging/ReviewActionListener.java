package UIDataManaging;

import Entities.Building;
import Entities.Review;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;


public class ReviewActionListener implements ActionListener {
    JButton confirmButton;
    JFrame reviewFrame;
    JTextField stringField;
    JTextField intField;
    public Boolean reviewFrameStillOpen;

    public ReviewActionListener(Building building) throws IOException {
        /**
         As you might guess, this method prompts a user response to the question prompt passed into it.
         it returns the user's answer.
         You can optionally pass in a param that is the length of answer the thing will accept
         */
        JPanel middlePanel = new JPanel();
        JPanel lowerPanel = new JPanel();
        JPanel higherPanel = new JPanel();
        JPanel masterPanel = new JPanel();
        JLabel promptLabel = new JLabel("Give your review of " + building.getName());
        this.stringField = new JTextField(100);
        this.intField = new JTextField(5);
        JLabel stringFieldLabel = new JLabel("Type your review of the building here (optional)");
        JLabel intFieldLabel = new JLabel("Enter your star rating, an integer 1-5");
        this.confirmButton = new JButton("Confirm");
        this.confirmButton.addActionListener(this);
        higherPanel.add(promptLabel);
        middlePanel.add(this.intField);
        middlePanel.add(intFieldLabel);
        lowerPanel.add(this.stringField);
        lowerPanel.add(stringFieldLabel);
        lowerPanel.add(confirmButton);
        masterPanel.add(higherPanel);
        masterPanel.add(middlePanel);
        masterPanel.add(lowerPanel);
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));

        this.reviewFrame = new JFrame("Prompt Screen");
        this.reviewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.reviewFrame.setSize(1500,600);
        this.reviewFrame.add(masterPanel);
        this.reviewFrame.setVisible(true);
        this.reviewFrameStillOpen = true;



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.reviewFrame.dispatchEvent(new WindowEvent(this.reviewFrame, WindowEvent.WINDOW_CLOSING));
        this.reviewFrame.setVisible(false);
        this.reviewFrameStillOpen = false;

    }

    public Review getReview(){
        return new Review(Integer.valueOf(this.intField.getText()), this.stringField.getText());
    }
}

