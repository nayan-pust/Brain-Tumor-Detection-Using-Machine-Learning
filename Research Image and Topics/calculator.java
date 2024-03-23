import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame implements ActionListener {
    private Container container;
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, modButton, factButton, clrButton, eqlButton;
    private Font font;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public calculator() {
        setTitle("Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        container = getContentPane();
        container.setLayout(new BorderLayout());

        font = new Font("Arial", Font.BOLD, 25);

        textField = new JTextField();
        textField.setFont(font);
        textField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(this);
        }

        functionButtons = new JButton[8];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        factButton = new JButton("!");
        clrButton = new JButton("C");
        eqlButton = new JButton("=");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = modButton;
        functionButtons[5] = factButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = eqlButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].setFont(font);
            functionButtons[i].addActionListener(this);
        }

        JPanel panelTextField = new JPanel(new GridLayout(1, 1));
        panelTextField.add(textField);

        JPanel panelButtons = new JPanel(new GridLayout(4, 4));
        panelButtons.add(numberButtons[1]);
        panelButtons.add(numberButtons[2]);
        panelButtons.add(numberButtons[3]);
        panelButtons.add(addButton);

        panelButtons.add(numberButtons[4]);
        panelButtons.add(numberButtons[5]);
        panelButtons.add(numberButtons[6]);
        panelButtons.add(subButton);

        panelButtons.add(numberButtons[7]);
        panelButtons.add(numberButtons[8]);
        panelButtons.add(numberButtons[9]);
        panelButtons.add(mulButton);

        panelButtons.add(numberButtons[0]);
        panelButtons.add(clrButton);
        panelButtons.add(eqlButton);
        panelButtons.add(divButton);

        JPanel panelExtraButtons = new JPanel(new GridLayout(1, 3));
        panelExtraButtons.add(modButton);
        panelExtraButtons.add(factButton);

        container.add(panelTextField, BorderLayout.NORTH);
        container.add(panelButtons, BorderLayout.CENTER);
        container.add(panelExtraButtons, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (buttonClicked == clrButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        } else if (buttonClicked == eqlButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        } else if (buttonClicked == factButton) {
            num1 = Double.parseDouble(textField.getText());
            int factorialResult = factorial((int) num1);
            textField.setText(String.valueOf(factorialResult));
        } else {
            for (int i = 0; i < 10; i++) {
                if (buttonClicked == numberButtons[i]) {
                    textField.setText(textField.getText() + i);
                }
            }
            if (buttonClicked == addButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if (buttonClicked == subButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if (buttonClicked == mulButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if (buttonClicked == divButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            if (buttonClicked == modButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '%';
                textField.setText("");
            }
        }
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
       calculator calc = new calculator();
        calc.setVisible(true);
    }
}
