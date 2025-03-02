// Christopher Fusaro
// January 28, 2025
// CS 320 Module Four Milestone
// CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskServiceTest {

	// Tests that TaskService class creates taskService object with an empty
	// list

	@Test
	void testTaskServiceList() {
		TaskService taskService = new TaskService();
		assertTrue(taskService.getTasks().isEmpty());
	}

	// Tests that TaskService class is able to add a single task to list

	@Test
	void testAddSingleTask() {
		TaskService taskService = new TaskService();
		TaskClass newTask = new TaskClass(
				"129874", "Pick up kids.", "Go to pick up kids at 4:00pm.");
		taskService.addTask(newTask);
		assertFalse(taskService.getTasks().isEmpty());
	}

	// Tests that TaskService class is able to add multiple tasks to list

	@Test
	void testAddMultipleTasks() {
		TaskService taskService = new TaskService();
		// First task
		TaskClass newTask1 = new TaskClass(
				"129874", "Pick up kids.", "Go to pick up kids at 4:00pm.");
		taskService.addTask(newTask1);
		// Second task
		TaskClass newTask2 = new TaskClass(
				"129875", "Pick up kids.", "Go to pick up kids at 4:00pm.");
		taskService.addTask(newTask2);
		// Third task
		TaskClass newTask3 = new TaskClass(
				"129876", "Pick up kids.", "Go to pick up kids at 4:00pm.");
		taskService.addTask(newTask3);
		assertTrue(taskService.getTasks().size() == 3);
	}

	// Tests that TaskService class is able to add a task an retrieve it from list

	@Test
	void testAddTaskAndRetrive() {
		TaskService taskService = new TaskService();
		TaskClass newTask = new TaskClass(
				"129874", "Pick up kids.", "Go to pick up kids at 4:00pm.");
		taskService.addTask(newTask);
		for (TaskClass task : taskService.getTasks()) {
			if (task.getID().equals("129874")) {
				System.out.println("task found");
				assertTrue(task.getID().equals("129874"));
				assertTrue(task.getName().equals("Pick up kids."));
				assertTrue(task.getDescription().equals("Go to pick up kids at 4:00pm."));
				break;
			}
		}
	}

	// Tests that TaskService class is only able add a task with a unique ID

	@Test
	void testUniqueIDAddTask() {
		assertThrows(IllegalArgumentException.class, () -> {
			TaskService taskService = new TaskService();
			TaskClass newTask = new TaskClass(
					"129874", "Pick up kids.", "Go to pick up kids at 4:00pm.");
			taskService.addTask(newTask);
			// Attempts to add the same task again which should have a conflict do to same
			// ID
			taskService.addTask(newTask);
		});
	}

	// Tests that TaskService class is able to delete task from list

	@Test
	void testDeleteTask() {
		TaskService taskService = new TaskService();
		TaskClass newTask = new TaskClass(
				"129874", "Pick up kids.", "Go to pick up kids at 4:00pm.");
		taskService.addTask(newTask);
		taskService.deleteTask("129874");
		assertTrue(taskService.getTasks().isEmpty());
	}

	// Tests that ContactService class is able to update contact firstName using ID

	@Test
	void testUpdateTaskName() {
		TaskService taskService = new TaskService();
		TaskClass newTask = new TaskClass(
				"129874", "Pick up kids.", "Go to pick up kids at 4:00pm.");
		taskService.addTask(newTask);
		taskService.updateTask("129874", "Get kids.", "Go to pick up kids at 4:00pm.");
		System.out.println("updateTask completed");
		for (TaskClass task : taskService.getTasks()) {
			if (task.getID().equals("129874")) {
				System.out.println("task found");
				System.out.println(task.getName());
				assertTrue(task.getName().equals("Get kids."));
				break;
			}
		}
	}

	// Tests that ContactService class is able to update contact lasttName using ID

	@Test
	void testUpdateTaskDescription() {
		TaskService taskService = new TaskService();
		TaskClass newTask = new TaskClass(
				"129874", "Pick up kids.", "Go to pick up kids at 4:00pm.");
		taskService.addTask(newTask);
		taskService.updateTask("129874", "Pick up kids.", "Get kids.");
		System.out.println("updateTask completed");
		for (TaskClass task : taskService.getTasks()) {
			if (task.getID().equals("129874")) {
				System.out.println("task found");
				System.out.println(task.getDescription());
				assertTrue(task.getDescription().equals("Get kids."));
				break;
			}
		}
	}
}
