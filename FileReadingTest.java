import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadingTest {
    public static void main(String[] args) {
        try {
            System.out.println("Trying to open a file...");
            FileInputStream fin = new FileInputStream("/Users/apple/IdeaProjects/FileHandlingProject/src/prince.txt");
            System.out.println("File is opened....");

            byte theByte = (byte) fin.read(); //raed the first LETTER

            while(theByte != -1) { //verify the End of File is reached or not
                System.out.print((char)theByte); //print that first LETTER
                theByte = (byte) fin.read(); //grab the second letter now
                Thread.sleep(50);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Exception : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception : "+e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Exception : "+e.getMessage());
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





























 */
