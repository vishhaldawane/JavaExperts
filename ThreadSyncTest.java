public class ThreadSyncTest {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(101,"Bishnu",40000);
        System.out.println("sa : "+sa);

        Teller teller1 = new Teller("Reeta",sa,10000);
        Teller teller2 = new Teller("Seeta",sa,20000);
        Teller teller3 = new Teller("Geeta",sa,30000);

        teller1.depositCash();
        teller2.depositCash();
        teller3.depositCash();

        System.out.println("sa : "+sa);
    }
}
class Teller {
    SavingsAccount ref; //hasA - current value is null
    double amountToDeposit; //hasA  - current value is zero
    String tellerName;

    Teller(String tn, SavingsAccount x, double y) { //but the ctor will set it
        tellerName = tn;
        ref = x;
        amountToDeposit = y;
    }
    public void depositCash() {
        ref.deposit(tellerName,amountToDeposit);
    }
}
class SavingsAccount {
    int accountNumber;
    String accountHolder;
    double accountBalance;

    public SavingsAccount(int accountNumber, String accountHolder, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolder='" + accountHolder + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                '}';
    }
    public void deposit(String tellerName, double amountToDeposit) {
        System.out.println(tellerName+" Depositing : "+amountToDeposit);
        accountBalance = accountBalance + amountToDeposit;
    }

}
