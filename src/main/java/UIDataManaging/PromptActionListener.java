package UIDataManaging;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;
import Interfaces.*;
import Mapping.*;
public class PromptActionListener extends Observable implements ActionListener {
    JButton confirmButton;
    JFrame genericPromptFrame;
    JTextField textField;
    public boolean promptFrameStillOpen;

    public PromptActionListener(String prompt, int maxResponseLength) throws IOException {
        /**
         As you might guess, this method prompts a user response to the question prompt passed into it.
         it returns the user's answer.
         You can optionally pass in a param that is the length of answer the thing will accept
         */
        JPanel lowerPanel = new JPanel();
        JPanel higherPanel = new JPanel();
        JPanel masterPanel = new JPanel();
        JLabel promptLabel = new JLabel(prompt);
        this.textField = new JTextField(maxResponseLength);
        JLabel responseFieldLabel = new JLabel("enter response here");
        this.confirmButton = new JButton("Confirm");
        this.confirmButton.addActionListener(this);
        higherPanel.add(promptLabel);
        lowerPanel.add(this.textField);
        lowerPanel.add(responseFieldLabel);
        lowerPanel.add(confirmButton);
        masterPanel.add(higherPanel);
        masterPanel.add(lowerPanel);
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));

        this.genericPromptFrame = new JFrame("Prompt Screen");
        this.genericPromptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.genericPromptFrame.setSize(600,100);
        this.genericPromptFrame.add(masterPanel);
        this.genericPromptFrame.setVisible(true);
        this.promptFrameStillOpen = true;



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.genericPromptFrame.dispatchEvent(new WindowEvent(this.genericPromptFrame, WindowEvent.WINDOW_CLOSING));
        this.genericPromptFrame.setVisible(false);
        this.promptFrameStillOpen = false;

    }

    public String getResponse(){
        return this.textField.getText();
    }
}
