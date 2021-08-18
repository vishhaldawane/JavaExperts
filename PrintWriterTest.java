import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args) {

        PrintWriter pw = new PrintWriter(System.out);//destination is monitor

        pw.println("Hello Monitor");
        pw.println("Hello Screen");
        pw.flush();

        FileWriter fw = null;
        try {
            fw = new FileWriter("master.txt"); //destination is file
            PrintWriter fileWriter  = new PrintWriter(fw);
            fileWriter.println("Hello File");
            fileWriter.println("Hello File how are you");
            fileWriter.flush();
            fileWriter.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        pw.close();
    }
}
