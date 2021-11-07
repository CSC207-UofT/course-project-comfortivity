import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class GUI  {

    public static void main(String args[]) throws IOException {
        displayWelcomeScreen();

        genericPromptUserResponse("hey answer this question");
    }

    public static void displayWelcomeScreen() throws IOException {
        /**
        As you might guess, this method opens a window displaying a 'welcome' screen
         */
        StartScreenActionListener AL = new StartScreenActionListener();
        int answer = 0;
        while(AL.welcomeFrameStillOpen){
            System.out.println("hi");
        }

    }

    public static String genericPromptUserResponse(String prompt) throws IOException {
        /**
         As you might guess, this method prompts a user response to the question prompt passed into it.
         it returns the user's answer.
         You can optionally pass in a param that is the length of answer the thing will accept.
         This is the overloaded one that just uses default length 15.
         */
        return genericPromptUserResponse(prompt, 15);


    }

    public static String genericPromptUserResponse(String prompt, int  maxResponseLength) throws IOException {
        /**
         As you might guess, this method prompts a user response to the question prompt passed into it.
         it returns the user's answer.
         You can optionally pass in a param that is the length of answer the thing will accept
         */
        JPanel lowerPanel = new JPanel();
        JPanel higherPanel = new JPanel();
        JPanel masterPanel = new JPanel();
        JLabel promptLabel = new JLabel(prompt);
        JTextField responseField = new JTextField(maxResponseLength);
        JLabel responseFieldLabel = new JLabel("enter response here");
        JButton confirmButton = new JButton("Confirm");
        higherPanel.add(promptLabel);
        lowerPanel.add(responseField);
        lowerPanel.add(responseFieldLabel);
        lowerPanel.add(confirmButton);
        masterPanel.add(higherPanel);
        masterPanel.add(lowerPanel);
        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));

        JFrame genericPromptFrame = new JFrame("Prompt Screen");
        genericPromptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        genericPromptFrame.setSize(600,100);
        genericPromptFrame.add(masterPanel);
        genericPromptFrame.setVisible(true);
        return("xoxo");

    }
}
