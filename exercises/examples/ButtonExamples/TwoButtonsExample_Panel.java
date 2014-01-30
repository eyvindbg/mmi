
/**
 * Write a description of class TwoButtonsExample_Panel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class TwoButtonsExample_Panel extends JPanel implements ActionListener
{   

   private JTextField myTextField;
   private JButton myButton1, myButton2;
   
    /**
     * Constructor for objects of class TwoButtonsExample_Panel
     **/
     
    public TwoButtonsExample_Panel()
    {
       myButton1 = new JButton("Hallo");
       myButton1.addActionListener(this);
       add(myButton1);
       myTextField  = new JTextField();
       myTextField.setColumns(20);       
       add(myTextField);
       myTextField.setText("...");
       myButton2 = new JButton("Hei");
       myButton2.addActionListener(this);
       add(myButton2);
 
    }
  
    /** Actions for myButton  **/
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == myButton1) {
              myTextField.setText("Hallo");};
            if (e.getSource() == myButton2) {
              myTextField.setText("Hei");};
              
        }
  
    public static void main (String args[]) {
        JFrame frame = new JFrame("Button -> TextField example");
        frame.getContentPane().add(new TwoButtonsExample_Panel());
        frame.pack(); 
        frame.setVisible(true);  
    }
}
