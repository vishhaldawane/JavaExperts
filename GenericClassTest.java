public class GenericClassTest {
    public static void main(String[] args) {
        MyIntegerPair mip = new MyIntegerPair(10,20);
        mip.showMyIntegerPair();
        mip.decorateMyIntegerPair();
        mip.swapMyIntegerPair();
        mip.showMyIntegerPair();
    }
}
class MyIntegerPair //purpose is to create a pair of two numbers
{
    int x;
    int y;

    MyIntegerPair(int a, int b) { //constructor
        x = a; y = b;
    }
    void showMyIntegerPair() { //show the pair
        System.out.println("x : "+x+" y : "+y);
    }
    void decorateMyIntegerPair() { //design it
        System.out.println("[ x ] + "+x+" [ y ] + "+y);
    }
    void swapMyIntegerPair() {
        int temp = x;
        x = y;
        y = temp;
        System.out.println("swapped...my integer pair...");
    }
}
