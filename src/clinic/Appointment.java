package clinic;

import java.time.LocalDateTime;

public class Appointment {
    private String id;
    private Treatment treatment;
    private Physiotherapist physiotherapist;
    private Patient patient;
    private String status; // booked, cancelled, attended
    private LocalDateTime time;  // Or any other type for time, such as Date


    public Appointment(String id, Treatment treatment, Physiotherapist physiotherapist, Patient patient) {
        this.id = id;
        this.treatment = treatment;
        this.physiotherapist = physiotherapist;
        this.patient = patient;
        this.status = "booked";
        this.time = LocalDateTime.now();
    }
    public LocalDateTime getTime() {
        return time;
    }


    public String getId() {
        return id;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public Physiotherapist getPhysiotherapist() {
        return physiotherapist;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getStatus() {
        return status;
    }

    public void changeStatus(String newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id + ", " + treatment + ", Patient: " + patient.getName() +
                ", Status: " + status;
    }

}

