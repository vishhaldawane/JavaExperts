import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest2 {
    public static void main(String[] args) {

        ChemicalElement element1 = new ChemicalElement(1,"Hydrogen","H",1.008);
        ChemicalElement element2 = new ChemicalElement(5,"Boron","B",10.81);
        ChemicalElement element3 = new ChemicalElement(3,"Lithium","Li",6.94);
        ChemicalElement element4 = new ChemicalElement(8,"Oxygen","O",15.999);
        ChemicalElement element5 = new ChemicalElement(2,"Helium","He",4.0026);
        System.out.println("All the elements are ready....");

        TreeSet<ChemicalElement> periodicTable = new TreeSet<ChemicalElement>();
        System.out.println("TreeSet adding the 1 element");
        periodicTable.add(element1); //now the good point is, the add will call
                    // the compareTo method to compare two elements...

        System.out.println("TreeSet adding the 2 element");
        periodicTable.add(element2);

        System.out.println("TreeSet adding the 3 element");
        periodicTable.add(element3);

        System.out.println("TreeSet adding the 4 element");
        periodicTable.add(element4);

        System.out.println("TreeSet adding the 5 element");
        periodicTable.add(element5);

        Iterator<ChemicalElement> myIterator = periodicTable.iterator(); // ITERATOR,  STRAW

        while (myIterator.hasNext()) {
            ChemicalElement  element = myIterator.next();
            System.out.println("element "+element);
            }
        }
}


class ChemicalElement implements Comparable<ChemicalElement> //
{
    int atomicNumber;
    String elementName;
    String elementFormula;
    double atomicWeight;

    @Override
    public int compareTo(ChemicalElement o) {
        System.out.println("Comparing "+atomicNumber+" with an element...."+o.atomicNumber);
        if(atomicNumber < o.atomicNumber) // 1 < 5
          return atomicNumber - o.atomicNumber; //  -4
        else if(atomicNumber > o.atomicNumber)  // 5 > 1
            return atomicNumber - o.atomicNumber; // 4
        else
            return 0;
    }

    public ChemicalElement(int atomicNumber, String elementName, String elementFormula, double atomicWeight) {
        this.atomicNumber = atomicNumber;
        this.elementName = elementName;
        this.elementFormula = elementFormula;
        this.atomicWeight = atomicWeight;
    }

    @Override
    public String toString() {
        return "ChemicalElements{" +
                "atomicNumber=" + atomicNumber +
                ", elementName='" + elementName + '\'' +
                ", elementFormula='" + elementFormula + '\'' +
                ", atomicWeight=" + atomicWeight +
                '}';
    }


}
