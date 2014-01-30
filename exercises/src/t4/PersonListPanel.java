package t4;

import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.ListCellRenderer;

import org.w3c.dom.views.AbstractView;

import t3.Gender;
import t3.PersonPanel;
import t3.Person;

public class PersonListPanel extends JPanel {
	
	JList<Person> personList;
	PersonPanel personPanel;
	
	private DefaultListModel model;
	
	public PersonListPanel() {
		
		model = new DefaultListModel<>();
		
		personList = new JList<Person>(model);
		personList.setName("PersonList");
		personList.setVisibleRowCount(10);
		personList.setCellRenderer(new PersonCellRenderer());
		add(personList);
		
		personPanel = new PersonPanel();
		personPanel.setName("PersonPanel");
		add(personPanel);
		
		model.addElement((createPerson("Rollf", "rolfern@gui.zz", "1. Jan 1000", Gender.MALE, 200)));
		
		
	}
	
	public Person createPerson(String name, String email, String bday, Gender gender, int height) {
		Person person = new Person(name);
		person.setEmail(email);
		person.setGender(gender);
		person.setHeight(height);
		person.setDateOfBirth(bday);
		return person;
	}
	
	public void addPersonToList(Person p) {
		
	}
	
	public class PersonCellRenderer extends JLabel implements ListCellRenderer {

	     public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	         String s = value.toString();
	         setText(s);
	         return this;
	     }
	 }
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("T4");
		frame.getContentPane().add(new PersonListPanel());
		frame.pack();
		frame.setVisible(true);
	}
	
	

}
