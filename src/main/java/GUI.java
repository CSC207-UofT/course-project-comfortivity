import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;

public class GUI {

    public static void main(String args[]) throws IOException {
        displayWelcomeScreen();
    }

    public static void displayWelcomeScreen() throws IOException {
        /**
        As you might guess, this method opens a window displaying a 'welcome' screen
         */

        JFrame welcomeFrame = new JFrame("StartupScreen");
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(600,600);

        Toolkit toolkit =Toolkit.getDefaultToolkit();
        BufferedImage myPicture = ImageIO.read(new File("src\\main\\java\\welcomeImage.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        welcomeFrame.setVisible(true);

        JPanel welcomeImagePanel = new JPanel();
        welcomeImagePanel.add(picLabel);
        JButton button = new JButton("START");
        JPanel welcomeButtonPanel = new JPanel();
        welcomeButtonPanel.add(button);
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.add(welcomeButtonPanel);
        welcomePanel.add(welcomeImagePanel);
        welcomeFrame.add(welcomePanel);

    }
}
