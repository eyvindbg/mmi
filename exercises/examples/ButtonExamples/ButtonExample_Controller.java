
/**
  Explicit controller class.
 */

import java.awt.event.*;

public class ButtonExample_Controller implements ActionListener
{
	// instance variables - replace the example below with your own
	private ButtonExample_WithController myPanel;

	/**
	 * Constructor for objects of class ButtonExample_Controller
	 */
	public ButtonExample_Controller(ButtonExample_WithController thePanel)
	{
		// initialise instance variables
		myPanel = thePanel;
	}
    /** Actions for myButton  **/
    
    public void actionPerformed(ActionEvent e) {
        myPanel.myTextField.setText("Hello world.");
    }
}
