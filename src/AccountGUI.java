import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AccountGUI {
    JFrame frame = new JFrame("Savings");
    JFrame frame1 = new JFrame("Savings");
    JLabel dLabel = new JLabel("Deposit: ");
    JButton savingsBtn = new JButton("Savings");
    JButton withdrawbtn = new JButton("Withdraw");
    JTextField myText = new JTextField();
    JButton depositBtn = new JButton("Deposit");
    JButton calcDepositBtn = new JButton("Deposit");

    JButton calcwithdrawBtn = new JButton("Withdraw");

    JFrame account = new JFrame("Type of Account");

    // TYPE OF ACCOUNT FRAME
    public void openAccountFrame() {
        Savings savings = new Savings(100000);
        account.add(savingsBtn);
        account.setSize(200, 200);
        account.setLayout(new GridLayout(2, 1));
        account.setVisible(true);
        savings();
    }
    public void savings() {
        savingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(depositBtn);
                frame.add(withdrawbtn);
                frame.setSize(200, 200);
                frame.setLayout(new GridLayout(2, 1));
                frame.setVisible(true);

                Savings myAcc = new Savings(100000);

                depositBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.getContentPane().add(dLabel);
                        frame1.add(myText);
                        frame1.add(calcDepositBtn);
                        frame1.setSize(200, 200);
                        frame1.setLayout(new GridLayout(3, 1));
                        frame1.setVisible(true);
                        calcDepositBtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Perform deposit
                                FileWriterMain fileWriterMain = new FileWriterMain();
                                try {
                                    float amount = Float.parseFloat(myText.getText());

                                    // Store previous balance
                                    float previousBalance = myAcc.getBalance();

                                    // Perform deposit
                                    myAcc.deposit(amount);

                                    // Write previous and current balance to file
                                    fileWriterMain.writeBalance(previousBalance, myAcc.getBalance(),"Deposit");
                                    fileWriterMain.readFromFile();
                                    // Show success message
                                    JOptionPane.showMessageDialog(null, "Amount deposited: " + amount);
                                } catch (NumberFormatException exception) {
                                    JOptionPane.showMessageDialog(null, "Invalid input!");
                                }
                            }
                        });


                    }
                });


            }

        });
        savingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(depositBtn);
                frame.add(withdrawbtn);
                frame.setSize(200, 200);
                frame.setLayout(new GridLayout(2, 1));
                frame.setVisible(true);

                Savings myAcc = new Savings(100000);



                withdrawbtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.getContentPane().add(dLabel);
                        frame1.add(myText);
                        frame1.add(calcwithdrawBtn);
                        frame1.setSize(200, 200);
                        frame1.setLayout(new GridLayout(3, 1));
                        frame1.setVisible(true);


                calcwithdrawBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Perform withdraw
                        FileWriterMain fileWriterMain = new FileWriterMain();
                        try {
                            float amount = Float.parseFloat(myText.getText());

                            // Store previous balance
                            float previousBalance = myAcc.getBalance();

                            // Perform withdraw
                            myAcc.deposit(amount);

                            // Write previous and current balance to file
                            fileWriterMain.writeBalance(previousBalance, myAcc.getBalance(),"Deposit");
                            fileWriterMain.readFromFile();
                            // Show success message
                            JOptionPane.showMessageDialog(null, "Amount deposited: " + amount);
                        } catch (NumberFormatException exception) {
                            JOptionPane.showMessageDialog(null, "Invalid input!");
                        }
                    }
                });


    }
});
    }});}}