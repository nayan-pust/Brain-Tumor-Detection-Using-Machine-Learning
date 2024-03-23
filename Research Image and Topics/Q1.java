import javax.swing.*;
import java.awt.*;

public class Q1 extends JFrame {
    public Q1() {
        setTitle("Image Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Create ImageIcons for each image
        ImageIcon imageIcon1 = new ImageIcon("java.png"); // Replace "image1.jpg" with the path to your first image file
        ImageIcon imageIcon2 = new ImageIcon("cpp.jpg"); // Replace "image2.jpg" with the path to your second image file
        ImageIcon imageIcon3 = new ImageIcon("c.jpg"); // Replace "image3.jpg" with the path to your third image file

        // Create JLabels to hold the images
        JLabel imageLabel1 = new JLabel(imageIcon1);
        JLabel imageLabel2 = new JLabel(imageIcon2);
        JLabel imageLabel3 = new JLabel(imageIcon3);

        // Add the JLabels to the JFrame
        getContentPane().setLayout(new GridLayout(1, 3)); // Set layout to 1 row and 3 columns
        getContentPane().add(imageLabel1);
        getContentPane().add(imageLabel2);
        getContentPane().add(imageLabel3);

        pack(); // Adjusts the JFrame size to fit the images
        setLocationRelativeTo(null); // Centers the JFrame on the screen
    }

    public static void main(String[] args) {
        // Create an instance of Q1 and make it visible
        SwingUtilities.invokeLater(() -> {
            new Q1().setVisible(true);
        });
    }
}
