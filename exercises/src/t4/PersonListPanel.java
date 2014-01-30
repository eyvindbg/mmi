package t4;

import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.w3c.dom.views.AbstractView;

import t3.Gender;
import t3.PersonPanel;
import t3.Person;

public class PersonListPanel extends JPanel {
	
	private JList<Person> personList;
	private PersonPanel personPanel;
	
	private DefaultListModel model;
	private DefaultListSelectionModel personListSelectionModel;
	
	public PersonListPanel() {
		
		model = new DefaultListModel();
		personList = new JList<Person>(model);
		
		personListSelectionModel = new DefaultListSelectionModel();
        personListSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		personList.setSelectionModel(personListSelectionModel);
		
		personList.setName("PersonList");
		personList.setVisibleRowCount(10);
		personList.setCellRenderer(new PersonCellRenderer());
		add(personList);
		
		personPanel = new PersonPanel();
		personPanel.setName("PersonPanel");
		add(personPanel);
		
		Person person1 = createPerson("Rollf", "rolfern@gui.zz", "1. Jan 1000", Gender.MALE, 200);
		Person person2 = createPerson("Svetlana", "sap@spa.com", "35. Apr 1999", Gender.FEMALE, 150);
		
		model.addElement(person1);
		model.addElement(person2);
		
		personList.addListSelectionListener(new PersonListSelectionListener());
		
	}
	
    class PersonListSelectionListener implements ListSelectionListener
    {   public void valueChanged(ListSelectionEvent e){
           if (!personListSelectionModel.isSelectionEmpty()){
               int i = personListSelectionModel.getAnchorSelectionIndex();
               personPanel.setModel((Person)model.elementAt(i));
            };

        }
    };
	
	public void setModel(DefaultListModel model) {
		this.model = model;
		
	}
	
	public DefaultListModel getModel() {
		return this.model;
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
		
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("T4");
		frame.getContentPane().add(new PersonListPanel());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

}
