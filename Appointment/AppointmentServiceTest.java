//Christopher Fusaro
//February 6, 2025
//CS 320 Module Four Milestone
//CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	
	Date start;
	Appointment newAppointment1;
	Appointment newAppointment2;
	Appointment newAppointment3;
	AppointmentService appointmentService;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		// Set up the test environment 
		start = new Date(2025-1900, 6, 8);
		System.out.println(start);
		newAppointment1 = new Appointment(
	             "129871", "Pick up kids.", start);
		newAppointment2 = new Appointment(
	             "129872", "Pick up kids.", start);
		newAppointment3 = new Appointment(
	             "129873", "Pick up kids.", start);
		appointmentService = new AppointmentService();
	}
	

	@Test
	void testAppointmentServiceList() {
		System.out.println(start);
		System.out.println(appointmentService.getAppointments().size());
		assertTrue(appointmentService.getAppointments().isEmpty());
	}

	// Tests that appointmentService class is able to add a single appointment to list

	@Test
	void testAddsSingleAppointment() {
		appointmentService.addAppointment(newAppointment1);
		assertFalse(appointmentService.getAppointments().isEmpty());
	}

	// Tests that appointmentService class is able to add a single appointment to list

	@Test
	void testAddsMultipleAppointments() {
		appointmentService.addAppointment(newAppointment1);
		appointmentService.addAppointment(newAppointment2);
		appointmentService.addAppointment(newAppointment3);
		assertTrue(appointmentService.getAppointments().size() == 3);
	}
	
	// Tests that appointmentService class is only able to add appointments with unique IDs

	@Test
	void testAddsOnlyUniqueIDs() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(newAppointment1);
			appointmentService.addAppointment(newAppointment1);
		});
	}
	
	// Tests that appointmentService class is able to delete a single appointment from list

	@Test
	void testDeleteAppointment() {
		appointmentService.addAppointment(newAppointment1);
		appointmentService.deleteAppointment(newAppointment1.getID());
		assertTrue(appointmentService.getAppointments().isEmpty());
	}
}
