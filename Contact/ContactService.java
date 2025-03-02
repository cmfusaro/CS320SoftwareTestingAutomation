// Christopher Fusaro
// January	 22, 2025
// CS 320 Module Three Milestone
// CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)

import java.util.List;
import java.util.ArrayList;


public class ContactService {
	private List<ContactClass> contacts;
	ContactClass newContact = new ContactClass("129874", "Bob", "Smith", "1023456789", "29 Gumout Lane Smithfield, RI");
	
	// Constructor
	public ContactService() {
		this.contacts = new ArrayList<>();
	}
	
	// Getter
	public List<ContactClass> getContacts() {
		return this.contacts;
	}
	
	// Method for adding new contact to contacts list
	public void addContact(ContactClass newContact) {
		System.out.println("Entered addContact function");
		Boolean flag = false;

		// This check see if the list is empty and can bypass the loop to find if the ID is unique 
		if (this.contacts.isEmpty()) {
			this.contacts.add(newContact);
		}
		else {
			// loops through contacts and compares IDs for uniqueness before contact is added
			for (int i = 0; i < this.contacts.size(); i++) {
				ContactClass contact = this.contacts.get(i);
				if (contact.getID().equals(newContact.getID())) {
					flag = true;
					throw new IllegalArgumentException("ID not unique");
					}
				}
			if (flag == false) {
				this.contacts.add(newContact);
				}
		}
		return;
	}
		
	// Method for deleting contact from contacts list based on ID
	public void deleteContact(String selectedID) {
		System.out.println("delete function entered");
		boolean flag = false;
		for (ContactClass contact : this.contacts) {
			if (contact.getID().equals(selectedID)) {
					this.contacts.remove(contact);
					System.out.println("contact deleted");
					flag = true;
					break;
				}
			}
			if (flag == false) {
				System.out.println("contact ID not found");
				throw new IllegalArgumentException("ID not found");
			}
		return;
	}
	
	// Method for updating contact attributes except ID, ID is used to locate contact
	public void updateContact(String selectedID, String firstName, String lastName, String phone, String address) {
		System.out.println("updateContact function entered");
		boolean flag = false;
		for (ContactClass contact : this.contacts) {
			// We are checking for nulls just so not all fields need to be updated the rest of the 
			// requirements is handled at the object validation level.
			if (contact.getID().equals(selectedID)) {
				System.out.println("contact ID found");
					flag = true;
					if (firstName!=null) {
						contact.updateFirstName(firstName);
						System.out.println("firstName updated");
					}
					if (lastName!=null) {
						contact.updateLastName(lastName);
						System.out.println("lastName updated");
					}
					if (phone!=null) {
						contact.updatePhone(phone);
						System.out.println("phone updated");
					}
					if (address!=null) {
						contact.updateAddress(address);
						System.out.println("address updated");
					}
					break;
				}
			}
			
			if (flag == false) {
				throw new IllegalArgumentException("ID not found");
			}
		return;
	} 
}
