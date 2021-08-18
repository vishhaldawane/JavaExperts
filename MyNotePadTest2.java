import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class MyNotePadTest2 {
    public static void main(String[] args) {
        MyNotepad2 myPad2 = new MyNotepad2();
        myPad2.setVisible(true);

       /* MyNotepad myPad2 = new MyNotepad();
        myPad2.setVisible(true);

        MyNotepad myPad3 = new MyNotepad();
        myPad3.setVisible(true);*/
    }
}
//how about the program given yesterday

class MyNotepad2 extends JFrame implements ActionListener
{
    JTextArea data = new JTextArea(10,25);
    JButton save = new JButton("Open File"); //on click of this button the file should be saved
    JLabel prompt = new JLabel("Enter filename ");
    JTextField filename = new JTextField(20);
    JScrollPane jsp = new JScrollPane(data, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println("Button is clicked....");
        try {
            String filePath = "/Users/apple/IdeaProjects/FileHandlingProject/src/"+filename.getText();
            FileInputStream myFile = new FileInputStream(filePath);
            System.out.println("File is open for reading..."+filePath);
            BufferedInputStream buff = new BufferedInputStream(myFile);

            //use BufferReader (character based stream)  for faster reading of a huge size file

            //String is immutable
            //String str="ROSE IS"; // created in the string pool
            //str="ROSE IS MY"; // ROSE is parked aside, and str points to new "rose"
            //str="ROSE IS MY FAVOURITE"; // now "rose" is parked aside, and "Rose" is for str
            //StringBuffer and StringBuilder - mutable
            //single thread     multithread
            //thread safe       asynchronous (not thread safe)
            //slower            faster

            StringBuilder stringToRead=new StringBuilder();

            byte theByte = (byte) myFile.read(); //try buff.read();
            while(theByte != -1 ) {
                stringToRead.append((char)theByte);
                theByte = (byte) myFile.read(); //try buff.read()
                //System.out.println((char)theByte);
            }
            System.out.println(stringToRead);
            //data is a textarea, invoke the setText to fillup the string in it
            data.setText(stringToRead.toString()); // retrieve the String of StringBuilder

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        catch(Exception e1) {
            System.out.println("Exception : "+e1.getMessage());
        }

    }

    MyNotepad2() {

        save.addActionListener(this);// register the button for the event handling
        setLayout(new FlowLayout());
        add(prompt); add(filename);
        add(jsp); add(save);
        super.setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
