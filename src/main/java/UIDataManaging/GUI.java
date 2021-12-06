package UIDataManaging;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import Entities.*;
import UIDataManaging.*;
import Requests.*;
import UseCases.*;
import Interfaces.*;

public class GUI  {

   /** public static void main(String args[]) throws IOException, InterruptedException {
        //UIController.welcomeTheUser();
        //System.out.println(UIController.askTheUser("Hey how old are you?"));
        ArrayList<Building> buildings = new ArrayList<Building>();
        Building building1 = new Building("Whitney Hall", "85 St George St", true, 7);
        Building building2 = new Building("Morrison Hall", "75 St George St", true, 5);
        Building building3 = new Building("My Hall", "55 St George St", true, 6);
        Building building4 = new Building("Your Hall", "15 St George St", true, 7);
        buildings.add(building1);
        buildings.add(building2);
        buildings.add(building3);
        buildings.add(building4);
        SearchResultUIFrame searchResultFrame = new SearchResultUIFrame(buildings);
        searchResultFrame.setVisible(true);
    } */

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

    public static void displaySearchResultFrame(ArrayList<Building> buildings) {
        SearchResultUIFrame searchResultFrame = new SearchResultUIFrame(buildings);
        searchResultFrame.setVisible(true);
    }

    public static Review getThemToReview(Building building) throws InterruptedException, IOException {

        ReviewActionListener reviewFrame = new ReviewActionListener(building);
        while(reviewFrame.reviewFrameStillOpen){
            Thread.sleep(100);
        }
        return reviewFrame.getReview();
    }

    public static HashMap promptTheirPreferences() throws InterruptedException, IOException {
        PreferenceActionListener preferenceFrame = new PreferenceActionListener();
        while(preferenceFrame.preferenceFrameStillOpen){
            Thread.sleep(100);
        }

        return preferenceFrame.getPreferences();
    }

    public static String promptTheirLocation() throws InterruptedException, IOException {
        LocationActionListener locationFrame = new LocationActionListener();
        while(locationFrame.locationFrameStillOpen){
            Thread.sleep(100);
        }

        return locationFrame.getLocation();
    }
}
