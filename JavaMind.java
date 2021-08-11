public class JavaMind {
    public static void main(String[] args) {
        Atm myAtm = new Atm(); //u can see the Atm in front of you
        AtmCard myAtmCard = new AtmCard("1234 1234 1234 1234","ICICI Bank","Sep 2029"); // u remove it from ur pocket
        AtmBill theBill = myAtm.swipeIt(myAtmCard, 5000); // send ur AtmCard's object here
        theBill.printTheBill();


       // AtmCard myAtmCrd = new AtmCard("1234 1234 1234 1234","ICICI Bank","Sep 2029");
      //  AtmBill myBill = new AtmBill("HDFC Bank ATM","11-Aug-2021");

    }
}
// OBSERVE THIS WHOLE WORLD AS ASSOCIATION OF OBJECTS
// WITH A RELATION OF ISA, HASA, USESA, PRODUCESA
//everything begins with a THOUGHT - LIGHTENING SPEED
//THOUGHTS - U WILL GET FROM THE BOOK, (AUTHOR'S MIND)
//FEEL IT - CHECK UR FEELINGS WITH AUTHOR'S FEELINGS
//ACTION - READ PROGRAMS/ WRITE PROGRAMS, LEARN FROM ERRORS
//RESULT - VICTORY

//simple java mind is ASSOCIATION principal
//isA  hasA  usesA  producesA
class Machine {

}
class Atm extends Machine { //isA

    //put it here at the data member location, not inside any function
    CardReader myCrdReader = new CardReader(); //hasA

    AtmBill swipeIt(AtmCard x,float amountToWithdraw) { //x is just the handle, not the object
        System.out.println("Atm swipeIt is called...got the card details : "+x.cardNumber);
        myCrdReader.scanIt(); //utilize the hasA's methods
        //Make an Object of AtmBill here to return from here
        AtmBill myAtmBill = new AtmBill("HDFC Bank ATM","11-Aug-2021",amountToWithdraw);
        return myAtmBill;
    }

}
class Reader {

}
class CardReader extends Reader { //isA
    void scanIt() { //belongs to the CardReader
        System.out.println("CardReader scanIt is called...");
    }
}

class Card {

}
class PanCard extends Card { } //isA
class VotingCard extends Card { } // isA

//if isA is a Lion - be friend with them
//then hasA is a Tiger - be friend with them

class AtmCard extends Card { //isA
    String cardNumber;
    String bankName;
    String expiry;

    public AtmCard(String cardNumber, String bankName, String expiry) {
        this.cardNumber = cardNumber;
        this.bankName = bankName;
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "AtmCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", expiry='" + expiry + '\'' +
                '}';
    }
}

class Bill
{

}
class HotelBill extends Bill { }
class FoodBill extends Bill { }
class AtmBill extends Bill {  //isA
    String atmBankName;
    String dateOfTransaction;
    float amountWithdrawn;

    public AtmBill(String atmBankName, String dateOfTransaction, float amountWithdrawn) {
        this.atmBankName = atmBankName;
        this.dateOfTransaction = dateOfTransaction;
        this.amountWithdrawn = amountWithdrawn;
    }

    void printTheBill() {
        System.out.println("===================");
        System.out.println(atmBankName);
        System.out.println("===================");
        System.out.println("Withdrawn : "+amountWithdrawn);
        System.out.println("Tnx Date  : "+dateOfTransaction);
        System.out.println("===================");
    }
}