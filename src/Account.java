import javax.swing.*;

public class Account {
    private float balance;

    public Account(float initialBalance){
        this.balance = initialBalance;
    }
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float withdraw(float amount) {
        if (balance > amount) {
            amount -= balance;

        } else if (amount>20000) {
            JOptionPane.showMessageDialog(null,"Max Limit is 20k");

        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds");
        }
        return amount;
    }

    public float deposit(float amount){
        balance+=amount;
        return amount;
    }
}
