import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AccountGUI {
    JFrame frame = new JFrame("withrawal / deposit");
    JFrame frame1 = new JFrame("Savings");
    JLabel dLabel = new JLabel("Deposit: ");
    JButton savingsBtn = new JButton("Savings");
    JButton currentBtn = new JButton("Current");
    JLabel typeOfAcc = new JLabel("Type of Account :");
    JButton withdrawBtn = new JButton("Withdraw");
    JTextField myText = new JTextField();
    JButton depositBtn = new JButton("Deposit");
    JButton calcDepositBtn = new JButton("Deposit");
    JFrame account = new JFrame("Type of Account");

    // TYPE OF ACCOUNT FRAME
    public void openAccountFrame() {
        account.add(savingsBtn);
        account.add(currentBtn);
        account.add(typeOfAcc);
        account.setSize(200, 200);
        account.setLayout(null);
        account.setMinimumSize(new Dimension(500, 700));//precized size of frame
        account.getContentPane().setBackground(new Color(0, 0, 139));
        account.setVisible(true);

        savingsBtn.setBounds(66,195, 250, 100);
        savingsBtn.setBackground(new Color(100, 200, 250));
        savingsBtn.setForeground(Color.black);
        savingsBtn.setFont(savingsBtn.getFont().deriveFont(Font.BOLD, 18));

        currentBtn.setBounds(66,345, 250, 100);
        currentBtn.setBackground(new Color(100, 200, 250));
        currentBtn.setForeground(Color.black);
        currentBtn.setFont(savingsBtn.getFont().deriveFont(Font.BOLD, 18));

        typeOfAcc.setBounds(66,90, 250, 100);
        typeOfAcc.setForeground(Color.WHITE);
        typeOfAcc.setFont(typeOfAcc.getFont().deriveFont(Font.BOLD, 25));

        depositBtn.setBounds(66, 345, 250, 100);
        depositBtn.setBackground(new Color(100, 200, 250));
        depositBtn.setForeground(Color.black);
        depositBtn.setFont(depositBtn.getFont().deriveFont(Font.BOLD, 18));

        withdrawBtn.setBounds(66, 195, 250, 100);
        withdrawBtn.setBackground(new Color(100, 200, 250));
        withdrawBtn.setForeground(Color.black);
        withdrawBtn.setFont(withdrawBtn.getFont().deriveFont(Font.BOLD, 18));

        savings();
    }
    public void savings() {
        savingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setLayout(null);
                frame.add(depositBtn);
                frame.add(withdrawBtn);
                frame.setSize(200, 200);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setMinimumSize(new Dimension(500, 700));//precised size of frame
                frame.getContentPane().setBackground(new Color(0, 0, 139));

                Savings myAcc = new Savings(100000);

                depositBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.getContentPane().add(dLabel);
                        frame1.add(myText);
                        frame1.add(calcDepositBtn);
                        frame1.setSize(350, 250);

                        dLabel.setBounds(100,100,120,150);
                        dLabel.setFont(dLabel.getFont().deriveFont(Font.BOLD, 20));
                        dLabel.setForeground(Color.WHITE);

                        myText.setBounds(100,200,150,40);

                        calcDepositBtn.setBounds(100,300,150,50);
                        calcDepositBtn.setBackground(new Color(100, 200, 250));
                        calcDepositBtn.setFont(calcDepositBtn.getFont().deriveFont(Font.BOLD, 15));

                        frame1.setMinimumSize(new Dimension(500, 700));//precised size of frame
                        frame1.setLayout(null);
                        frame1.setVisible(true);
                        frame1.getContentPane().setBackground(new Color(0, 0, 139));
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
                                    // Show success messag
                                    JOptionPane.showMessageDialog(null, "Amount deposited: " + amount+"\n"+"thank you for banking with us\n");
                                } catch (NumberFormatException exception) {
                                    JOptionPane.showMessageDialog(null, "Invalid input!");
                                }
                            }
                        });


                    }
                });


            }

        });


    }
}