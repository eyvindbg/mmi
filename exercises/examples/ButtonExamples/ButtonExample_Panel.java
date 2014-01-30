/**
  Example 1A, TDT4180-2005.
  This example shows the use of an action listener by
  letting the JPanel implement the ActionListener interface.
  This is done by implementing the method "actionPerformed".
 */

import javax.swing.*;
import java.awt.event.*;

public class ButtonExample_Panel extends JPanel implements ActionListener
{   

   private JTextField myTextField;   // The text field.
   private JButton myButton;         // The button.

// Constructor for objects of class ButtonExample_Panel
     
    public ButtonExample_Panel()
    {
       myButton = new JButton("Press here");  // Create new JButton object.
       myButton.addActionListener(this);      // Add this JPanel as action listener.
       add(myButton);                         // Add the JButton to the panel.
       myTextField  = new JTextField();       // Create and add new textfield..
       myTextField.setColumns(20);       
       add(myTextField);
       myTextField.setText("...");
    }
  
    /** Actions for myButton  **/
        public void actionPerformed(ActionEvent e) {   // This method is called by JButton.
            myTextField.setText("Hello my world.");
        }
  
    public static void main (String args[]) {
        JFrame frame = new JFrame("Button example");
        frame.getContentPane().add(new ButtonExample_Panel());
        frame.pack(); 
        frame.setVisible(true);  
    }
}

