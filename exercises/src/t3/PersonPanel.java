package t3;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PersonPanel extends JPanel implements PropertyChangeListener {
	
	JTextField NamePropertyComponent;
	JTextField EmailPropertyComponent;
	JTextField DateOfBirthPropertyComponent;
	JComboBox GenderPropertyComponent;
	JSlider HeightPropertyComponent;
	GridBagLayout layout;
	GridBagConstraints c;
	
	public Person model = null;
	
	public PersonPanel() {
		
		layout = new GridBagLayout();
		
		setLayout(layout);
		c = new GridBagConstraints();
		c.insets = new Insets(10, 5, 5, 5);
		c.anchor = GridBagConstraints.WEST;

		//1st row
		c.gridx = 0;
		c.gridy = 0;
		add(new JLabel("Name"), c);
		
		NamePropertyComponent = new JTextField();
		NamePropertyComponent.setColumns(20);
		NamePropertyComponent.setName("NamePropertyComponent");
//		NamePropertyComponent.addActionListener(new ActionHandler("name"));
		
		c.gridx = 1;
		add(NamePropertyComponent, c);
		
		// 2nd row
		c.insets = new Insets(2, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 1;
		add(new JLabel("Email"), c);
		
		EmailPropertyComponent = new JTextField();
		EmailPropertyComponent.setColumns(20);
		EmailPropertyComponent.setName("EmailPropertyComponent");
//		EmailPropertyComponent.addActionListener(new ActionHandler("email"));

		c.gridx = 1;
		add(EmailPropertyComponent, c);
		
		// 3rd row
		c.gridx = 0;
		c.gridy = 2;
		add(new JLabel("Birthday"), c);
		
		DateOfBirthPropertyComponent = new JTextField();
		DateOfBirthPropertyComponent.setColumns(20);
		DateOfBirthPropertyComponent.setName("DateOfBirthPropertyComponent");
//		DateOfBirthPropertyComponent.addActionListener(new ActionHandler("bday"));
		
		c.gridx = 1;
		add(DateOfBirthPropertyComponent, c);
		
		// 4th row
//		c.gridx = 0;
		c.gridy = 3;
//		add(new JLabel("Gender"), c);	
		
		GenderPropertyComponent = new JComboBox(Gender.values());
		GenderPropertyComponent.setName("GenderPropertyComponent");
//		GenderPropertyComponent.addActionListener(new ActionHandler("gender"));
		
		c.gridx = 0;
		add(GenderPropertyComponent, c);
		
		// 5th row
		c.gridx = 0;
		c.gridy = 3;
//		add(new JLabel("Height"), c);
		
		HeightPropertyComponent = new JSlider(120, 220, 175);
		HeightPropertyComponent.setName("HeightPropertyComponent");
		HeightPropertyComponent.setMajorTickSpacing(20);
		HeightPropertyComponent.setMinorTickSpacing(5);
		HeightPropertyComponent.setPaintTicks(true);
		HeightPropertyComponent.setPaintLabels(true);
		HeightPropertyComponent.setPreferredSize(new Dimension (230, 50));
//		HeightPropertyComponent.addChangeListener(new HeightChangeListener());
		
		c.gridx = 1;
		add(HeightPropertyComponent, c);
		
		NamePropertyComponent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model != null) {
					model.setName(NamePropertyComponent.getText());
				}
				
			}
		});
		
		EmailPropertyComponent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model != null) {
					model.setEmail(EmailPropertyComponent.getText());
				}
				
			}
		});
		
		DateOfBirthPropertyComponent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model != null) {
					model.setDateOfBirth(DateOfBirthPropertyComponent.getText());
				}
				
			}
		});
		
		GenderPropertyComponent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model != null) {
					model.setGender((Gender)GenderPropertyComponent.getSelectedItem());
				}
			}
		});
		
		HeightPropertyComponent.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (model != null) {
					model.setHeight(HeightPropertyComponent.getValue());
				}
				
			}
		});
	

	}
	
	private Gender getGender() {
		if (GenderPropertyComponent.getSelectedIndex() == 0) {
			return Gender.MALE;
		} else {
			return Gender.FEMALE;
		}
	}
	
//	class ActionHandler implements ActionListener {
//		
//		String component;
//		
//		public ActionHandler(String component) {
//			this.component = component;
//		}
//
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//
//			if (component == "name") {
//				model.setName(NamePropertyComponent.getText());
//			}
//			
//			else if (component == "email") {
//				model.setEmail(EmailPropertyComponent.getText());
//			}
//			
//			else if (component == "bday") {
//				model.setDateOfBirth(DateOfBirthPropertyComponent.getText());
//			}
//			
//			else if (component == "gender") {
//				model.setGender(getGender());
//			}
//			
//		}
//		
//	}
//
//	class HeightChangeListener implements ChangeListener {
//
//		@Override
//		public void stateChanged(ChangeEvent arg0) {
//			model.setHeight(HeightPropertyComponent.getValue());
//			
//		}
//		
//	}
	
	public void setModel(Person p) {
		this.model = p;
		this.model.addPropertyChangeListener(this);
		NamePropertyComponent.setText(p.getName());
		EmailPropertyComponent.setText(p.getEmail());
		DateOfBirthPropertyComponent.setText(p.getDateOfBirth());
		if (p.getGender() == Gender.MALE) {
			GenderPropertyComponent.setSelectedIndex(0);
		} else {
			GenderPropertyComponent.setSelectedIndex(1);
		}
		HeightPropertyComponent.setValue(p.getHeight());
		
	}
	
	public Person getModel() {
		return model;
	}
	
	public static void main(String[] args) {
		
		Person p = new Person("Eyvind Gjertsen");
		p.setEmail("eyvindbg@gmail.com");
		p.setDateOfBirth("24 Jul 1990");
		p.setGender(Gender.MALE);
		p.setHeight(180);
		
		PersonPanel panel = new PersonPanel();
		panel.setModel(p);
		
		JFrame frame = new JFrame("Exercise 2");
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);  
        
        PassivePersonPanel passivePanel = new PassivePersonPanel();
        passivePanel.setModel(p);
        
        JFrame frame2 = new JFrame("PassivePersonPanel");
        frame2.getContentPane().add(passivePanel);
        frame2.pack();
        frame2.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (model == null) {
			return;
		}
		
		if (evt.getPropertyName() == Person.NAME_PROPERTY) {
			NamePropertyComponent.setText(model.getName());
			System.out.println("Property change event; name: " + model.getName());
		}
		else if (evt.getPropertyName() == Person.EMAIL_PROPERTY) {
			EmailPropertyComponent.setText(model.getEmail());
			System.out.println("Property change event; email: " + model.getEmail());
		}
		else if (evt.getPropertyName() == Person.BDAY_PROPERTY) {
			DateOfBirthPropertyComponent.setText(model.getDateOfBirth());
			System.out.println("Property change event; birthdate: " + model.getDateOfBirth());
		}
		else if (evt.getPropertyName() == Person.GENDER_PROPERTY) {
			GenderPropertyComponent.setSelectedItem(model.getGender());
			System.out.println("Property change event; gender: " + model.getGender());
		}
		else if (evt.getPropertyName() == Person.HEIGHT_PROPERTY) {
			HeightPropertyComponent.setValue(model.getHeight());
			System.out.println("Property change event; birthdate: " + model.getDateOfBirth());
		}
		
		
	}

}
