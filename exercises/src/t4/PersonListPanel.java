package t4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.w3c.dom.views.AbstractView;

import t3.Gender;
import t3.PassivePersonPanel;
import t3.PersonPanel;
import t3.Person;

public class PersonListPanel extends JPanel {
	
	private JList<Person> personList;
	private PersonPanel personPanel;
	private PassivePersonPanel passivePanel;
	private JButton addButton;
	private JButton deleteButton;
	
	private DefaultListModel<Person> model;
	private DefaultListSelectionModel personListSelectionModel;
	
	private GridBagLayout layout;
	
	public PersonListPanel() {
		
		layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		setLayout(new FlowLayout());
		
		model = new DefaultListModel<Person>();
		personList = new JList<Person>(model);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new addPersonAction());
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new deletePersonAction());
		
		personListSelectionModel = new DefaultListSelectionModel();
        personListSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		personList.setSelectionModel(personListSelectionModel);
		
		personList.setName("PersonList");
		personList.setVisibleRowCount(10);
		personList.setCellRenderer(new PersonCellRenderer());
		personList.setBorder((Border) new LineBorder(Color.lightGray, 1));
		//personList.setMinimumSize(new Dimension(500, 100));
		
		JScrollPane scrollPane = new JScrollPane(personList);
		scrollPane.setPreferredSize(new Dimension(280, 150));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(scrollPane, gbc);
		
	
		
		
		gbc.gridx = 1;
		
		
		passivePanel = new PassivePersonPanel();
		gbc.gridy = 1;
		gbc.gridx = 0;
		add(passivePanel, gbc);
		
		add(Box.createHorizontalStrut(5));
		add(new JSeparator(SwingConstants.VERTICAL));
		
		personPanel = new PersonPanel();
		personPanel.setName("PersonPanel");
		add(personPanel, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		gbc.ipady = 15;
		add(addButton, gbc);
		
		

		gbc.gridx = 1;
		add(deleteButton, gbc);
		
		Person person1 = createPerson("Eksempel Eksempelsen", "example@eksempel.no", "1. Jan 1980", Gender.MALE, 200);
		Person person2 = createPerson("Svetlana Krushnikova", "krushnikova@russland.ru", "31. Apr 1899", Gender.FEMALE, 150);
		Person person3 = createPerson("Roger Hansen", "hansen@epost.com", "24. Des 1976", Gender.MALE, 183);
		
		model.addElement(person1);
		model.addElement(person2);
		model.addElement(person3);
		
		personList.addListSelectionListener(new PersonListSelectionListener());
		
	}
	
    class PersonListSelectionListener implements ListSelectionListener
    {   public void valueChanged(ListSelectionEvent e) {
           if (!personListSelectionModel.isSelectionEmpty()) {
               int i = personListSelectionModel.getAnchorSelectionIndex();
               personPanel.setModel((Person)model.elementAt(i));
               passivePanel.setModel((Person)model.elementAt(i));
            };

        }
    };
    
    public class deletePersonAction implements ActionListener {

    	@Override
    	public void actionPerformed(ActionEvent arg0) {
    		int i = personListSelectionModel.getAnchorSelectionIndex();
    		model.remove(i);
    		personPanel.NamePropertyComponent.setText("");
    		personPanel.EmailPropertyComponent.setText("");
    		personPanel.DateOfBirthPropertyComponent.setText("");
    		personPanel.GenderPropertyComponent.setSelectedIndex(0);
    		personPanel.HeightPropertyComponent.setValue(175);
    		
    		passivePanel.NamePropertyComponent.setText("");
    		passivePanel.EmailPropertyComponent.setText("");
    		passivePanel.DateOfBirthPropertyComponent.setText("");
    		passivePanel.GenderPC.setText("");;
    		passivePanel.HeightPC.setText("");;

    	}

    }
    
    public class addPersonAction implements ActionListener {

    	@Override
    	public void actionPerformed(ActionEvent arg0) {
    		String email = personPanel.EmailPropertyComponent.getText();
    		
    		for (int i = 0; i < model.getSize(); i++) {
    			if (model.getElementAt(i).getEmail().equals(email)) {
    				System.out.println("Person is already in the list.");
    				return;
    			}
    		}
    		
    		String name = personPanel.NamePropertyComponent.getText();
    		String bday = personPanel.DateOfBirthPropertyComponent.getText();
    		int g = personPanel.GenderPropertyComponent.getSelectedIndex();
    		int height = personPanel.HeightPropertyComponent.getValue();
    		Gender gender;
    		if (g == 0) {
    			gender = Gender.MALE;
    		} else {
    			gender = Gender.FEMALE;
    		}
    		
    		Person person = createPerson(name, email, bday, gender, height);
    		model.addElement(person);

    	}

    }
	
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
