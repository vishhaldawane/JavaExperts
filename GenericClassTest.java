public class GenericClassTest {
    public static void main(String[] args) {
        MyPair mip = new MyPair(10,20);
        mip.showPair();
        mip.decoratePair();
        mip.swapPair();
        mip.showPair();
        System.out.println("-----------");

        MyPair mfp = new MyPair(10.5f,20.8f);
        mfp.showPair();
        mfp.decoratePair();
        mfp.swapPair();
        mfp.showPair();
        System.out.println("-----------");

        MyPair msp = new MyPair("Robert","Julia");
        msp.showPair();
        msp.decoratePair();
        msp.swapPair();
        msp.showPair();

        System.out.println("-----------");

        MyPair mdp = new MyPair(55.77,88.99);
        mdp.showPair();
        mdp.decoratePair();
        mdp.swapPair();
        mdp.showPair();

        System.out.println("-----------");

        Song s1 = new Song("I want it that way","Millennium","Backstreet Boys",1995);
        Song s2 = new Song("My Heart Will Go On","Titanic","Celine D",1998);

        MyPair songPair = new MyPair(s1,s2);
        songPair.showPair();
        songPair.decoratePair();
        songPair.swapPair();
        songPair.showPair();
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
class MyPair<T> //purpose is to create a pair of two numbers
{
    T x; //create an integer data pair here
    T y;
    MyPair(T a, T b) { //constructor - set it
        x = a; y = b;
    }
    void showPair() { //show the pair
        System.out.println("x : "+x+" y : "+y);
    }
    void decoratePair() { //design it
        System.out.println("[ x ]  {"+x+"} [ y ]  {"+y+"}");
    }
    void swapPair() { //swap the pair
        T temp = x;
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