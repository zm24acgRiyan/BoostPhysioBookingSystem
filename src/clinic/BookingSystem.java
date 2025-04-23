//package clinic;
//
//import java.util.*;
//
//public class BookingSystem {
//    private List<Patient> patients;
//    private List<Physiotherapist> physios;
//    private List<Appointment> appointments;
//
//    public BookingSystem() {
//        this.patients = new ArrayList<>();
//        this.physios = new ArrayList<>();
//        this.appointments = new ArrayList<>();
//    }
//
//    public void addPatient(Patient patient) {
//        patients.add(patient);
//    }
//
//    public void viewPatients() {
//        // ANSI Escape codes for colors and styles
//        String reset = "\u001B[0m";
//        String bold = "\u001B[1m";
//        String green = "\u001B[32m";
//        String cyan = "\u001B[36m";
//        String yellow = "\u001B[33m";
//        String purple = "\u001B[35m";
//        String lightPurple = "\u001B[92m";
//
//        // Stylish header for the view
//        System.out.println(purple + bold + "╔══════════════════════════════════════════╗" + reset);
//        System.out.println(purple + "║ " + lightPurple + "📋 " + reset + bold + "Patient List" + reset + " " + purple);
//        System.out.println(purple + "╠══════════════════════════════════════════╣" + reset);
//
//        // Patient list with stylish formatting
//        int i = 1;
//        for (Patient patient : patients) {
//            System.out.println(purple + "║  " + green + (i++) + ". " + cyan + patient.id + "  " + reset + "| " +
//                    lightPurple + patient.name + reset + "  | " + yellow + patient.address + reset +
//                    "  | " + green + patient.phone + reset );
//        }
//
//        // Stylish footer
//        System.out.println(purple + "╚══════════════════════════════════════════╝" + reset);
//    }
//
//
//    public void removePatient(String patientId) {
//        //patients.removeIf(p -> p.getId().equals(patientId));
//        boolean removed = patients.removeIf(p -> p.getId().equals(patientId));
//
//        if (removed) {
//            System.out.println("Patient with ID " + patientId + " has been removed.");
//        } else {
//            System.out.println("Invalid patient ID: " + patientId);
//        }
//
////        for (Patient patient : patients) {
////            if (patient.id.equals(patientId)) {
////                patients.remove(patient);
////                System.out.print("Patient removed");
////                break;
////            }
////            else {
////                System.out.println("Patient not found");
////                break;
////            }
////        }
//    }
//
//    public void addPhysiotherapist(Physiotherapist physio) {
//        physios.add(physio);
//    }
//
//    public void bookAppointment(Appointment appointment) {
//        appointments.add(appointment);
//    }
//
//    // Method to cancel and release an appointment
//    public void cancelAppointment(String appointmentId) {
//        boolean found = false;
//        for (Appointment a : appointments) {
//            if (a.getId().equals(appointmentId)) {
//                found = true;
//                if ("attended".equalsIgnoreCase(a.getStatus())) {
//                    System.out.println("Appointment is already attended, cannot cancel");
//                } else {
//                    a.changeStatus("cancelled");
//                    releaseAppointment(a); // Custom method to release the slot
//                    System.out.println("Appointment cancelled and slot released");
//                }
//                break;
//            }
//        }
//        if (!found) {
//            System.out.println("Appointment ID not found");
//        }
//    }
//    public void changeAppointment(String oldAppointmentId, Appointment newAppointment) {
//        boolean found = false;
//        for (Appointment a : appointments) {
//            if (a.getId().equals(oldAppointmentId)) {
//                found = true;
//                if ("attended".equalsIgnoreCase(a.getStatus())) {
//                    System.out.println("Appointment is already attended, cannot change");
//                } else {
//                    a.changeStatus("cancelled");
//                    releaseAppointment(a);
//
//                    // Generate new appointment ID before booking
//                    String newId = generateAppointmentId();
//                    newAppointment.setId(newId);
//
//                    appointments.add(newAppointment); // Re-book the new appointment
//                    System.out.println("Appointment changed: Old cancelled, new booked with ID: " + newId);
//                }
//                break;
//            }
//        }
//        if (!found) {
//            System.out.println("Old Appointment ID not found");
//        }
//    }
//
//    private void releaseAppointment(Appointment appointment) {
//        // Example logic to release the slot
//        System.out.println("Releasing slot for appointment ID: " + appointment.getId());
//    }
//
//
//    // Generates a unique appointment ID based on current time
//    private String generateAppointmentId() {
//        return "APT-" + System.currentTimeMillis();
//    }
//
//
//    public void attendAppointment(String appointmentId) {
//        for (Appointment a : appointments) {
//            if (a.getId().equals(appointmentId)) {
//                a.changeStatus("attended");
//                System.out.println("Appointment Has been Attended,Thank you for Visiting!!!");
//                break;
//            }
//        }
//    }
//
//    public void printReport() {
//        // ANSI escape codes for styling and color
//        String reset = "\u001B[0m";
//        String bold = "\u001B[1m";
//        String underline = "\u001B[4m";
//        String green = "\u001B[32m";
//        String yellow = "\u001B[33m";
//        String blue = "\u001B[34m";
//        String purple = "\u001B[35m";
//        String cyan = "\u001B[36m";
//
//        Map<String, Integer> attendedCount = new HashMap<>();
//
//        // Start with a nice title for the report
//        System.out.println(purple + bold + "===== Treatment Appointments Report =====" + reset);
//        System.out.println(green + underline + "Treatment Appointments by Physiotherapist:" + reset);
//
//        // Print out each appointment in a clear, structured format
//        for (Appointment a : appointments) {
//            System.out.println(blue + "Physiotherapist: " + cyan + a.getPhysiotherapist().getName() + reset +
//                    ", " + blue + "Treatment: " + cyan + a.getTreatment().getName() + reset +
//                    ", " + blue + "Patient: " + cyan + a.getPatient().getName() + reset +
//                    ", " + blue + "Time: " + cyan + a.getTime() + reset +  // Assuming getTime() returns a formatted string
//                    ", " + blue + "Status: " + cyan + a.getStatus() + reset);
//
//            if (a.getStatus().equalsIgnoreCase("attended")) {
//                String physioName = a.getPhysiotherapist().getName();
//                attendedCount.put(physioName, attendedCount.getOrDefault(physioName, 0) + 1);
//            }
//        }
//
//        // Heading for the physiotherapist attendance count
//        System.out.println("\n" + yellow + underline + "Physiotherapists by number of attended appointments:" + reset);
//
//        // Sorting and displaying the attended count
//        attendedCount.entrySet().stream()
//                .sorted((a, b) -> b.getValue() - a.getValue())
//                .forEach(entry -> System.out.println(purple + entry.getKey() + reset + ": " + green + entry.getValue() + reset));
//    }
//
//    // Getters
//    public List<Patient> getPatients() {
//        return patients;
//    }
//
//    public List<Physiotherapist> getPhysios() {
//        return physios;
//    }
//
//    public List<Appointment> getAppointments() {
//        return appointments;
//
//
//    }
//}


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
        // ANSI Escape codes for colors and styles
        String reset = "\u001B[0m";
        String bold = "\u001B[1m";
        String green = "\u001B[32m";
        String cyan = "\u001B[36m";
        String yellow = "\u001B[33m";
        String purple = "\u001B[35m";
        String lightPurple = "\u001B[92m";

        System.out.println(purple + bold + "╔══════════════════════════════════════════╗" + reset);
        System.out.println(purple + "║ " + lightPurple + "📋 " + reset + bold + "Patient List" + reset + " " + purple);
        System.out.println(purple + "╠══════════════════════════════════════════╣" + reset);

        int i = 1;
        for (Patient patient : patients) {
            System.out.println(purple + "║  " + green + (i++) + ". " + cyan + patient.id + "  " + reset + "| " +
                    lightPurple + patient.name + reset + "  | " + yellow + patient.address + reset +
                    "  | " + green + patient.phone + reset );
        }

        System.out.println(purple + "╚══════════════════════════════════════════╝" + reset);
    }

    public void removePatient(String patientId) {
        boolean removed = patients.removeIf(p -> p.getId().equals(patientId));
        if (removed) {
            System.out.println("Patient with ID " + patientId + " has been removed.");
        } else {
            System.out.println("Invalid patient ID: " + patientId);
        }
    }

    public void addPhysiotherapist(Physiotherapist physio) {
        physios.add(physio);
    }

    public void bookAppointment(Appointment appointment) {
        // Check if the patient already has an appointment at the same time
        for (Appointment a : appointments) {
            if (a.getPatient().getId().equals(appointment.getPatient().getId()) &&
                    a.getTime().equals(appointment.getTime()) &&
                    !a.getStatus().equalsIgnoreCase("cancelled")) {
                System.out.println("Patient already has an appointment at this time.");
                return;
            }
        }

        appointments.add(appointment);

        // Remove the booked treatment from the physiotherapist's list to prevent reuse
        appointment.getPhysiotherapist().getTreatments().remove(appointment.getTreatment());

        System.out.println("Appointment booked successfully.");
    }

    public void cancelAppointment(String appointmentId) {
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getId().equals(appointmentId)) {
                found = true;
                if ("attended".equalsIgnoreCase(a.getStatus())) {
                    System.out.println("Appointment is already attended, cannot cancel");
                } else {
                    a.changeStatus("cancelled");
                    releaseAppointment(a);
                    System.out.println("Appointment cancelled and slot released");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Appointment ID not found");
        }
    }

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

                    String newId = generateAppointmentId();
                    newAppointment.setId(newId);

                    appointments.add(newAppointment);
                    newAppointment.getPhysiotherapist().getTreatments().remove(newAppointment.getTreatment());
                    System.out.println("Appointment changed: Old cancelled, new booked with ID: " + newId);
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Old Appointment ID not found");
        }
    }

    private void releaseAppointment(Appointment appointment) {
        System.out.println("Releasing slot for appointment ID: " + appointment.getId());
    }

    private String generateAppointmentId() {
        return "APT-" + System.currentTimeMillis();
    }

    public void attendAppointment(String appointmentId) {
        for (Appointment a : appointments) {
            if (a.getId().equals(appointmentId)) {
                a.changeStatus("attended");
                System.out.println("Appointment Has been Attended, Thank you for Visiting!!!");
                break;
            }
        }
    }

    public void printReport() {
        // [Omitted for brevity, unchanged from original]
            // ANSI escape codes for styling and color
            String reset = "\u001B[0m";
            String bold = "\u001B[1m";
            String underline = "\u001B[4m";
            String green = "\u001B[32m";
            String yellow = "\u001B[33m";
            String blue = "\u001B[34m";
            String purple = "\u001B[35m";
            String cyan = "\u001B[36m";

            Map<String, Integer> attendedCount = new HashMap<>();

            // Start with a nice title for the report
            System.out.println(purple + bold + "===== Treatment Appointments Report =====" + reset);
            System.out.println(green + underline + "Treatment Appointments by Physiotherapist:" + reset);

            // Print out each appointment in a clear, structured format
            for (Appointment a : appointments) {
                System.out.println(blue + "Physiotherapist: " + cyan + a.getPhysiotherapist().getName() + reset +
                        ", " + blue + "Treatment: " + cyan + a.getTreatment().getName() + reset +
                        ", " + blue + "Patient: " + cyan + a.getPatient().getName() + reset +
                        ", " + blue + "Time: " + cyan + a.getTime() + reset +  // Assuming getTime() returns a formatted string
                        ", " + blue + "Status: " + cyan + a.getStatus() + reset);

                if (a.getStatus().equalsIgnoreCase("attended")) {
                    String physioName = a.getPhysiotherapist().getName();
                    attendedCount.put(physioName, attendedCount.getOrDefault(physioName, 0) + 1);
                }
            }

            // Heading for the physiotherapist attendance count
            System.out.println("\n" + yellow + underline + "Physiotherapists by number of attended appointments:" + reset);

            // Sorting and displaying the attended count
            attendedCount.entrySet().stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .forEach(entry -> System.out.println(purple + entry.getKey() + reset + ": " + green + entry.getValue() + reset));
        }


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
