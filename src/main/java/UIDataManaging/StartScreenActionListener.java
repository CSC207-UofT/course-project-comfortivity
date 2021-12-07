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


public class StartScreenActionListener extends Observable implements ActionListener {
    JButton button;
    JFrame welcomeFrame;
    public boolean welcomeFrameStillOpen;

public StartScreenActionListener() throws IOException {
    /**
     As you might guess, this method opens a window displaying a 'welcome' screen
     */
    this.welcomeFrame = new JFrame("StartUPScreen");
    this.welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.welcomeFrame.setSize(600,600);

    Toolkit toolkit =Toolkit.getDefaultToolkit();
    BufferedImage myPicture = ImageIO.read(new File("src\\main\\java\\welcomeImage.png"));
    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    this.welcomeFrame.setVisible(true);

    JPanel welcomeImagePanel = new JPanel();
    welcomeImagePanel.add(picLabel);
    this.button = new JButton("START");
    this.button.addActionListener(this);
    JPanel welcomeButtonPanel = new JPanel();
    welcomeButtonPanel.add(button);
    JPanel welcomePanel = new JPanel();
    welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
    welcomePanel.add(welcomeButtonPanel);
    welcomePanel.add(welcomeImagePanel);
    this.welcomeFrame.add(welcomePanel);
    this.welcomeFrame.setVisible(true);
    this.welcomeFrameStillOpen = true;


}

    @Override
    public void actionPerformed(ActionEvent e) {
    this.welcomeFrame.dispatchEvent(new WindowEvent(this.welcomeFrame, WindowEvent.WINDOW_CLOSING));
    this.welcomeFrame.setVisible(false);
    this.welcomeFrameStillOpen = false;
    }
}
