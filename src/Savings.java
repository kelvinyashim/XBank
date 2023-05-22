

public class Savings extends Account {

     @Override
     public float withdraw(float amount) {
          return super.withdraw(amount);
     }

     public Savings(float initialBalance) {
          super(initialBalance);
     }

     @Override
     public float deposit(float amount) {
          return super.deposit(amount);
     }

     @Override
     public float getBalance() {
          return super.getBalance();
     }


     }

