// Christopher Fusaro
// January	 22, 2025
// CS 320 Module Three Milestone
// CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)

import java.util.regex.*;


public class ContactClass {
	private String ID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// ContactClass Constructor
	
	public ContactClass(String ID, String firstName, String lastName, String phone, String address) {
		// Checks to ensure that data meets requirements
		// Aside from generating the ID myself i was unsure how to enforce uniqueness
		// on the level so I used the ContactService class to do it
		if(ID == null  || ID.length()>10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(firstName == null  || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid firstName");
		}
		if(lastName == null  || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid lastName");
		}
		// An extra check was placed at the end to make sure that only digits were accepted
		if(phone == null  || phone.length()!=10 || !phone.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid phone");
		}
		if(address == null  || address.length()>30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Getters
	public String getID() {
			return ID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	// Setters
	// The ID attribute has been exclude to ensure that is unable to be updated once set
	void updateFirstName(String firstName) {
		if(firstName == null  || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid firstName");
		}
		this.firstName = firstName;
	}
	void updateLastName(String lastName) {
		if(lastName == null  || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid lastName");
		}
		this.lastName = lastName;
	}
	void updatePhone(String phone) {
		if(phone == null  || phone.length()!=10 || !phone.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid phone");
		}
		this.phone = phone;
	}
	void updateAddress(String address) {
		if(address == null  || address.length()>30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
}
