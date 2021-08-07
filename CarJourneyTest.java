public class CarJourneyTest {
    public static void main(String[] args) {
        Car myCar1 = new Car();
        myCar1.startCar();
    }
}
/*what type of exceptions
to be handled "before journey" and "during journey"
                |                       |
              checked               unchecked
            KeyNotFoundException    RedSignalDishonouredInvoiceException
   DrivingLicenceNotFoundException  FlatTyreException
   InsurancePaperNotFoundException  SpeedLimitCrossedException

   15 to 20 mnts to solve this
*/
class KeyNotFoundException extends Exception {
    KeyNotFoundException(String str) {
        super(str);
    }
}
class DrivingLicenceNotFoundException extends Exception {
    DrivingLicenceNotFoundException(String str) {
        super(str);
    }
}
class InsurancePaperNotFoundException extends Exception {
    InsurancePaperNotFoundException(String str) {
        super(str);
    }
}
class  RedSignalDishonouredInvoiceException extends RuntimeException {
    RedSignalDishonouredInvoiceException(String str) {
        super(str);
    }
}
class FlatTyreException extends RuntimeException {
    FlatTyreException(String str) {
        super(str);
    }
}
class SpeedLimitCrossedException extends RuntimeException {
    SpeedLimitCrossedException(String str) {
        super(str);
    }
}
class RandomNumberGenerator
{
    public static int randomNumber(int Min, int Max)
    {
        return (int) (Math.random()*(Max-Min))+Min;
    }
}
class Car
{
    void startCar() {
        System.out.println("Starting the Engine...");
        shortJourney();
    }
    private void shortJourney()
    {
        System.out.println("Short Journey started...");
        for(int i=1;i<=5;i++) {

            int randomSpeed =RandomNumberGenerator.randomNumber(1,120);
            System.out.println("miles finished : current speed "+randomSpeed);
            if(randomSpeed > 80 ) {
                SpeedLimitCrossedException slce = new SpeedLimitCrossedException("Oh!! Speed limit exceeded 80mph : currentSpeed :  "+randomSpeed);
                throw slce;
            }
        }
        System.out.println("Short Journey finished...");
        stopCar();
    }
    void stopCar() {
        System.out.println("Stopping the Engine...");
    }
}
