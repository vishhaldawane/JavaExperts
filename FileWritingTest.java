import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingTest {
    public static void main(String[] args) {
        try {
            System.out.println("Trying to write to a file...");
            FileOutputStream fout = new
                        FileOutputStream("/Users/apple/IdeaProjects/FileHandlingProject/src/Queen.txt");
                System.out.println("File is ready to create....");

                Scanner scan = new Scanner(System.in);
                String line = scan.nextLine(); //take keyboard input

                byte byteArray[] = line.getBytes();//convert line into an array

                fout.write(byteArray);
                System.out.println("Data is written to the file...");
                fout.close();
                System.out.println("File is closed...");

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





























 */
