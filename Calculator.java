import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Calculator implements ActionListener {

    JFrame f = new JFrame("Calculator");

    Float rone; 
    Float rtwo;
    JButton roper;

    boolean num = false;
    boolean oper = false;
    boolean spec = false;

    JLabel userlabel;
    JLabel anslabel;

    String[] digitButton = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] operator = {"+", "-", "*", "%", "", "sqrt", "=", "SQUARE", "1/x"};
    String[] special = {"AC", "DEL", ".", "CE", "BACK"};

    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bmod, bc, bce, bback, breciprocal, bsquare, broot, bdiv, bmul, bsub, badd, bdel, bdec, bans;
    JButton[] bholder; 
    JButton[] numholder;
    JButton[] operholder;

    Calculator() {

        f.setSize(414, 436);
        f.setLayout(null);
        // f.setResizable(false);

        userlabel = new JLabel();
        userlabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        userlabel.setForeground(Color.white);
        userlabel.setBackground(Color.black);
        userlabel.setOpaque(true);

        anslabel = new JLabel();
        anslabel.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        anslabel.setForeground(Color.white);
        anslabel.setBackground(Color.black);
        anslabel.setOpaque(true);

        JPanel displayPanel = new JPanel();
        displayPanel.setBounds(0, 0, 400, 100);
        displayPanel.setLayout(new GridLayout(2, 1));

        // JPanel panel1 = new JPanel();
        // panel1.setLayout(new FlowLayout());
        // panel1.setBounds(0, 0, 400, 50);
        // panel1.setBackground(Color.MAGENTA);

        // JPanel panel2 = new JPanel();
        // panel2.setLayout(new GridLayout(1, 1));
        // panel2.setBounds(0, 50, 400, 50);
        // panel2.setBackground(Color.pink);

        // panel2.add(areauser);

        // displayPanel.add(panel2);
        // displayPanel.add(panel1);

        displayPanel.add(anslabel);
        displayPanel.add(userlabel);


        f.add(displayPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 100, 400, 300);
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new GridLayout(6, 4));

        bmod = new JButton("%");
        bce = new JButton("CE");
        bc = new JButton("C");
        bback = new JButton("BACK");
        breciprocal = new JButton("1/x");
        bsquare = new JButton("SQUARE");
        broot = new JButton("sqrt");
        bdiv = new JButton("/");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b0 = new JButton("0");
        bmul = new JButton("*");
        bsub = new JButton("-");
        badd = new JButton ("+");
        bdel = new JButton("DEL");
        bdec = new JButton(".");
        bans = new JButton("=");

        bholder = new JButton[] {bmod, bc, bce, bback, breciprocal, bsquare, broot, bdiv, b7, b8, b9, bmul, b4, b5, b6, bsub, b1, b2, b3, badd, bdel, b0, bdec, bans};
        numholder = new JButton[] {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bdec};
        operholder = new JButton[] {bmod, badd, bsub, bmul, bdiv};

        for (JButton button : bholder) {
            button.setFocusable(false);
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
            button.addActionListener(this);
            buttonPanel.add(button);
        }




        f.add(buttonPanel);

        f.setVisible(true);
 // w : 280 h : 300
    }
    public static void main(String[] args) {
        new Calculator();
    }
    public void actionPerformed(ActionEvent e) {
        JButton action = (JButton) e.getSource();
        
        num = false;

        for (JButton but : numholder) {
            if (action == but) {
                num = true;
                userlabel.setText(userlabel.getText() + action.getText());
                break;
            }
        }

        for (JButton but : operholder) {
            if (action == but) {
                rone = Float.parseFloat(userlabel.getText());
                anslabel.setText(userlabel.getText() + action.getText());
                userlabel.setText("");
                roper = action;
                break;
            }
        }

        if (action == bans) {
            rtwo = Float.parseFloat(userlabel.getText());
            System.out.println();
            System.out.println("2nd : " + rtwo);
            System.out.println("one : " + rone);
            System.out.println(roper.getText());

            if (roper.getText() == "+") {
                rone = rone + rtwo;
            } else if (roper.getText() == "-") {
                rone = rone - rtwo;
            } else if (roper.getText() == "*") {
                rone = rone * rtwo;
            } else if (roper.getText() == "/") {
                rone = rone / rtwo;
            } else if (roper.getText() == "%") {
                rone = rone % rtwo;
            }
            anslabel.setText("");
            userlabel.setText("" + rone);
        }

        if (action == bce) {
            userlabel.setText("0");
            anslabel.setText("");
            roper = bce;
        }
        if (action == bdel) {
            userlabel.setText("");
        }
        if (action == broot) {
            Double temp = Double.parseDouble(userlabel.getText());
            userlabel.setText("" + Math.sqrt(temp));
        }
        if (action == bsquare) {
            Double temp = Double.parseDouble(userlabel.getText());
            userlabel.setText("" + Math.pow(temp, 2));
        }
        if (action == breciprocal) {
            try {
                Double temp = Double.parseDouble(userlabel.getText());
                temp = 1/temp;
                userlabel.setText("" + temp);
            } catch (Exception ex) {
                System.out.println("Cannot divided by 0");
            }
        }
        if (action == bc) {
            userlabel.setText("");
            anslabel.setText("");
        }
        if (action == bback) {
            String text = userlabel.getText();
            if (text.length() != 0) {
                String text2 = text.substring(0, text.length() - 1);
                userlabel.setText(text2);
            }
        }
    }
}