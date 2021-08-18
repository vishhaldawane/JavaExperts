import com.thothit.SavingsAccount;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ObjectWritingTest {
    public static void main(String[] args) {
        try {
            System.out.println("Trying to create an object..");

            SavingsAccount savObj= new SavingsAccount(101,"Julia",50000,1234);
            System.out.println("sav Obj "+savObj);
            System.out.println("object..created...");

            FileOutputStream fout = new
                    FileOutputStream("/Users/apple/IdeaProjects/FileHandlingProject/src/Savings.txt", true);
            System.out.println("File is created....");

            ObjectOutputStream oos = new ObjectOutputStream(fout); //pass fout here
            System.out.println("Object output stream is ready to write the  objects.......");

            System.out.println("Trying to write the object...");
            oos.writeObject(savObj); //OH!!! private data is stolen to write to the disk....very bad
            System.out.println("Object is written to the disk....");

            oos.close();
            fout.close();

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
