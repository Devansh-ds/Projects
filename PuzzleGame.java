import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PuzzleGame implements ActionListener {
    JFrame f;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, bnull;
    JButton[] blist;
    JButton left;
    JButton right;
    JButton top;
    JButton bottom;
    JButton[] correct;
    JButton nullat;

    PuzzleGame() {

        f = new JFrame("Puzzle Game");
        f.getContentPane().setBackground(Color.GRAY);
        f.setOpacity(1);
        f.setLayout(new GridLayout(3, 3));
        f.setSize(500, 500);
        
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        bnull = new JButton("");

        blist = new JButton[] {b1, b2, b3, b4, b5, b6, b7, b8, bnull};

        for (JButton button : blist) {
            button.setFocusable(false);
            button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3, true));
            button.addActionListener(this);
            button.setBackground(Color.BLACK);
            button.setForeground(Color.green);
            button.setFont(new Font(Font.SERIF, Font.BOLD, 50));
            f.add(button);
        }

        top = b6;
        left = b8;
        right = new JButton("null");
        bottom = new JButton("null");
        correct = new JButton[] {top, left, bottom, right};
        nullat = bnull;


        f.setVisible(true);

    }
    public static void main(String[] args) {
        new PuzzleGame();
    }

    public void actionPerformed(ActionEvent e) {
        
        JButton action = (JButton) e.getSource();
        ArrayList temp = new ArrayList();
        temp.add(left);
        temp.add(right);
        temp.add(left);
        temp.add(bottom);

        for (JButton but : temp) {

            if (action == but) {
                if (action == b8 && list.contains(nullat)) {
                    bnull.setText("8");
                    b8.setText("");
                    top = b5;
                    left = b7;
                    right = bnull;
                    bottom = new JButton("");
                }
                if (action == b6) {
                    bnull.setText("6");
                    b6.setText("");
                    top = b3;
                    left = b5;
                    bottom = b6;
                    right = new JButton("");
                }
                if (action == b3) {
                    b6.setText("3");
                    b3.setText("");
                    left = b2;
                    bottom = b6;
                    top = new JButton("");
                    right = new JButton(""); 
                }
                if (action == b5) {
                    b6.setText("5");
                    b5.setText("");
                    top = b2;
                    left = b4;
                    right = b6;
                    bottom = b8;
                }
                if (action == b2) {
                    b2.setText("");
                    b3.setText("2");
                    left = b1;
                    right = b3;
                    top = new JButton("");
                    bottom = b5;
                }
            }
        }


    }
}
