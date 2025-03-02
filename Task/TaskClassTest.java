// Christopher Fusaro
// January 28, 2025
// CS 320 Module Four Milestone
// CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskClassTest {

	// Test case for constructor

	@Test
	void testTaskClass() {
		TaskClass taskClass = new TaskClass("129874","Pick up kids.", "Go to pick up kids at 4:00pm.");
		assertEquals(taskClass.getID(), "129874");
		assertTrue(taskClass.getName().equals("Pick up kids."));
		assertTrue(taskClass.getDescription().equals("Go to pick up kids at 4:00pm."));
	}

	// Test cases for ID

	@Test
	void testTaskClassIDNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new TaskClass(null, "Pick up kids.", "Go to pick up kids at 4:00pm.");}
		);
	}

	@Test
	void testTaskClassIDToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new TaskClass("1234567891011", "Pick up kids.", "Go to pick up kids at 4:00pm.");}
		);
	}

	// Test cases for name

	@Test
	void testTaskClassNameNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new TaskClass("129874", null, "Go to pick up kids at 4:00pm.");}
		);
	}

	@Test
	void testTaskClassNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new TaskClass("129874", "Go to the middle school to pick up both kids at 4:00pm.",
					"Go to pick up kids at 4:00pm.");}
		);
	}

	// Test cases for description

	@Test
	void testTaskClassDescriptionNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new TaskClass("129874", "Pick up kids.", null);}
		);
	}

	@Test
	void testTaskClassDescriptionToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new TaskClass("129874", "Pick up kids.",
					"Go to the middle school to pick up both kids at 4:00pm. The take them home and have them complete their homework. Prepare dinner for the family. Eat. Clean up from dinner. Have everyone shower before bed. Then go to sleep.");}
		);
	}
}

