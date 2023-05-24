import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginPage extends  AccountGUI{

    JFrame frame = new JFrame("JDCK ATM");
    JFrame account = new JFrame("Type of Account");
    JLabel txt = new JLabel("Enter Pin");
    JPasswordField passwordField = new JPasswordField();
    JTextField text = new JTextField();
    JButton logBtn = new JButton("Login");
    JButton savingsBtn = new JButton("Savings");
    JButton CurrentBtn = new JButton("Current");
   // JLabel or = new JLabel("Or");


    public void mainUI(){
        frame.getContentPane().add(txt);
        txt.setHorizontalAlignment(SwingConstants.CENTER);
        txt.setVerticalAlignment(SwingConstants.CENTER);
        frame.add(text);
        frame.add(logBtn);
        frame.add(passwordField);
        frame.setSize(200,200);
        frame.setLayout(new GridLayout(4,1));
        frame.setVisible(true);
        logBtn.setBackground(Color.BLUE);
        logBtn.setFont(new Font("Arial", Font.BOLD, 16));
    }
    public void login(){
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                        String enteredPassword =  text.getText();
                        if (enteredPassword.equals("5555")) {
                            openAccountFrame();
                        } else if (enteredPassword.isBlank()) {
                            JOptionPane.showMessageDialog(null,"Please enter your pin");
                        } else if (enteredPassword=="") {
                            JOptionPane.showMessageDialog(null,"ERROR");

                        }else{
                            JOptionPane.showMessageDialog(null,"Wrong Password");
                        }

            }
                });
            }



    }
