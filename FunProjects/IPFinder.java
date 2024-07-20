import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class IPFinder implements ActionListener {
    JFrame frame;
    JButton findButton;
    JLabel label;
    JTextField tf;

    IPFinder() {

        frame = new JFrame("IP Finder");
        frame.setSize(500, 500);
        frame.setLayout(null);

        tf = new JTextField();
        tf.setBounds(100, 100, 300, 50);

        label = new JLabel("IP address : ?");
        label.setBounds(100, 200, 280, 50);

        findButton = new JButton("Find IP");
        findButton.setBounds(200, 280, 80, 40);
        findButton.setFocusable(true);
        findButton.addActionListener(this);

        frame.add(tf); frame.add(label); frame.add(findButton);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new IPFinder();
    }
    public void actionPerformed(ActionEvent e) {
        String url = tf.getText();
        try {
            InetAddress ia = InetAddress.getByName(url);
            String ip = ia.getHostAddress();
            label.setText("IP Address : " + ip);
        } catch (Exception ex) {
            label.setText("Incorrect url");
        }
    }
}