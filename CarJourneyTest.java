public class CarJourneyTest {
    public static void main(String[] args) {
        Car myCar1 = new Car("Skoda");
        Car myCar2 = new Car("Maruti");
        Car myCar3 = new Car("BMW");
        Car myCar4 = new Car("Merc");
        Car myCar5 = new Car("Honda");

        System.out.println("car1 "+myCar1);
        System.out.println("car2 "+myCar2);
        System.out.println("car3 "+myCar3);
        System.out.println("car4 "+myCar4);
        System.out.println("car5 "+myCar5);

        //observe below line, box bracket is not a constructor, means not an object at all
        Car myCars[] = new Car[5]; //just 5 Car references, not 5 Car objects yet

        //HEAD FIRST JAVA

        myCars[0] = new Car("Bugati"); //first car object assigned here
        myCars[1] = new Car("Lamborghini"); //and so on
        myCars[2] = new Car("Ferrari");
        myCars[3] = new Car("VolksVagen");
        myCars[4] = new Car("Toyota");
        for (int i = 0; i <myCars.length ; i++) {
            myCars[i].showCar();
        }


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
    String model;

    public Car(String model) {
        this.model = model;
    }
    void showCar() {
        System.out.println("Car Model : "+model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

    void startCar() {
        System.out.println("Starting the Engine...");
        try {
            shortJourney();
        }
        catch(SpeedLimitCrossedException e) {
            System.out.println("Speed Problem : "+e.getMessage());
        }
        catch(FlatTyreException e) {
            System.out.println("Tyre Problem : "+e.getMessage());
        }
    }
    private void shortJourney()
    {
        System.out.println("Short Journey started...");
        for(int i=1;i<=5;i++) {

            int randomSpeed = RandomNumberGenerator.randomNumber(1,120);
            System.out.println("miles finished : current speed "+randomSpeed);
            if(randomSpeed > 80 ) {
                SpeedLimitCrossedException slce = new SpeedLimitCrossedException("Oh!! Speed limit exceeded 80mph : currentSpeed :  "+randomSpeed);
                throw slce;
            }

            int flatTyrePressure = RandomNumberGenerator.randomNumber(1,35);
            if(flatTyrePressure < 15 ) {
                FlatTyreException fte = new FlatTyreException("Ohh!! i guess the tyre is flat....");
                throw fte;
            }
        }
        System.out.println("Short Journey finished...");
        stopCar();
    }
    void stopCar() {
        System.out.println("Stopping the Engine...");
    }
}
