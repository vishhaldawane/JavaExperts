import jdk.swing.interop.SwingInterOpUtils;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {
    public static void main(String[] args) {

        Country c1  = new Country("India", "New Delhi", "Rupee", "1.29B", "Mr. Narendra Modi");
        Country c2  = new Country("England", "London", "Pound", "6.8Cr", "Mr. Boris Johnson");
        Country c3  = new Country("Australia", "Canberra", "Aus Dollar", "25.88m", "Mr. Scott Morison");
        Country c4  = new Country("Nepal", "Kathmandu", "Rupee", "2.86Cr", "Mr. Sher Bahadur Deauba");

        TreeMap<String, Country> countryMap = new TreeMap<String, Country>();
        countryMap.put("IND",c1);
        countryMap.put("UK",c2);
        countryMap.put("AUS",c3);
        countryMap.put("NEP",c4);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the KEY : ");
        String countryKey = scan.nextLine();
        countryKey = countryKey.toUpperCase();

        if(countryMap.containsKey(countryKey)) { //if key found
            Country foundCountry = countryMap.get(countryKey); //only then get it
            System.out.println("The Country : "+foundCountry);
        }
        else {
            System.out.println("Key not found");
        }
        System.out.println("--------lets show all the countries -------");
        System.out.println("---- You have to find all the Keys...ie the set of the Keys----");

        Set<String> keySet = countryMap.keySet(); // do we maintain keySet in our real life?

        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
            String theKey = keyIterator.next();
            System.out.println("The key : "+theKey);
            Country theCountry = countryMap.get(theKey);
            System.out.println("The Country : "+theCountry);
        }

    }
}
class Country {
    String countryName;
    String countryPrimeMinister;
    String countryCapital;
    String countryPopulation;
    String countryCurrency;

    public Country(String countryName,String countryCapital, String countryCurrency,String countryPopulation,String countryPrimeMinister) {
        this.countryName = countryName;
        this.countryPrimeMinister = countryPrimeMinister;
        this.countryCapital = countryCapital;
        this.countryPopulation = countryPopulation;
        this.countryCurrency = countryCurrency;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryPrimeMinister='" + countryPrimeMinister + '\'' +
                ", countryCapital='" + countryCapital + '\'' +
                ", countryPopulation='" + countryPopulation + '\'' +
                ", countryCurrency='" + countryCurrency + '\'' +
                '}';
    }
}
/*


            Collection             Map
            |                      |
      -------------             -----------
      |         |                |          |
      List      Set   <-----  TreeMap     HashMap
      |           |
  --------      ----------
  |       |     |       |
  AL      LL    TS      HS
Questions
------------
    1. What is List?
        is a collection to hold duplicate values

    2. So what is ArrayList?
        consecutive memory location of the elements
        faster search access - efficient
        but not flexible to insert or remove elements from within
        efficient to append data at the end of it
        linear structure

    3. What is LinkedList?
        linear structure
        every node is NOT connected with each other in consecutive memory
        Rather all nodes are randomly stored anywhere, but
        each node has the memory address of its next as well as the
        previous node
        inefficient for search, but very flexible to insert update or
        delete elements from within

    4. What is Set?
        non - linear structure
        does not allow duplicates, all elements must be unique

    5   What is  TreeSet?
            a tree like set, where each node is stored with its left
            child node and the right child node.
                        Root
                          | 60
                     -------------
                     |<          |>
                     | 40        |75
                  left child    right child

            automatically sorted based on the java.lang.Comparable's
            compareTo() method decision


     6. What is HashSet

            a book shelf like data structure

            where each element is added based on its
            equals() and hashCode() method decision

            a unique identifier is the discriminator
            to hold the unique values

      7. What is java.util.Comparator
               - a separate interface to specify
               the comparison via compare() method




















Map = similar to dictionary concept
        key --> Value
        |           |
        you search  +---- to fetch a value
        for a key

    like at reception you get the key for your Room

    like at any apartment you see the "name board" at
    ground floor to access the Name of the flat owner/RoomNo/Wing


 */





