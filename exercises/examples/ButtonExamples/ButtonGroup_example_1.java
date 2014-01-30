package ButtonExamples;


/**
 * Write a description of class TwoButtonsExample_Innerclass here.
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

public class ButtonGroup_example_1 extends JPanel 
{   

   private JTextField myTextField;
   private JButton myButton1, myButton2, myButton3;
   
    /**
     * Constructor for objects of class TwoButtonsExample_Panel
     **/
     
    public ButtonGroup_example_1()
    {
       myButton1 = new JButton("Hallo");
       myButton1.addActionListener(new MyButton1Action());
       add(myButton1);
       myTextField  = new JTextField();
       myTextField.setColumns(20);       
       add(myTextField);
       myTextField.setText("...");
       myButton2 = new JButton("Hei");
       myButton2.addActionListener(new MyButton2Action());
       add(myButton2);
       
       myButton3 = new JButton("Hallo igjen");
       myButton3.addActionListener(new MyButton1Action());
       add(myButton3);
 
    }
  
    /** Actions for myButton1  **/
    class MyButton1Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            myTextField.setText("Hallo");
        }
    }
  
    /** Actions for myButton2  **/
    class MyButton2Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            myTextField.setText("Hei");
        }
    }  
    public static void main (String args[]) {
        JFrame frame = new JFrame("Button -> TextField example");
        frame.getContentPane().add(new ButtonGroup_example_1());
        frame.pack(); 
        frame.setVisible(true);  
    }
}
