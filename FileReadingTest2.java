import java.io.*;

public class FileReadingTest2 {
    public static void main(String[] args) {
        try {
            System.out.println("Trying to open a file...");
            //ahead of byte based stream
            //ASCII + UNICODE
            //character based stream
            //any alphabet of any language
            String str = "सुझाव"; //some Unicode string: utf-8
            String str1 = "\u0938\u0941\u091d\u093e\u0935";
            System.out.println(str);
            System.out.println(str1);

             FileReader fin = new
                    FileReader("/Users/apple/IdeaProjects/FileHandlingProject/src/PUNJABI.TXT");
            System.out.println("File is opened....");

            OutputStreamWriter nosw = new OutputStreamWriter(System.out,"UTF-8");

            int theInt =  fin.read(); //raed the first LETTER
//int is 4 bytes in memory = 32 bits 65535
            while(theInt != -1) { //verify the End of File is reached or not
                //nosw.write((char)theInt );
                System.out.print((char)theInt); //print that first LETTER
                theInt =  fin.read(); //grab the second letter now
                Thread.sleep(5);
                //nosw.flush();
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
 |  read()          |write()        |  read()      |write()
 FileInputStream FileOutputStream  FileReader   FileWriter





























 */
