import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        Dancer dancer1 = new Dancer("Folk",9,"Native");
        Dancer dancer2 = new Dancer("Katthak",10,"SouthIndian");
        Dancer dancer3 = new Dancer("Western",7,"American");
        Dancer dancer4 = new Dancer("Salsa",8,"Chinese");
        Dancer dancer5 = new Dancer("Disco",5,"Universal");

        List<Dancer> danceGroup = new ArrayList<Dancer>();
        danceGroup.add(dancer1);
        danceGroup.add(dancer2);
        danceGroup.add(dancer3);
        danceGroup.add(dancer4);
        danceGroup.add(dancer5);

        System.out.println("-- Before sort --");
        for (Dancer theDancer: danceGroup) {
            System.out.println("the dancer : "+theDancer);
        }

        System.out.println("-- Sorting --");

        Collections.sort(danceGroup); //by default Comparable

        System.out.println("-- After sort --");
        for (Dancer theDancer: danceGroup) {
            System.out.println("the dancer : "+theDancer);
        }

        System.out.println("-- Sorting based on Theme ---" );
        ThemeOfDanceComparator todc = new ThemeOfDanceComparator();
        Collections.sort(danceGroup,todc); //now with Comparator
        System.out.println("-- After Theme sort --");
        for (Dancer theDancer: danceGroup) {
            System.out.println("the dancer : "+theDancer);
        }
    }
}
/*

    Woman w1, w2, w3  w4  w5   w6 <-- if they gather in a party - dance competition
    Dancer [d1 d2 d3]    [d4 d5 d6 ]   [d7 d8 d9].......

           judge1   judge2  judge3
           |        |        |
           theme    energy  dresscode
    Comparator


 */





class ThemeOfDanceComparator implements Comparator<Dancer> {
    public int compare(Dancer o1, Dancer o2) {
        return o1.themeOfDance.compareTo(o2.themeOfDance);
    }
}
class DressCodeOfDanceComparator implements Comparator<Dancer> {
    public int compare(Dancer o1, Dancer o2) {
        return o1.dressCodeOfDance.compareTo(o2.dressCodeOfDance);
    }
}

class Dancer implements Comparable<Dancer>
{
    String themeOfDance;
    int energyOfDance;
    String dressCodeOfDance;

    public int compareTo(Dancer o) {
        System.out.println("Comparing energyOfDance "+energyOfDance+" with o.energyOfDance "+o.energyOfDance);
       return Integer.compare(energyOfDance,o.energyOfDance);
    }
    public Dancer(String themeOfDance, int energyOfDance, String dressCodeOfDance) {
        this.themeOfDance = themeOfDance;
        this.energyOfDance = energyOfDance;
        this.dressCodeOfDance = dressCodeOfDance;
    }

    @Override
    public String toString() {
        return "Dancer{" +
                "themeOfDance='" + themeOfDance + '\'' +
                ", energyOfDance='" + energyOfDance + '\'' +
                ", dressCodeOfDance='" + dressCodeOfDance + '\'' +
                '}';
    }


}
