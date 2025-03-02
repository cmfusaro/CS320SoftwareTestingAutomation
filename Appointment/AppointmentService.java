// Christopher Fusaro
// February 6, 2025
// CS 320 Module Four Milestone
// CS-320-12209-M01 Software Test, Automation QA 2025 C-1 (Jan - Mar)

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private List<Appointment> appointments;

    // Constructor
    public AppointmentService() {
        this.appointments = new ArrayList<>();
    }

    // Getter
    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    // Method for adding a new appointment to appointments list
    public void addAppointment(Appointment newAppointment) {
        Boolean flag = false;
        // This check see if the list is empty and can bypass the loop to find if the ID
        // is unique
        if (this.appointments.isEmpty()) {
            this.appointments.add(newAppointment);
        } else {
            // loops through appointments and compares IDs for uniqueness before appointment
            // is
            // added
            for (Appointment appointment : this.appointments) {
                if (appointment.getID().equals(newAppointment.getID())) {
                    flag = true;
                    throw new IllegalArgumentException("ID not unique");
                }
            }
            if (flag == false) {
                this.appointments.add(newAppointment);
            }
        }
        return;
    }

    // Method for deleting appointment from appointments list based on ID
    public void deleteAppointment(String selectedID) {
        System.out.println("delete function entered");
        boolean flag = false;
        for (Appointment appointment : this.appointments) {
            if (appointment.getID().equals(selectedID)) {
                this.appointments.remove(appointment);
                System.out.println("appointment deleted");
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("appointment ID not found");
            throw new IllegalArgumentException("ID not found");
        }
        return;
    }

}