import java.util.Calendar;
import java.util.TimeZone;

class Batsman {
    void hitSixer() {
        System.out.println("hiting sixer...");
    }
}
public class UncheckedExceptionTest {
    public static void main(String[] args) {
       Batsman b = new Batsman();
        b.hitSixer();
        b.hitSixer();

        System.out.println("started from home for shopping....");
        /*String allIds[] = TimeZone.getAvailableIDs();
        for (int i = 0; i < allIds.length; i++) {
            System.out.println("id : "+allIds[i]);
        }*/

        Marketing m = new Marketing();
        try {
            m.isMarketOpen();//is there any mandate to handle exception in try catch block?? YES
            m.purchaseOnion(); //is there any mandate to handle exception in try catch block??? NO
            m.purchaseTomatoes();//is there any mandate to handle exception in try catch block?? NO
            m.purchasePotatoes();//is there any mandate to handle exception in try catch block?? NO
        }
        catch(MarketClosedException e) {
            System.out.println("Problem1 : "+e.getMessage());
        } catch (MaskNotFoundException e) {
            System.out.println("Problem2 : "+e.getMessage());
        } catch (SocialDistanceNotMaintainedException e) {
            System.out.println("Problem3 : "+e.getMessage());
        } catch (NotVaccinatedException e) {
            System.out.println("Problem4 : "+e.getMessage());
        }


        System.out.println("Returned to home...");
    }
}
/*
    try     catch       finally

    throw               throws
    |                   |
 literally throw        ability of a function to throw a particular CHECKED exception
 */
class Marketing
{       //please verify or try at your machine
    final int MARKET_OPEN_TIME=9; // 11 AM -
    final int MARKET_CLOSE_TIME=14; // 2pm - due to lock down

    void isMarketOpen() throws MarketClosedException
    {
        TimeZone tz1 = TimeZone.getTimeZone("Australia/Sydney");
        //TimeZone tz1 = TimeZone.getTimeZone("America/New_York");
        Calendar cal1 = Calendar.getInstance(tz1); //ready made class
        //System.out.println("NY timing now : "+cal1.get(Calendar.HOUR_OF_DAY));
        int currentHour = cal1.get(Calendar.HOUR_OF_DAY);
        if(currentHour >= MARKET_OPEN_TIME && currentHour <=MARKET_CLOSE_TIME) {
            System.out.println("YES !!! MARKET IS OPEN");
        }
        else {
            MarketClosedException e = new MarketClosedException("NO!!! MARKET IS CLOSED...NOT YET OPEN");
            throw e;
        }
    }

    void purchaseTomatoes() throws MaskNotFoundException,NotVaccinatedException,SocialDistanceNotMaintainedException
    {
        int costOfTomatoes = 10;
        boolean maskWearing=false;
        boolean covidVaccinated=true;
        boolean isDistanceMaintained=true;

        if(maskWearing) {
            System.out.println("Tomatoes seller is welcoming....");
        } else
            throw new MaskNotFoundException("Tomatoes seller is complaining: Hey Where is your mask,...how come u are here without mask...");


        if(covidVaccinated) {
            System.out.println("Wow, You are vaccinated");
        }
        else {
            NotVaccinatedException n =new NotVaccinatedException("Hey not yet vaccinated..get it done asap");
            throw n;
        }

        if(isDistanceMaintained) {
            System.out.println("Nice, you are maintaining social distance....");
        } else {
            SocialDistanceNotMaintainedException s = new SocialDistanceNotMaintainedException("Please maintain social distance..");
            throw s;
        }

        if (costOfTomatoes < 50)
            System.out.println("Purchased tomatoes..");
        else {
            TomatoPurchaseException t = new TomatoPurchaseException("Tomatoes are litle expensive, not purchased");
            throw t; //terminating this purchase method and returning back to main
        }
    } //function is closed here
    void purchasePotatoes() {
        int costOfPotatoes = 20; //Lays wafers 25gm 50gm  100gm air tight container
        if (costOfPotatoes < 30)
            System.out.println("Purchased potatoes..");
        else {
            PotatoPurchaseException p = new PotatoPurchaseException("Potatoes are expensive, not purchase");
            throw p; //literally throwing an object to the invoker of the purchase method
        }
    }
    void purchaseOnion() {
        int costOfOnion = 10;
        if (costOfOnion < 40)
            System.out.println("Purchased onions..");
        else {
            //System.out.println("Onions not purchased...");
            OnionPurchaseException o = new OnionPurchaseException("Onions are expensive...not purchased..");
            throw o; //only children of Exception can be thrown, not every object is qualified to throw
        }
    }
}
class MarketClosedException extends Exception //CHECKED BY the COMPILER
{
    MarketClosedException(String str) {
        super(str);
    }
}
class MaskNotFoundException extends Exception
{
    MaskNotFoundException(String str) {
        super(str);
    }
}
class NotVaccinatedException extends Exception
{
    NotVaccinatedException(String str) {
        super(str);
    }
}
class SocialDistanceNotMaintainedException extends Exception
{
    SocialDistanceNotMaintainedException(String str) {
        super(str);
    }
}
class OnionPurchaseException extends RuntimeException //UNCHECKED BY THE COMPILER
{
    OnionPurchaseException(String msg) {
        super(msg); //hand over to the super class to store your msg
    }
}
//u r my java kids, todlers, youth, wise java expert / java adult
class TomatoPurchaseException  extends RuntimeException //UNCHECKED BY THE COMPILER
{
    TomatoPurchaseException (String msg) {
        super(msg); //hand over to the super class to store your msg
    }
}
class PotatoPurchaseException  extends RuntimeException //UNCHECKED BY THE COMPILER
{
    PotatoPurchaseException (String msg) {
        super(msg); //hand over to the super class to store your msg
    }
}
// java compiler(COMPILES)  and java interpreter(RUNS)
//    FOR A SHORTDRIVE (EACH DAY FOR OFFICE) JOURNEY -> WILL U CHECK THE STEPNEY
//FOR A LONG DRIVE?  WILL U CHECK THE STEPNEY BEFORE START THE CAR, OR DURING THE JOURNEY??