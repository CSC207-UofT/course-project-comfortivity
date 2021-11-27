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

public class LocationActionListener extends Observable implements ActionListener {
    JButton button;
    JFrame locationFrame;
    JTextField textField;
    public boolean locationFrameStillOpen;

    public LocationActionListener() throws IOException {
        /**
         Displays a campus map and asks the user to say where they are on it
         */
        this.locationFrame = new JFrame("StartUPScreen");
        this.locationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.locationFrame.setSize(900,900);
        this.textField = new JTextField(2);
        Toolkit toolkit =Toolkit.getDefaultToolkit();

        BufferedImage myPicture = ImageIO.read(new File("src\\main\\java\\Map_of_Campus-1.jpg"));

        this.locationFrame.setVisible(true);

        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JPanel welcomeImagePanel = new JPanel();
        welcomeImagePanel.add(picLabel);
        this.button = new JButton("Confirm");
        this.button.addActionListener(this);
        JPanel locationLowerPanel = new JPanel();
        locationLowerPanel.add(new JLabel("Enter your location according to this map, letter then number, " +
    "for example B4"));
        locationLowerPanel.add(button);
        locationLowerPanel.add(this.textField);
        JPanel locationPanel = new JPanel();
        locationPanel.setLayout(new BoxLayout(locationPanel, BoxLayout.Y_AXIS));
        locationPanel.add(locationLowerPanel);
        locationPanel.add(welcomeImagePanel);
        this.locationFrame.add(locationPanel);
        this.locationFrame.setVisible(true);
        this.locationFrameStillOpen = true;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.locationFrame.dispatchEvent(new WindowEvent(this.locationFrame, WindowEvent.WINDOW_CLOSING));
        this.locationFrame.setVisible(false);
        this.locationFrameStillOpen = false;

    }

    public String getLocation(){
        return this.textField.getText();
    }
}
