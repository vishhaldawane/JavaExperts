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
*/
class Car
{
    void startCar() {
        System.out.println("Starting the Engine...");
        shortJourney();
    }
    private void shortJourney() {
        System.out.println("Short Journey started...");
        for(int i=1;i<=5;i++) {
            System.out.println("miles finished "+i);
        }
        System.out.println("Short Journey finished...");
        stopCar();
    }
    void stopCar() {
        System.out.println("Stopping the Engine...");
    }
}
