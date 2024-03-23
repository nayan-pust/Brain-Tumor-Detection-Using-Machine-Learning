import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q4 extends JFrame implements ActionListener {
    protected Container c;
    protected Font f2 = new Font("Times New Roman", Font.ROMAN_BASELINE, 38);
    protected Font f1 = new Font("Times New Roman", Font.BOLD, 48);
    protected JButton btn[] = new JButton[19]; // Increase array length to 19
    protected JPanel pnl1, pnl2;
    protected JTextArea res;
    protected static int i, r, n1, n2;
    protected static String text = "";
    char op;
    boolean opf = false;

    Q4() {
        this.setBounds(20, 29, 526, 635);
        this.setTitle("Calculator");
        Rectangle rctngl = new Rectangle(280, 50, 850, 635);
        this.setMaximizedBounds(rctngl);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        // For Display
        pnl1 = new JPanel();
        pnl1.setLayout(new GridLayout());
        res = new JTextArea("");
        res.setFont(f1);
        pnl1.add(res);

        JScrollPane scroll = new JScrollPane(pnl1);
        scroll.setBounds(5, 10, 500, 90);
        c.add(scroll);

        // For Body
        pnl2 = new JPanel();
        pnl2.setBounds(5, 110, 500, 480);
        pnl2.setLayout(new GridLayout(5, 4));

        for (int i = 0; i <= 9; i++) {
            btn[i] = new JButton(i + "");
        }
        // --------First Row----------
        for (int i = 7; i <= 9; i++) {
            pnl2.add(btn[i]);
        }
        btn[13] = new JButton("/");
        pnl2.add(btn[13]); // division

        // ---------Second Row---------
        for (int i = 4; i <= 6; i++) {
            pnl2.add(btn[i]);
        }
        btn[12] = new JButton("x");
        pnl2.add(btn[12]); // Multiplication

        // ---------Third Row----------
        for (int i = 1; i <= 3; i++) {
            pnl2.add(btn[i]);
        }
        // Subtraction
        btn[11] = new JButton("-");
        pnl2.add(btn[11]);

        // ----------4th Row---------
        btn[15] = new JButton("AC");
        btn[15].setForeground(Color.YELLOW);
        pnl2.add(btn[15]); // AC
        pnl2.add(btn[0]); // zero
        btn[10] = new JButton("+");
        pnl2.add(btn[10]); // Addition
        btn[14] = new JButton("=");
        pnl2.add(btn[14]); // Result

        // ----------5th Row---------
        btn[16] = new JButton("%");
        pnl2.add(btn[16]); // Modulo
        btn[17] = new JButton("!");
        pnl2.add(btn[17]); // Factorial
        btn[18] = new JButton(".");
        pnl2.add(btn[18]); // Decimal point

        c.add(pnl2);
        for (int i = 0; i <= 18; i++) {
            btn[i].setFont(f2);
            btn[i].setBackground(Color.RED);
            btn[i].addActionListener(this);
        }

    }

    public void actionPerformed(ActionEvent e) {

        JButton pb = (JButton) e.getSource();
        if (pb == btn[15]) {
            r = n1 = n2 = 0;
            text = "";
            opf = false;
            res.setText("");
        } else if (pb == btn[14]) {
            n2 = Integer.parseInt(text);
            eval();
            res.append(" = " + r);
            text = "";
        } else if (pb == btn[16]) { // Modulo
            n1 = Integer.parseInt(text);
            op = '%';
            res.append(" % ");
            opf = true;
            text = "";
        } else if (pb == btn[17]) { // Factorial
            n1 = Integer.parseInt(text);
            evalFactorial();
            res.append("! = " + r);
            text = "";
        } else {
            for (int j = 10; j <= 13; j++) {
                if (pb == btn[j]) {
                    n1 = Integer.parseInt(res.getText());
                    if (pb == btn[10]) {
                        op = '+';
                        res.append(" + ");
                        opf = true;
                    }
                    if (pb == btn[11]) {
                        op = '-';
                        res.append(" - ");
                        opf = true;
                    }
                    if (pb == btn[12]) {
                        op = '*';
                        res.append(" x ");
                        opf = true;
                    }
                    if (pb == btn[13]) {
                        op = '/';
                        res.append(" / ");
                        opf = true;
                    }
                }
            }

            if (opf == false) {
                for (i = 0; i <= 9; i++) {
                    if (pb == btn[i]) {
                        String t = res.getText();
                        t += i;
                        res.setText(t);
                    }
                }
            } else {
                for (i = 0; i <= 9; i++) {
                    if (pb == btn[i]) {
                        text += i;
                        res.append(Integer.toString(i));
                    }
                }
            }
        }
    }

    int eval() {
        switch (op) {
            case '+':
                r = n1 + n2;
                break;
            case '-':
                r = n1 - n2;
                break;
            case '*':
                r = n1 * n2;
                break;
            case '/':
                r = n1 / n2;
                break;
            case '%':
                r = n1 % n2;
                break;
        }
        return 0;
    }

    int evalFactorial() {
        r = factorial(n1);
        return 0;
    }

    int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Q4 frm = new Q4();
        frm.setVisible(true);
    }
}
