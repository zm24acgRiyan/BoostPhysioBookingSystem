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

    public void cancelAppointment(String appointmentId) {
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getId().equals(appointmentId)) {
                found = true;
                if ("attended".equalsIgnoreCase(a.getStatus())) {
                    System.out.println("Appointment is Already Attended, cannot cancel");
                } else {
                    a.changeStatus("cancelled");
                    System.out.println("Appointment cancelled");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Appointment ID not found");
        }
    }


    public void attendAppointment(String appointmentId) {
        for (Appointment a : appointments) {
            if (a.getId().equals(appointmentId)) {
                a.changeStatus("attended");
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
