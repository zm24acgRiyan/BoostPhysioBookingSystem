package clinic;

import java.util.*;

public class BookingSystem {
    private List<Patient> patients;
    private List<Physiotherapist> physios;
    private List<Appointment> appointments;

    public BookingSystem() {
        this.patients = new ArrayList<>();
        this.physios = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void viewPatients() {
        int i = 1;
        for (Patient patient : patients) {
            System.out.println((i++) + ") " + patient.id + " | " + patient.name + " | " + patient.address + " | " + patient.phone);
        }
    }

    public void removePatient(String patientId) {
        //patients.removeIf(p -> p.getId().equals(patientId));
        boolean removed = patients.removeIf(p -> p.getId().equals(patientId));

        if (removed) {
            System.out.println("Patient with ID " + patientId + " has been removed.");
        } else {
            System.out.println("Invalid patient ID: " + patientId);
        }

//        for (Patient patient : patients) {
//            if (patient.id.equals(patientId)) {
//                patients.remove(patient);
//                System.out.print("Patient removed");
//                break;
//            }
//            else {
//                System.out.println("Patient not found");
//                break;
//            }
//        }
    }

    public void addPhysiotherapist(Physiotherapist physio) {
        physios.add(physio);
    }

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Method to cancel and release an appointment
    public void cancelAppointment(String appointmentId) {
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getId().equals(appointmentId)) {
                found = true;
                if ("attended".equalsIgnoreCase(a.getStatus())) {
                    System.out.println("Appointment is already attended, cannot cancel");
                } else {
                    a.changeStatus("cancelled");
                    releaseAppointment(a); // Custom method to release the slot
                    System.out.println("Appointment cancelled and slot released");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Appointment ID not found");
        }
    }

    // Method to change a booking (cancel old and rebook new)
    public void changeAppointment(String oldAppointmentId, Appointment newAppointment) {
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getId().equals(oldAppointmentId)) {
                found = true;
                if ("attended".equalsIgnoreCase(a.getStatus())) {
                    System.out.println("Appointment is already attended, cannot change");
                } else {
                    a.changeStatus("cancelled");
                    releaseAppointment(a);
                    appointments.add(newAppointment); // Re-book the new appointment
                    System.out.println("Appointment changed: Old cancelled, new booked");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Old Appointment ID not found");
        }
    }

    // Example stub for releasing a slot
    private void releaseAppointment(Appointment appointment) {
        // Implement your logic here for releasing the appointment slot
        // e.g., make the time slot available again for others to book
    }



    public void attendAppointment(String appointmentId) {
        for (Appointment a : appointments) {
            if (a.getId().equals(appointmentId)) {
                a.changeStatus("attended");
                System.out.println("Appointment Has been Attended,Thank you for Visiting!!!");
                break;
            }
        }
    }

    public void printReport() {
        Map<String, Integer> attendedCount = new HashMap<>();

        System.out.println("Treatment Appointments by Physiotherapist:");
        for (Appointment a : appointments) {
            System.out.println("Physiotherapist: " + a.getPhysiotherapist().getName() +
                    ", Treatment: " + a.getTreatment().getName() +
                    ", Patient: " + a.getPatient().getName() +
                    ", Time: " + a.getTime() +   // This works if getTime() exists
                    ", Status: " + a.getStatus());

            if (a.getStatus().equalsIgnoreCase("attended")) {
                String physioName = a.getPhysiotherapist().getName();
                attendedCount.put(physioName, attendedCount.getOrDefault(physioName, 0) + 1);
            }
        }

        System.out.println("\nPhysiotherapists by number of attended appointments:");
        attendedCount.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    // Getters
    public List<Patient> getPatients() {
        return patients;
    }

    public List<Physiotherapist> getPhysios() {
        return physios;
    }

    public List<Appointment> getAppointments() {
        return appointments;


    }
}
