/*

for every primitive there is a wrapper class
            |                   |
            byte                Byte
            short               Short
            int                 Integer
            long                Long
            char                Character
            float               Float
            double              Double
            boolean             Boolean

            there are situations where only Object types
            are allowed and not the primitive

            in java there are ready made classes
            they might need Integer and not the int

 */
public class GenericClassTest {
    public static void main(String[] args) {
        MyPair<Integer> mip = new MyPair<Integer>(10,20);
        mip.showPair();
        mip.decoratePair();
        mip.swapPair();
        mip.showPair();
        System.out.println("-----------");

  //arraylist linkedlist, treeset and hashset are generic classes

        MyPair<Float> mfp = new MyPair<Float>(10.5f,20.8f);
        mfp.showPair();
        mfp.decoratePair();
        mfp.swapPair();
        mfp.showPair();
        System.out.println("-----------");

        MyPair<String> msp = new MyPair<String>("Robert","Julia");
        msp.showPair();
        msp.decoratePair();
        msp.swapPair();
        msp.showPair();

        System.out.println("-----------");

        MyPair<Double> mdp = new MyPair<Double>(55.77,88.99);
        mdp.showPair();
        mdp.decoratePair();
        mdp.swapPair();
        mdp.showPair();

        System.out.println("-----------");

        Song s1 = new Song("I want it that way","Millennium","Backstreet Boys",1995);
        Song s2 = new Song("My Heart Will Go On","Titanic","Celine D",1998);

        //a wine glass is only for wine, not for milk or water
        //a water glass is only for water, not for wine or milk
        //a milk glass is only for milk, not for wine or water


        //Plate is for the fried rice and not for milk
        //Glass is for the milk, not for the fried rice

        MyPair<Song> songPair = new MyPair<Song>(s1,s2);
        songPair.showPair();
        songPair.decoratePair();
        songPair.swapPair();
        songPair.showPair();
        System.out.println("-------------");

        MyPair<Character> emptyPair = new MyPair<Character>();
        emptyPair.showPair();
        emptyPair.setX('P'); //here it is a character
        emptyPair.setY('Q'); //but now a String,
        emptyPair.showPair();


    }
}
class Song {
    String title;
    String album;
    String artist;
    int year;

    public Song(String title, String album, String artist, int year) {
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                '}';
    }
}
//below class is a generic class now
// <T> is just a place holder replaced with the type you want

//below class is ready for ANY DATA TYPE !!!! THATS THE POWER OF GENERIC
class MyPair<AnyType> //purpose is to create a pair of two numbers
{
    AnyType x; //create an integer data pair here
    AnyType y;
    MyPair(AnyType a, AnyType b) { //constructor - set it
        x = a; y = b;
    }
    MyPair() {

    }
    void setX(AnyType at) {//basically its an java.lang.Object type
        x = at;
    }
    void setY(AnyType at) {
        y = at;
    }
    void showPair() { //show the pair
        System.out.println("x : "+x+" y : "+y);
    }
    void decoratePair() { //design it
        System.out.println("[ x ]  {"+x+"} [ y ]  {"+y+"}");
    }
    void swapPair() { //swap the pair
        AnyType temp = x;
        x = y;
        y = temp;
        System.out.println("swapped...my integer pair...");
    }
}
//cant there be ONE class doing all these activities???

//make the pair class for float ie 10.5  20.8
/*class MyFloatPair //purpose is to create a pair of two numbers
{
    float x; //create an integer data pair here
    float y;

    MyFloatPair(float a, float b) { //constructor - set it
        x = a; y = b;
    }
    void showMyFloatPair() { //show the pair
        System.out.println("x : "+x+" y : "+y);
    }
    void decorateMyFloatPair() { //design it
        System.out.println("[ x ]  {"+x+"} [ y ]  {"+y+"}");
    }
    void swapMyFloatPair() { //swap the pair
        float temp = x;
        x = y;
        y = temp;
        System.out.println("swapped...my float pair...");
    }
}

//make the pair class of String ie "Robert" "Julia"
class MyStringPair //purpose is to create a pair of two numbers
{
    String x; //create an integer data pair here
    String y;

    MyStringPair(String a, String b) { //constructor - set it
        x = a; y = b;
    }
    void showMyStringPair() { //show the pair
        System.out.println("x : "+x+" y : "+y);
    }
    void decorateStringPair() { //design it
        System.out.println("[ x ]  {"+x+"} [ y ]  {"+y+"}");
    }
    void swapStringPair() { //swap the pair
        String temp = x;
        x = y;
        y = temp;
        System.out.println("swapped...my String pair...");
    }
}

 */