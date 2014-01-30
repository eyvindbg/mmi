package t4;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import t3.Person;

public class PersonCellRenderer extends JLabel implements ListCellRenderer {

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    	if (value instanceof Person) {
    		Person person = (Person) value;
    		String name = person.getName();
    		String email = person.getEmail();
    		String bday = person.getDateOfBirth();
    		String gender = person.getGender().toString();
    		String height = Integer.toString(person.getHeight());
    		setText("Name: " + name +  " | Email: " + email + " | BDay: " + bday + " | Gender: " + gender + " | Height: " + height);
    	}
        
        if (isSelected) {
        	setBackground(list.getSelectionBackground());
        	setForeground(list.getSelectionForeground());
        }
        
        else {
        	setBackground(list.getBackground());
        	setForeground(list.getForeground());
        }
        
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }
}
