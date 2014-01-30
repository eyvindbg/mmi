/**
  Example 1B, TDT4180-2005.
  This example shows the use of an action listener by
  letting the JPanel have an innner class "MyButtonAction" that
  implements the ActionListener interface.   **/

import javax.swing.*;
import java.awt.event.*;

public class ButtonExample_Innerclass extends JPanel
{   
   private JTextField myTextField;
   private JButton myButton;
   
    /**  Constructor for objects of class ButtonExample_Innerclass */
    public ButtonExample_Innerclass()
    {
       myButton = new JButton("Press here");
       myButton.addActionListener(new MyButtonAction());
       add(myButton);
       myTextField  = new JTextField();
       myTextField.setColumns(20);       
       add(myTextField);
       myTextField.setText("...");
    }
  
    /** Actions for myButton  **/
    class MyButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            myTextField.setText("Hello world.");
        }
    }
  
    public static void main (String args[]) {
        JFrame frame = new JFrame("Button example");
        frame.getContentPane().add(new ButtonExample_Innerclass());
        frame.pack(); 
        frame.setVisible(true);  
    }
}
