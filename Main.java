import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static String savedPassword = null;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Locker Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Enter Passcode:");
        userLabel.setBounds(10, 20, 120, 25);
        panel.add(userLabel);

        JPasswordField passcodeField = new JPasswordField(20);
        passcodeField.setBounds(140, 20, 200, 25);
        panel.add(passcodeField);

        JButton enterButton = new JButton("Enter");
        enterButton.setBounds(150, 60, 80, 25);
        panel.add(enterButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(10, 100, 350, 25);
        panel.add(messageLabel);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] enteredPasscode = passcodeField.getPassword();
                String enteredPasscodeStr = new String(enteredPasscode);

                if (savedPassword == null) {

                    savedPassword = enteredPasscodeStr;
                    messageLabel.setText("Password Set");
                } else {

                    if (enteredPasscodeStr.equals(savedPassword)) {
                        messageLabel.setText("Correct Password");
                    } else {
                        messageLabel.setText("Incorrect Password");
                    }
                }

                passcodeField.setText("");
            }
        });
    }
}
