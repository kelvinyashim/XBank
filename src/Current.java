public class Current extends Accounts{
    public Current(float initialBalance) {
        super(initialBalance);
    }

    @Override
    public float withdraw(float amount) {return super.withdraw(amount);}


    @Override
    public float deposit(float amount) {return super.deposit(amount);}

    @Override
    public float getBalance() {return super.getBalance();}


}
