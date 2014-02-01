package t3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PassivePersonPanel extends PersonPanel {
	
	
	public JTextField GenderPC;
	public JTextField HeightPC;

	public PassivePersonPanel() {
		super();
		
		NamePropertyComponent.setEditable(false);
		EmailPropertyComponent.setEditable(false);
		DateOfBirthPropertyComponent.setEditable(false);
		
		remove(HeightPropertyComponent);
		remove(GenderPropertyComponent);
		
//		setLayout(new GridBagLayout());
//		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 3;
		add(new JLabel("Gender"), c);
		
		GenderPC = new JTextField();
		GenderPC.setName("GenderPC");
		GenderPC.setColumns(20);
		GenderPC.setEditable(false);
		
		c.gridx = 1;
		add(GenderPC, c);
		
		c.gridx = 0;
		c.gridy = 4;
		add(new JLabel("Height"), c);
		
		HeightPC = new JTextField();
		HeightPC.setName("HeightPC");
		HeightPC.setColumns(20);
		HeightPC.setEditable(false);
		
		c.gridx = 1;
		add(HeightPC, c);
		
	}
	
	public void setModel(Person p) {
		super.setModel(p);
		GenderPC.setText(model.getGender().toString());
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
