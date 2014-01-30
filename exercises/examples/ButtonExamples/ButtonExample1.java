package ButtonExamples;


/**
 * A simple JButton in a JPanel
 * The JPanel lives in the contentPane of a JFrame.
 * DS 2005, TDT4180
 */
import javax.swing.*;

public class ButtonExample1 extends JPanel
{   
    /**
     * Constructor for objects of class ButtonExample
     */
    public ButtonExample1()
    {
       add(new JButton("Press here"));
    }
  
    public static void main (String args[]) {

        JFrame frame = new JFrame("Button example");
        frame.getContentPane().add(new ButtonExample1());
        frame.pack();
        frame.setVisible(true);  
    }
}
