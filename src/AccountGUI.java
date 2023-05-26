import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.lang.ProcessHandle.current;


public class AccountGUI {
    JFrame frame = new JFrame("Savings");
    JFrame frame1 = new JFrame("Savings");
    JLabel dLabel = new JLabel("Deposit: ");
    JButton savingsBtn = new JButton("Savings");
    JButton withdrawbtn = new JButton("Withdraw");
    JTextField myText = new JTextField();
    JButton depositBtn = new JButton("Deposit");
    JButton calcDepositBtn = new JButton("Deposit");

    JFrame account = new JFrame("Type of Account");

    JFrame frame2 = new JFrame("Current");
    JFrame frame3 = new JFrame("Current");
    JLabel dlabel = new JLabel("Deposit:");
    JButton CurrentBtn = new JButton("Current");
    JButton Withdrawbtn = new JButton("Withdraw");

    JButton calcwithdrawbtn = new JButton("Withdraw");
    JTextField myText1 = new JTextField();
    JButton DepositBtn = new JButton("Deposit");
    JButton CalcDepositBtn = new JButton("Deposit");
    JFrame account1 = new JFrame("Type of Account");


    // TYPE OF ACCOUNT FRAME
    public void openAccountFrame() {
        Savings savings = new Savings(100000);
        account.add(savingsBtn);
        account.add(CurrentBtn);
        account.setSize(200, 200);
       account.setLayout(new GridLayout(2, 1));
        account.setVisible(true);
        savings();
        Current();
    }


    public void savings() {;
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
                                        fileWriterMain.writeBalance(previousBalance, myAcc.getBalance(), "Deposit");
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

                    withdrawbtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame1.getContentPane().add(dLabel);
                            frame1.add(myText);
                            frame1.add(calcwithdrawbtn);
                            frame1.setSize(200, 200);
                            frame1.setLayout(new GridLayout(3, 1));
                            frame1.setVisible(true);

                            calcwithdrawbtn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    FileWriterMain fileWriterMain = new FileWriterMain();
                                    try{
                                        float amount = Float.parseFloat(myText.getText());

                                        // Store previous balance
                                        float previousBalance = myAcc.getBalance();

                                        // Perform deposit
                                        myAcc.withdraw(amount);

                                        fileWriterMain.writeBalance(previousBalance, myAcc.getBalance(), "Withdrawn");
                                        fileWriterMain.readFromFile();
                                        // Show success message
                                        JOptionPane.showMessageDialog(null, "Amount withdrawn: " + amount);
                                    }
                                    catch (NumberFormatException ioException ) {

                                        JOptionPane.showMessageDialog(null, "Invalid input!");
                                    };
                                }
                            });
                        }
                    });
                }

            });


        }


    public void Current() {
        CurrentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.add(depositBtn);
                frame2.add(withdrawbtn);
                frame2.setSize(200, 200);
                frame2.setLayout(new GridLayout(2, 1));
                frame2.setVisible(true);

                Current myAcc = new Current(100000);
                depositBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame3.getContentPane().add(dLabel);
                        frame3.add(myText);
                        frame3.add(calcDepositBtn);
                        frame3.setSize(200, 200);
                        frame3.setLayout(new GridLayout(3, 1));
                        frame3.setVisible(true);
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
                                    fileWriterMain.writeBalance(previousBalance, myAcc.getBalance(), "Deposit");
                                    fileWriterMain.readFromFile();
                                    // Show success message
                                    JOptionPane.showMessageDialog(null, "Amount deposited: " + amount);
                                } catch (NumberFormatException exception) {
                                    JOptionPane.showMessageDialog(null, "Invalid input!");
                                }
                            }
                        });
                withdrawbtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame3.getContentPane().add(dLabel);
                        frame3.add(myText);
                        frame3.add(calcwithdrawbtn);
                        frame3.setSize(200, 200);
                        frame3.setLayout(new GridLayout(3, 1));
                        frame3.setVisible(true);

                        calcwithdrawbtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                FileWriterMain fileWriterMain = new FileWriterMain();
                                try{
                                    float amount = Float.parseFloat(myText.getText());

                                    float previousBalance = myAcc.getBalance();

                                    myAcc.withdraw(amount);

                                    fileWriterMain.writeBalance(previousBalance, myAcc.getBalance(), "Withdraw");
                                    fileWriterMain.readFromFile();

                                }catch (NumberFormatException exception) {
                                    JOptionPane.showMessageDialog(null, "Invalid input!");

                                }


                            }
                        });


                    }
                });

                    }
                });


            }

        });

    }
}