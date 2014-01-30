/**
  Example 1C, TDT4180-2005.
  This example shows the use of an action listener by
  making an explicit "controller" class for the JButton.
 */

import javax.swing.*;
import java.awt.event.*;

public class ButtonExample_WithController extends JPanel
{   
   public JTextField myTextField;
   private JButton myButton;
   
    /**
     * Constructor for objects of class ButtonExample_WithController
     */
    public ButtonExample_WithController()
    {
       myButton = new JButton("Press here");
       myButton.addActionListener(new ButtonExample_Controller(this));
       add(myButton);
       myTextField  = new JTextField();
       myTextField.setColumns(20);       
       add(myTextField);
       myTextField.setText("...");
    }
  
    public static void main (String args[]) {
        JFrame frame = new JFrame("Button example");
        frame.getContentPane().add(new ButtonExample_WithController());
        frame.pack(); 
        frame.setVisible(true);  
    }
}
