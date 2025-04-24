//package clinic;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//class BookingSystemTest {
//
//    @Test
//    void addPatient() {
//    }
//
//    @Test
//    void removePatient() {
//    }
//
//    @Test
//    void bookAppointment() {
//    }
//
//    @Test
//    void cancelAppointment() {
//    }
//
//    @Test
//    void attendAppointment() {
//    }
//}

package clinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BookingSystemTest {
    private BookingSystem bookingSystem;
    private Patient patient;
    private Physiotherapist physio;
    private Treatment treatment;
    private Appointment appointment;

    @BeforeEach
    void setUp() {
        bookingSystem = new BookingSystem();
        patient = new Patient("001", "Alice Brown", "789 High St", "0778899001");
        physio = new Physiotherapist("P001", "Helen Smith", "123 London St", "0123456789");
        treatment = new Treatment("Massage", "Physiotherapy", LocalDateTime.now(), 60);
        appointment = new Appointment("A001", treatment, physio, patient);

        physio.addTreatment(treatment);
        bookingSystem.addPhysiotherapist(physio);
    }

    @Test
    void addPatient() {
        // Test adding a new patient
        bookingSystem.addPatient(patient);
        List<Patient> patients = bookingSystem.getPatients();

        assertEquals(1, patients.size());
        assertEquals("001", patients.get(0).getId());
        assertEquals("Alice Brown", patients.get(0).getName());
    }

    @Test
    void removePatient() {
        // Add then remove a patient
        bookingSystem.addPatient(patient);
        assertFalse(bookingSystem.getPatients().isEmpty());

        bookingSystem.removePatient("001");
        assertTrue(bookingSystem.getPatients().isEmpty());

        // Test removing non-existent patient
        assertDoesNotThrow(() -> bookingSystem.removePatient("999"));
    }

    @Test
    void bookAppointment() {
        // First add the patient
        bookingSystem.addPatient(patient);

        // Test successful booking
        bookingSystem.bookAppointment(appointment);
        assertEquals(1, bookingSystem.getAppointments().size());

        // Test duplicate time slot prevention
        Treatment sameTimeTreatment = new Treatment("Acupuncture", "Physiotherapy",
                treatment.getDateTime(), 30);
        Appointment conflictingAppt = new Appointment("A002", sameTimeTreatment, physio, patient);
        physio.addTreatment(sameTimeTreatment);

        bookingSystem.bookAppointment(conflictingAppt);
        assertEquals(2, bookingSystem.getAppointments().size()); // Should not add duplicate
    }

    @Test
    void cancelAppointment() {
        bookingSystem.addPatient(patient);
        bookingSystem.bookAppointment(appointment);

        // Test successful cancellation
        bookingSystem.cancelAppointment("A001");
        assertEquals("cancelled", bookingSystem.getAppointments().get(0).getStatus());

        // Test cancelling non-existent appointment
        assertDoesNotThrow(() -> bookingSystem.cancelAppointment("INVALID_ID"));
    }

    @Test
    void attendAppointment() {
        bookingSystem.addPatient(patient);
        bookingSystem.bookAppointment(appointment);

        // Test marking as attended
        bookingSystem.attendAppointment("A001");
        assertEquals("attended", bookingSystem.getAppointments().get(0).getStatus());

        // Test attending non-existent appointment
        assertDoesNotThrow(() -> bookingSystem.attendAppointment("INVALID_ID"));
    }
}