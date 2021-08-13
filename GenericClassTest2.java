import java.util.ArrayList;
import java.util.Iterator;

public class GenericClassTest2 {

    public static void main(String[] args) {

        ArrayList<SavingsAccount> allAccountsList = new ArrayList<SavingsAccount>();

        SavingsAccount sa1 = new SavingsAccount(5000);
        SavingsAccount sa2 = new SavingsAccount(6000);
        SavingsAccount sa3 = new SavingsAccount(8000);
        SavingsAccount sa4 = new SavingsAccount(9000);
        SavingsAccount sa5 = new SavingsAccount(4000);
        SavingsAccount sa6 = new SavingsAccount(7000);

        allAccountsList.add(sa1);
       // allAccountsList.add("how come string is added");
        //allAccountsList.add('F'); //how come a letter now
        allAccountsList.add(sa2);
        allAccountsList.add(sa3);
        allAccountsList.add(sa4);
        allAccountsList.add(sa5);
        allAccountsList.add(sa6);

        Iterator iterator = allAccountsList.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            //if(obj instanceof SavingsAccount) {
                SavingsAccount ref = (SavingsAccount) obj;
                ref.deposit(10000); //add 100000 amount to each
                System.out.println("Savings Account : "+ref);
          //  }
        }

    }

}
class SavingsAccount {
    float balance;

    void deposit(float amt) {
        balance = balance + amt;
    }

    public SavingsAccount(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "balance=" + balance +
                '}';
    }
}
