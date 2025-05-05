/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class SplashScreen {

    JFrame MyFrame;
    private JWindow window;

    public SplashScreen() {
        // Initialize the window
        window = new JWindow();
       
        window.setBackground(new Color(0, 0, 0, 0));
        ImageIcon splashIcon = new ImageIcon(getClass().getResource("/com/mycompany/myproject/logo1.png"));



        // Create a JLabel with the image
        JLabel splashLabel = new JLabel(splashIcon);
        
        // Add the label to the window
        window.getContentPane().setBackground(new Color(0, 0, 0, 0));
        window.getContentPane().add(splashLabel);

        // Set the window size to match the GIF dimensions
        window.setSize(splashIcon.getIconWidth(), splashIcon.getIconHeight());
//    window.setSize(200,200);

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - window.getWidth()) / 2;
        int y = (screenSize.height - window.getHeight()) / 2;
        window.setLocation(x, y);

        // Make the window visible
        window.setVisible(true);

        // Close the splash screen after 5 seconds and open the main frame
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                window.dispose(); // Close the splash screen
                // new MyFrame().setVisible(true); // Open the main frame
            }
        }, 5000); // 5000 milliseconds = 5 seconds
    }

    public static void main(String[] args) {
        // Run the splash screen in the event-dispatching thread

        SwingUtilities.invokeLater(SplashScreen::new);
    }
}
