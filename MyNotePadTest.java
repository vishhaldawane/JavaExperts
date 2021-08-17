import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MyNotePadTest {
    public static void main(String[] args) {
        MyNotepad myPad1 = new MyNotepad();
        myPad1.setVisible(true);

        MyNotepad myPad2 = new MyNotepad();
        myPad2.setVisible(true);

        MyNotepad myPad3 = new MyNotepad();
        myPad3.setVisible(true);
    }
}
class MyNotepad extends JFrame implements ActionListener
{
    JTextArea data = new JTextArea(10,25);
    JButton save = new JButton("Save File"); //on click of this button the file should be saved
    JLabel prompt = new JLabel("Enter filename ");
    JTextField filename = new JTextField(20);

    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println("Button is clicked....");
        try {
            FileOutputStream myFile = new FileOutputStream(filename.getText());
            System.out.println("File is crated...");
            //find the data
            String stringToBeWritten= data.getText();
            byte byteArray[] = stringToBeWritten.getBytes(); //convert the string into array
            myFile.write(byteArray);
            JOptionPane.showMessageDialog(this,"File is saved!!!");

            myFile.close();
            System.out.println("File is closed...");
            System.out.println("File is save!!!");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    MyNotepad() {
        save.addActionListener(this);// register the button for the event handling
        setLayout(new FlowLayout());
        add(prompt); add(filename);
        add(data); add(save);
        super.setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
