// Christopher Fusaro
// February 6, 2025
// CS 320 Module Four Milestone
// CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)

import java.util.Date;

public class Appointment {
    private String ID;
    private String description;
    private Date start;

    public Appointment(String ID, String description, Date start) {
        // Constructor for the Appointment class
        // Takes in an ID, description, and start date
        // Calls the setID, setDescription, and setStart methods
        // to ensure that the data meets the requirements
        this.setID(ID);
        this.setDescription(description);
        this.setStart(start);
    }

    private void setID(String ID) {
        // Checks to ensure that data meets requirements
        // Aside from generating the ID myself i was unsure how to enforce uniqueness
        // on the level so I used the AppointmentService class to do it
        if (ID == null || ID.length() > 10) {
            throw new IllegalArgumentException("Invalid id");
        } else {
            this.ID = ID;
        }
    }

    private void setDescription(String description) {
        // Checks to ensure that data meets requirements
        // Description must be less than 50 characters
        // Description must not be null
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        } else {
            this.description = description;
        }
    }

    private void setStart(Date start) {
        // Checks to ensure that data meets requirements
        // Start date must not be null
        // Start date must be after the current date
        Date today = new Date();
        if (start == null || start.before(today)) {
            throw new IllegalArgumentException("Invalid start date");
        } else {
            this.start = start;
        }
    }

    public String getID() {
        // Getter for the ID attribute
        return ID;
    }

    public String getDescription() {
        // Getter for the description attribute
        return description;
    }

    public Date getStart() {
        // Getter for the start attribute
        return start;
    }

}