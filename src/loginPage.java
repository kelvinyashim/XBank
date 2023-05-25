import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
//import java.util.Scanner;

public class loginPage extends AccountGUI {
    JFrame frame = new JFrame("JDCK ATM");
    JLabel label_pin = new JLabel("Account");
    JLabel welcomeLabel = new JLabel();
    JLabel pin = new JLabel("Pin ");
    JLabel name = new JLabel("Name");

    JPasswordField passwordField = new JPasswordField();
    JTextField nameField = new JTextField("enter your name");
    JButton logBtn = new JButton("Login");


    public void mainUI() {
        frame.getContentPane().setLayout(null); // Set layout to null for absolute positioning

        label_pin.setHorizontalAlignment(SwingConstants.CENTER);
        label_pin.setVerticalAlignment(SwingConstants.CENTER);
        label_pin.setBounds(40, 100, 450, 30);
        label_pin.setForeground(Color.WHITE);
        label_pin.setFont(label_pin.getFont().deriveFont(Font.BOLD, 40));




        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(30, 400, 450, 30);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(label_pin.getFont().deriveFont(Font.BOLD, 20));

        passwordField.setBounds(50, 200, 400, 30); // Set position and size of the password field
        nameField.setBounds(50, 150, 400, 30); // Set position and size of the name field


        logBtn.setBounds(180, 300, 100, 30);
        logBtn.setBackground(new Color(100, 200, 250));
        logBtn.setForeground(Color.black);
        logBtn.setSize(150,50);// set size of button
        logBtn.setFont(logBtn.getFont().deriveFont(Font.BOLD, 15));


        pin.setBounds(15, 195, 100, 30);
        pin.setForeground(new Color(250, 250, 250));
        pin.setSize(40,40);// set size of button
        pin.setFont(pin.getFont().deriveFont(Font.BOLD,15));

        name.setBounds(5, 145, 100, 30);
        name.setForeground(new Color(250, 250, 250));
        name.setSize(40,40);// set size of button
        name.setFont(name.getFont().deriveFont(Font.BOLD,15));

        frame.getContentPane().setBackground(new Color(0, 0, 139));
        frame.getContentPane().add(label_pin);
        frame.getContentPane().add(passwordField);
        frame.getContentPane().add(logBtn);
        frame.getContentPane().add(pin);
        frame.getContentPane().add(name);



        frame.getContentPane().add(nameField);
        frame.getContentPane().add(welcomeLabel);
        frame.setMinimumSize(new Dimension(500, 700));//precised size of frame

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void login() {
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                char[] enteredPassword = passwordField.getPassword();//the code retrieves the password characters entered in the
                // JPasswordField, stores them in a char array for security reasons,
                String password = new String(enteredPassword);
                String name = nameField.getText();

                if (password.equals("5555")) {
                    openAccountFrame();
                    if (!name.isBlank()) {
                        welcomeLabel.setText("Welcome to JDCK Bank, " + name + "!");
                    } else {
                        welcomeLabel.setText(""); // Clear the label if no name is entered
                    }
                } else if (password.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Please enter your pin");
                } else if (password.equals("")) {
                    JOptionPane.showMessageDialog(null, "ERROR");
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Password");
                }
            }

        });
    }
}

