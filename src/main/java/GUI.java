import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class GUI  {

    public static void main(String args[]) throws IOException, InterruptedException {
        UIController.welcomeTheUser();
        System.out.println(UIController.askTheUser("Hey how old are you?"));
    }

    public static void displayWelcomeScreen() throws IOException, InterruptedException {
        /**
        As you might guess, this method opens a window displaying a 'welcome' screen
         */
        StartScreenActionListener AL = new StartScreenActionListener();
        while(AL.welcomeFrameStillOpen){
            Thread.sleep(100);
        }
        // AL.welcomeFrame.dispatchEvent(new WindowEvent(AL.welcomeFrame, WindowEvent.WINDOW_CLOSING));

    }

    public static String genericPromptUserResponse(String prompt) throws IOException, InterruptedException {
        /**
         As you might guess, this method prompts a user response to the question prompt passed into it.
         it returns the user's answer.
         You can optionally pass in a param that is the length of answer the thing will accept.
         This is the overloaded one that just uses default length 15.
         */
        return genericPromptUserResponse(prompt, 15);


    }

    public static String genericPromptUserResponse(String prompt, int  maxResponseLength) throws IOException,
            InterruptedException {
        /**
         As you might guess, this method prompts a user response to the question prompt passed into it.
         it returns the user's answer.
         You can optionally pass in a param that is the length of answer the thing will accept
         */
        PromptActionListener AL = new PromptActionListener(prompt, maxResponseLength);
        while(AL.promptFrameStillOpen){
            Thread.sleep(100);
        }

        return AL.getResponse();

    }
}
