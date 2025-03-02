//Christopher Fusaro
//February 6, 2025
//CS 320 Module Four Milestone
//CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentTest {

	Date start;
	Appointment newAppointment;
	

	@BeforeEach
	void setUp() {
		// Set up the test environment 
		start = new Date(2025-1900, 6, 8);
		newAppointment = new Appointment(
	             "129874", "Pick up kids.", start);
	}
 
	@Test
	void testAppointment() {
		// Tests the validity of the appointment class constructor
		assertTrue(newAppointment.getID().equals("129874"));
		assertTrue(newAppointment.getDescription().equals("Pick up kids."));
		assertTrue(newAppointment.getStart().equals(start));
	}
	
	@Test
	void testSetIDNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(
		             null, "Pick up kids.", start);
		});
	}
	
	@Test
	void testSetIDToLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(
					"0123455678911", "Pick up kids.", start);
		});
	}
	
	@Test
	void testSetDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(
					"129874", null, start);
		});
	}
	
	@Test
	void testSetDescriptionToLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(
					"129874", "Pick up kids. Take The to sports. Bring them home. Have them complete their homework. Have dinner and go to bed.", start);
		});
	}
	
	@Test
	void testSetStartNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(
					"129874", "Pick up kids.", null);
		});
	}
	
	@Test
	void testSetStartBeforeToday() {
		assertThrows(IllegalArgumentException.class, () -> {
			Date newStart = new Date(2025-1900, 1, 6);
			new Appointment(
					"129874", "Pick up kids.", newStart);
		});
	}
}


