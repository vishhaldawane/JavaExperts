import com.thothit.SavingsAccount;

import java.io.*;

public class ObjectReadingTest {
    public static void main(String[] args) {
        try {
            System.out.println("Trying to load an object..");

            SavingsAccount savObj= null;//

            System.out.println("sav Obj "+savObj);
            System.out.println("object..created...");

            FileInputStream fin = new
                    FileInputStream("/Users/apple/IdeaProjects/FileHandlingProject/src/Savings.txt");
            System.out.println("File is ready to read....");

            ObjectInputStream ois = new ObjectInputStream(fin); //pass fin here
            System.out.println("Object input stream is ready to read the  objects.......");

            System.out.println("Trying to read the object...");
            try {
                savObj = (SavingsAccount) ois.readObject(); //reading Object from the file stored on disk
                System.out.println("Object read from the disk....");
                System.out.println("sav Object : "+ savObj);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            ois.close();
            fin.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
/*
    Java Objects / data used here in Java is in the memory
    memory is volatile
    we want to store our java data on a device
    in the form of a file or a database row

                Java Objects / DATA
                        |
             ----------------------
                |               |
                File            Database
                |


          Read the file         Write to the file
          |                     |
          input stream          output stream


                    Java i/o
                     |
              ------------------
              |                 |
            byte based       character based
            1 byte             1 char = 2 bytes
            |                   |
            ASCII               UNICODE
            |                   |
            256 english         international letters
            letters             65535 ( first 256 ASCII )
                |                       |
       -------------            -----------------
       |        |                   |           |
 InputStream   OutputStream         Reader      Writer <-- abstract parents
 |  read()          |write()        |            |
 FileInputStream FileOutputStream  FileReader   FileWriter


An interface without any method is known as MARKER interface
it simply marks a contract of its functionality to the JVM



























 */
