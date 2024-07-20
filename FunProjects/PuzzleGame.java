import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PuzzleGame implements ActionListener {
    JFrame f;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
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
        
        b1 = new JButton("4");
        b2 = new JButton("6");
        b3 = new JButton("5");
        b4 = new JButton("");
        b5 = new JButton("3");
        b6 = new JButton("7");
        b7 = new JButton("1");
        b8 = new JButton("2");
        b9 = new JButton("8");

        blist = new JButton[] {b1, b2, b3, b4, b5, b6, b7, b8, b9};

        for (JButton button : blist) {
            button.setFocusable(false);
            button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3, true));
            button.addActionListener(this);
            button.setBackground(Color.BLACK);
            button.setForeground(Color.green);
            button.setFont(new Font(Font.SERIF, Font.BOLD, 50));
            f.add(button);
        }

        f.setVisible(true);

    }
    public static void main(String[] args) {
        new PuzzleGame();
    }

    public void actionPerformed(ActionEvent e) {
        
        JButton action = (JButton) e.getSource();
        
        if (action == b8) {
            if (b9.getText().equals("")) {
                b9.setText(b8.getText());
                b8.setText("");
            } else if (b5.getText().equals("")) {
                b5.setText(b8.getText());
                b8.setText("");
            } else if (b7.getText().equals("")) {
                b7.setText(b8.getText());
                b8.setText("");
            }
        } else if (action == b9) {
            if (b8.getText().equals("")) {
                b8.setText(b9.getText());
                b9.setText("");
            } else if (b6.getText().equals("")) {
                b6.setText(b9.getText());
                b9.setText("");
            }
        } else if (action == b6) {
            if (b3.getText().equals("")) {
                b3.setText(b6.getText());
                b6.setText("");
            } else if (b5.getText().equals("")) {
                b5.setText(b6.getText());
                b6.setText("");
            } else if (b9.getText().equals("")) {
                b9.setText(b6.getText());
                b6.setText("");
            }
        } else if (action == b3) {
            if (b2.getText().equals("")) {
                b2.setText(b3.getText());
                b3.setText("");
            } else if (b6.getText().equals("")) {
                b6.setText(b3.getText());
                b3.setText("");
            }
        } else if (action == b2) {
            if (b3.getText().equals("")) {
                b3.setText(b2.getText());
                b2.setText("");
            } else if (b5.getText().equals("")) {
                b5.setText(b2.getText());
                b2.setText("");
            } else if (b1.getText().equals("")) {
                b1.setText(b2.getText());
                b2.setText("");
            } 
        } else if (action == b1) {
            if (b2.getText().equals("")) {
                b2.setText(b1.getText());
                b1.setText("");
            } else if (b4.getText().equals("")) {
                b4.setText(b1.getText());
                b1.setText("");
            }
        } else if (action == b4) {
            if (b1.getText().equals("")) {
                b1.setText(b4.getText());
                b4.setText("");
            } else if (b5.getText().equals("")) {
                b5.setText(b4.getText());
                b4.setText("");
            } else if (b7.getText().equals("")) {
                b7.setText(b4.getText());
                b4.setText("");
            }
        } else if (action == b7) {
            if (b4.getText().equals("")) {
                b4.setText(b7.getText());
                b7.setText("");
            } else if (b8.getText().equals("")) {
                b8.setText(b7.getText());
                b7.setText("");
            }
        } else if (action == b5) {
            if (b2.getText().equals("")) {
                b2.setText(b5.getText());
                b5.setText("");
            } else if (b4.getText().equals("")) {
                b4.setText(b5.getText());
                b5.setText("");
            } else if (b8.getText().equals("")) {
                b8.setText(b5.getText());
                b5.setText("");
            } else if (b6.getText().equals("")) {
                b6.setText(b5.getText());
                b5.setText("");
            }
        }
        
        if (b1.getText().equals("1") && b2.getText().equals("2")
        && b3.getText().equals("3") && b4.getText().equals("4") 
        && b5.getText().equals("5") && b6.getText().equals("6") 
        && b7.getText().equals("7") && b8.getText().equals("8")) {
            JOptionPane.showMessageDialog(f, "Congratulaions you won!!");
        }

    }
}
