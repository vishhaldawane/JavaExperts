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

        /*
                        1 <-- as a root -- always the first element as root
                        |
                   ------------
                 L  |        | R
                             5
                             |
                           -------
                           |      |
                           3<--- the depth of the tree is being increased with imbalance at right side
                                    ..left side is totally empty if u see there


                   dynamically a new tree is formed now to balance all the values
                   THIS IS BALANCED BINARY TREE CONCEPT

      1                     3
                            |
                     ---------------
                     |              |
       2             1              5
                     |               |
                  --------        ---------
                          |        |       |
       3    =>             2              8  <==

  

          */
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

class Powder {}
class CurryPowder extends Powder { }
class TalcumPowder extends Powder { }

class Curry {
    CurryPowder cp = new CurryPowder();
}
class VegCurry extends Curry { }
class FishCurry extends Curry { }
class ChickenCurry extends Curry { }

class ChemicalElement implements Comparable<ChemicalElement> //
{
    int atomicNumber;
    String elementName;
    String elementFormula;
    double atomicWeight;

    @Override
    public int compareTo(ChemicalElement o) { //this method is bound to be here as an assurance from Comparable interface
   //     System.out.println("\tComparing atomicNumber:"+atomicNumber+" with an atomicNumber...."+o.atomicNumber);
       // return Integer.compare(atomicNumber,o.atomicNumber);

   //     System.out.println("\tComparing atomicWeight:"+atomicWeight+" with an atomicWeight...."+o.atomicWeight);
   //     return Double.compare(atomicWeight,o.atomicWeight);
        System.out.println("\tComparing elementFormula:"+elementFormula+" with an elementFormula...."+o.elementFormula);
        return elementFormula.compareTo(o.elementFormula); //String class's compareTo()

        /*if(o.atomicNumber < atomicNumber) // element1's 5 < element1's 1
          return o.atomicNumber - atomicNumber; //  -4
        else if(o.atomicNumber > atomicNumber)  // 5 > 1
            return o.atomicNumber - atomicNumber; // 4
        else
            return 0;*/

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
