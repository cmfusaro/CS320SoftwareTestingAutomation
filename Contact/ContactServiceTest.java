// Christopher Fusaro
// January	 22, 2025
// CS 320 Module Three Milestone
// CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ContactServiceTest {
	
	// Tests that ContactService class creates contactService object with an empty list
	
	@Test
	void testContactServiceList() {
		ContactService contactService = new ContactService(); 
		assertTrue(contactService.getContacts().isEmpty());
	}

	// Tests that ContactService class is able to add contact to list
	
	@Test
	void testAddContact() {
		ContactService contactService = new ContactService();
		ContactClass newContact = new ContactClass("129874", "Bob", "Smith", "1023456789", "29 Gumout Lane Smithfield, RI");
		contactService.addContact(newContact);
		assertFalse(contactService.getContacts().isEmpty());
	}
	
	// Tests that ContactService class is only able add contacts with unique IDs

	@Test
	void testUniqueIDAddContact() {
		assertThrows(IllegalArgumentException.class, () -> {
			ContactService contactService = new ContactService();
			ContactClass newContact = new ContactClass("129874", "Bob", "Smith", "1023456789", "29 Gumout Lane Smithfield, RI");
			contactService.addContact(newContact);
			// Attempts to add the same contact again which should have a conflict do to same IDs
			contactService.addContact(newContact);}
		);
	}
	
	// Tests that ContactService class is able to delete contact from list
	
	@Test
	void testDeleteContact() {
		ContactService contactService = new ContactService();
		ContactClass newContact = new ContactClass("129874", "Bob", "Smith", "1023456789", "29 Gumout Lane Smithfield, RI");
		contactService.addContact(newContact);
		contactService.deleteContact("129874");
		assertTrue(contactService.getContacts().isEmpty());
	}
	
	// Tests that ContactService class is able to update contact firstName using ID
	
	@Test
	void UpdateContactFirstName() {
		ContactService contactService = new ContactService();
		ContactClass newContact = new ContactClass("129874", "Bob", "Smith", "1023456789", "29 Gumout Lane Smithfield, RI");
		contactService.addContact(newContact);
		contactService.updateContact("129874", "Cecil", null, null, null);
		System.out.println("updateContact completed");
		for (ContactClass contact : contactService.getContacts()) {
			if (contact.getID().equals("129874")) {
				System.out.println("contact found");
				System.out.println(contact.getFirstName());
				assertTrue(contact.getFirstName().equals("Cecil"));
				break;
			}
		}
		
	}
	
	// Tests that ContactService class is able to update contact lasttName using ID
	
	@Test
	void UpdateContactLastName() {
		ContactService contactService = new ContactService();
		ContactClass newContact = new ContactClass("129874", "Bob", "Smith", "1023456789", "29 Gumout Lane Smithfield, RI");
		contactService.addContact(newContact);
		contactService.updateContact("129874", null, "Barker", null, null);
		System.out.println("updateContact completed");
		for (ContactClass contact : contactService.getContacts()) {
			if (contact.getID().equals("129874")) {
				System.out.println("contact found");
				System.out.println(contact.getLastName());
				assertTrue(contact.getLastName().equals("Barker"));
				break;
			}
		}
	}
		
		
	// Tests that ContactService class is able to update contact phone using ID
		
	@Test
	void UpdateContactPhone() {
		ContactService contactService = new ContactService();
		ContactClass newContact = new ContactClass("129874", "Bob", "Smith", "1023456789", "29 Gumout Lane Smithfield, RI");
		contactService.addContact(newContact);
		contactService.updateContact("129874", null, null, "4018675309", null);
		System.out.println("updateContact completed");
		for (ContactClass contact : contactService.getContacts()) {
			if (contact.getID().equals("129874")) {
				System.out.println("contact found");
				System.out.println(contact.getPhone());
				assertTrue(contact.getPhone().equals("4018675309"));
				break;
			}
		}
	}

	// Tests that ContactService class is able to update contact address using ID
	
	@Test
	void UpdateContactAddress() {
		ContactService contactService = new ContactService();
		ContactClass newContact = new ContactClass("129874", "Bob", "Smith", "1023456789", "29 Gumout Lane Smithfield, RI");
		contactService.addContact(newContact);
		contactService.updateContact("129874", null, null, null, "221B Baker Street London, UK");
		System.out.println("updateContact completed");
		for (ContactClass contact : contactService.getContacts()) {
			if (contact.getID().equals("129874")) {
				System.out.println("contact found");
				System.out.println(contact.getAddress());
				assertTrue(contact.getAddress().equals("221B Baker Street London, UK"));
				break;
			}
		}
	}
	
}
