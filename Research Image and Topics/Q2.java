import javax.swing.*;
import java.awt.event.*;

public class Q2 extends JFrame implements ActionListener {
    JLabel l;
    JCheckBox cb1, cb2, cb3;
    JButton b;

    Q2() {
        // Initialize the JFrame and set properties
        setTitle("Food Order");
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create and add JLabel
        l = new JLabel("Food Order");
        l.setBounds(50, 50, 300, 20);
        add(l);

        // Create and add JCheckBoxes
        cb1 = new JCheckBox("Biscuits : 50");
        cb1.setBounds(100, 100, 150, 20);
        cb2 = new JCheckBox("Fruits : 30");
        cb2.setBounds(100, 150, 150, 20);
        cb3 = new JCheckBox("WATER : 10");
        cb3.setBounds(100, 200, 150, 20);
        add(cb1);
        add(cb2);
        add(cb3);

        // Create and add JButton
        b = new JButton("Order");
        b.setBounds(100, 250, 80, 30);
        b.addActionListener(this);
        add(b);
    }

    // ActionListener implementation for button click
    public void actionPerformed(ActionEvent e) {
        float amount = 0;
        float vat = 0;
        float tax = 0;
        float totalAmount = 0;
        String msg = "";

        // Check which checkboxes are selected and calculate subtotal
        if (cb1.isSelected()) {
            amount += 50;
            msg += "Biscuits : 50\n";
        }
        if (cb2.isSelected()) {
            amount += 30;
            msg += "Fruits : 30\n";
        }
        if (cb3.isSelected()) {
            amount += 10;
            msg += "WATER : 10\n";
        }

        // Calculate VAT (15% of subtotal)
        vat = (15 * amount) / 100;

        // Calculate tax (2% of subtotal)
        tax = (2 * amount) / 100;

        // Calculate total amount (subtotal + VAT + tax)
        totalAmount = amount + vat + tax;

        // Display order details in a dialog box
        msg += "-----------------\n";
        msg += "Subtotal: " + amount + "\n";
        msg += "VAT (15%): " + vat + "\n";
        msg += "Tax (2%): " + tax + "\n";
        msg += "-----------------\n";
        msg += "Total: " + totalAmount;

        JOptionPane.showMessageDialog(this, msg);
    }

    public static void main(String[] args) {
        // Create an instance of Q2 (the GUI) and display it
        SwingUtilities.invokeLater(() -> {
            new Q2();
        });
    }
}
