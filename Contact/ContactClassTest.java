// Christopher Fusaro
// January	 22, 2025
// CS 320 Module Three Milestone
// CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactClassTest {
	
	ContactClass newContact;
	@BeforeEach
	void setUp() {
		// Set up the test environment 
		newContact = new ContactClass(
				"129874", "Bob", "Smith", "1023456789", 
				"29 Gumout Lane Smithfield, RI"
				);
	}
	
	// Test case for constructor
	
	@Test
	void testContactClass() {
		ContactClass contactClass = new ContactClass(
				"129874", "Bob", "Smith", "1023456789", "29 Gumout Lane Smithfield, RI"
				); 
		assertTrue(contactClass.getID().equals("129874"));
		assertTrue(contactClass.getFirstName().equals("Bob"));
		assertTrue(contactClass.getLastName().equals("Smith"));
		assertTrue(contactClass.getPhone().equals("1023456789"));
		assertTrue(contactClass.getAddress().equals("29 Gumout Lane Smithfield, RI"));
	}
	
	//Test cases for ID
	
	@Test
	void testContactClassIDNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass(null, "Bob", "Smith",
					"1023456789", "29 Gumout Lane Smithfield, RI");}
		);
	}
	
	@Test
	void testContactClassIDToLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("123456789011", "Bob", 
					"Smith", "1023456789", "29 Gumout Lane Smithfield, RI");}
		);
	}
	
	// Test cases for firstName
	
	@Test
	void testContactClassFirstNameNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("129874", null, 
					"Smith", "1023456789", "29 Gumout Lane Smithfield, RI");}
		);
	}
	
	@Test
	void testContactClassFirstNameToLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("129874", "Maximilliano", 
					"Smith", "1023456789", "29 Gumout Lane Smithfield, RI");}
		);
	}
	
	// Test cases for lastName 
	
	@Test
	void testContactClassLastNameNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("129874", "Bob", 
					null, "1023456789", "29 Gumout Lane Smithfield, RI");}
		);
	}
	
	@Test
	void testContactClassLastNameToLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("129874", "Vicky", 
					"Vaillancourt", "1023456789", "29 Gumout Lane Smithfield, RI");}
		);
	}
	
	// Test cases for phone
	
	@Test
	void testContactClassPhoneNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("129874", "Bob", 
					"Smith", null, "29 Gumout Lane Smithfield, RI");}
		);
	}
	
	@Test
	void testContactClassPhoneNotEqualToTen() {
		// This assertion phone over test over ten character
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("129874", "Bob", 
					"Smith", "11023456789", "29 Gumout Lane Smithfield, RI");}
		);
		// This assertion phone over test less than ten character
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("129874", "Bob", 
					"Smith", "23456789", "29 Gumout Lane Smithfield, RI");}
		);
	}
	
	@Test
	void testContactClassPhoneIsDigits() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("129874", "Bob", 
					"Smith", "a123456789", "29 Gumout Lane Smithfield, RI");}
		);
	}
	
	// Test cases for address
	
	@Test
	void testContactClassAddressNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("129874", "Bob", 
					"Smith", "1023456789", null);}
		);
	}
	
	@Test
	void testContactClassAddressToLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("129874", "Bob", 
					"Smith", "1023456789", 
					"29 Char­gogg­a­gogg­man­chaugg­a­gogg­chau­bun­a­gung­a­maugg Road Webster, MA");}
		);
	}
	
	// Test cases for updateFirstName
	
	@Test
	void testContactClassUpdateFirstName() {
		newContact.updateFirstName("Chris");;
		assertTrue(newContact.getFirstName().equals("Chris"));
	}
	
	@Test
	void testContactClassUpdateFirstNameNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.updateFirstName(null);}
		);
	}
	
	@Test
	void testContactClassUpdateFirstNameToLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.updateFirstName("Maximilliano");}
		);
	}
	
	// Test cases for updateLastName
	
	@Test
	void testContactClassUpdateLastName() {
		newContact.updateLastName("Keene");;
		assertTrue(newContact.getLastName().equals("Keene"));
	}
	
	@Test
	void testContactClassUpdateLastNameNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.updateLastName(null);}
		);
	}
	
	@Test
	void testContactClassUpdateLastNameToLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.updateLastName("Maximilliano");}
		);
	}
	
	// Test cases for phone
	
	@Test
	void testContactClassUpdatePhone() {
		newContact.updatePhone("4012557650");;
		assertTrue(newContact.getPhone().equals("4012557650"));
	}
	
	@Test
	void testContactClassUpdatePhoneNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.updatePhone(null);}
		);
	}
	
	@Test
	void testContactClassUpdatePhoneNotEqualToTen() {
		// This assertion phone over test over ten character
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.updatePhone("12345678910");}
		);
		// This assertion phone over test less than ten character
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.updatePhone("123456789");}
		);
	}
	
	// Test cases for address
	
	@Test
	void testContactClassUpdateAddress() {
		newContact.updateAddress("41 Austin Ave Greenville, RI");
		assertTrue(newContact.getAddress().equals("41 Austin Ave Greenville, RI"));
	}
	
	@Test
	void testContactClassUpdateAddressNotNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.updateAddress(null);}
		);
	}
	
	@Test
	void testContactClassUpdateAddressToLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			newContact.updateAddress("29 Char­gogg­a­gogg­man­chaugg­a­gogg­chau­bun­a­gung­a­maugg Road Webster, MA");}
		);
	}
}
