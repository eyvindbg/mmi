package t3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.JTextField;

public class PassivePersonPanel extends PersonPanel {
	
	
	private JTextField GenderPC;
	private JTextField HeightPC;

	public PassivePersonPanel() {
		super();
		
		NamePropertyComponent.setEditable(false);
		EmailPropertyComponent.setEditable(false);
		DateOfBirthPropertyComponent.setEditable(false);
		
		remove(HeightPropertyComponent);
		remove(GenderPropertyComponent);
		
//		setLayout(new GridBagLayout());
//		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 1;
		c.gridy = 3;
		
		GenderPC = new JTextField();
		GenderPC.setName("GenderPC");
		GenderPC.setColumns(20);
		GenderPC.setEditable(false);
		
		add(GenderPC, c);
		
		c.gridx = 1;
		c.gridy = 4;
		
		HeightPC = new JTextField();
		HeightPC.setName("HeightPC");
		HeightPC.setColumns(20);
		HeightPC.setEditable(false);
		add(HeightPC, c);
		
	}
	
	public void setModel(Person p) {
		super.setModel(p);
		System.out.println(model.getGender().toString());
		GenderPC.setText(model.getGender().toString());
		System.out.println(Integer.toString(model.getHeight()));
		HeightPC.setText(Integer.toString(model.getHeight()));
		
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		if (evt.getPropertyName() == Person.GENDER_PROPERTY) {
			GenderPC.setText(model.getGender().toString());
		}
		else if (evt.getPropertyName() == Person.HEIGHT_PROPERTY) {
			String height = Integer.toString(model.getHeight());
			HeightPC.setText(height);
		}
		else {
			super.propertyChange(evt);
		}
		
		
	}
	
	

}
