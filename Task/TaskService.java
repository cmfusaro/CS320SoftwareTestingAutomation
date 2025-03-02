// Christopher Fusaro
// January 28, 2025
// CS 320 Module Four Milestone
// CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)

import java.util.List;
import java.util.ArrayList;

public class TaskService {
	private List<TaskClass> tasks;
	TaskClass newTask = new TaskClass(
			"129874", "Pick up kids.", "Go to pick up kids at 4:00pm.");

	// Constructor
	public TaskService() {
		this.tasks = new ArrayList<>();
	}

	// Getter
	public List<TaskClass> getTasks() {
		return this.tasks;
	}

	// Method for adding a new task to tasks list
	public void addTask(TaskClass newTask) {
		System.out.println("Entered addTask function");
		Boolean flag = false;

		// This check see if the list is empty and can bypass the loop to find if the ID
		// is unique
		if (this.tasks.isEmpty()) {
			this.tasks.add(newTask);
		} else {
			// loops through contacts and compares IDs for uniqueness before contact is
			// added
			for (int i = 0; i < this.tasks.size(); i++) {
				TaskClass contact = this.tasks.get(i);
				if (contact.getID().equals(newTask.getID())) {
					flag = true;
					throw new IllegalArgumentException("ID not unique");
				}
			}
			if (flag == false) {
				this.tasks.add(newTask);
			}
		}
		return;
	}

	// Method for deleting task from tasks list based on ID
	public void deleteTask(String selectedID) {
		System.out.println("delete function entered");
		boolean flag = false;
		for (TaskClass task : this.tasks) {
			if (task.getID().equals(selectedID)) {
				this.tasks.remove(task);
				System.out.println("task deleted");
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println("task ID not found");
			throw new IllegalArgumentException("ID not found");
		}
		return;
	}

	// Method for updating task attributes except ID, ID is used to locate task
	public void updateTask(String selectedID, String name, String description) {
		System.out.println("updateContact function entered");
		boolean flag = false;
		for (TaskClass task : this.tasks) {
			// We are checking for nulls just so not all fields need to be updated the rest
			// of the
			// requirements is handled at the object validation level.
			if (task.getID().equals(selectedID)) {
				System.out.println("task ID found");
				flag = true;
				if (name != null) {
					task.setName(name);
					System.out.println("name updated");
				}
				if (description != null) {
					task.setDescription(description);
					System.out.println("description updated");
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
