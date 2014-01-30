package t3;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Person {
	
	public final static String NAME_PROPERTY = "name";
	public final static String BDAY_PROPERTY = "dateOfBirth";
	public final static String GENDER_PROPERTY = "gender";
	public final static String EMAIL_PROPERTY = "email";
	public final static String HEIGHT_PROPERTY = "height";
	
	private String name;
	private String dateOfBirth;
	private Gender gender;
	private String email;
	private int height;
	
	private PropertyChangeSupport pcs;
	
	public Person (String name) {
		this.name = name;
		pcs = new PropertyChangeSupport(this);
	}
	
	// Name
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		pcs.firePropertyChange(NAME_PROPERTY, oldValue, name);
		System.out.println("Name changed from <" + oldValue + "> to " + "<" + name + ">.");
	}
	
	// Bday
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		String oldValue = this.dateOfBirth;
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange(BDAY_PROPERTY, oldValue, dateOfBirth);
		System.out.println("Bday changed from <" + oldValue + "> to " + "<" + dateOfBirth + ">.");
	}
	
	// Gender
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		Gender oldValue = this.gender;
		this.gender = gender;
		pcs.firePropertyChange(GENDER_PROPERTY, oldValue, gender);
		System.out.println("Gender changed from <" + oldValue + "> to " + "<" + gender + ">.");
	}
	
	// Email
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		String oldValue = this.email;
		this.email = email;
		pcs.firePropertyChange(EMAIL_PROPERTY, oldValue, email);
		System.out.println("Email changed from <" + oldValue + "> to " + "<" + email + ">.");
	}
	
	// Height
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		int oldValue = this.height;
		this.height = height;
		pcs.firePropertyChange(HEIGHT_PROPERTY, oldValue, height);
		System.out.println("Height changed from <" + oldValue + "> to " + "<" + height + ">.");
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
}
