import javax.swing.*;
public class Accounts {

    private float balance;

    public Accounts(float initialBalance) {this.balance = initialBalance; }

    public float getBalance() {
        return balance;
    }

    public void setBalance (float balance) {this.balance = balance;}

    public float withdraw(float amount) {
        if (balance > amount) {
            amount -= balance;

        }
        return amount;
    }
    public float deposit (float amount){
        balance+=amount;
        return amount;
    }

}
