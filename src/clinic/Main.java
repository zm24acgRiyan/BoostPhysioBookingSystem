package clinic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        Validations v = new Validations();

        // Sample physiotherapists
        Physiotherapist helen = new Physiotherapist("P001", "Helen Smith", "123 London St", "0123456789");
        helen.addExpertise("Massage");
        helen.addExpertise("Rehabilitation");
        Physiotherapist john = new Physiotherapist("P002", "Jupiter Brihas", "456 Main Rd", "0987654321");
        john.addExpertise("Acupuncture");

        // Sample treatments
        Treatment t1 = new Treatment("Massage", "Massage", LocalDateTime.of(2025, 5, 1, 10, 0), 60);
        Treatment t2 = new Treatment("Acupuncture", "Acupuncture", LocalDateTime.of(2025, 5, 2, 11, 0), 60);
        helen.addTreatment(t1);
        john.addTreatment(t2);

        system.addPhysiotherapist(helen);
        system.addPhysiotherapist(john);

        // Sample patients
        Patient alice = new Patient("001", "Alice Brown", "789 High St", "0778899001");
        Patient bob = new Patient("002", "Bob Green", "101 Maple Ave", "0778899002");

        system.addPatient(alice);
        system.addPatient(bob);

        // Console interface
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Boost Physio Clinic ===");
            System.out.println("1. Add patient");
            System.out.println("2. View patients");
            System.out.println("3. View Physiotherapists");
            System.out.println("4. Remove patient");
            System.out.println("5. Book appointment");
            System.out.println("6. Cancel appointment");
            System.out.println("7. Attend appointment");
            System.out.println("8. Print report");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    if(id.length() <= 2 || id.length() >= 4 && v.validateNumber(id) == false) {
                        System.out.println("Enter valid ID and must contain 3 digits");
                        break;}

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    String regexOfName = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";

                    if (!name.matches(regexOfName)) {
                        System.out.println("Enter valid name!");
                        break;
                    }

                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();

                    if(phone.length() <=9 || phone.length() >= 11 && v.validateNumber(phone) == false)
                    {
                        System.out.println("Enter valid phone number and must be 10 digits long");
                        break;
                    }

                    system.addPatient(new Patient(id, name, address, phone));
                    System.out.print("New patient added");
                    break;

                case 2:
                    System.out.println("Patients Details");
                    system.viewPatients();
                    viewPhysiotherapists(system.getPhysios()); // fixed this line
                    break;

                case 3:
                    System.out.println("Physiotherapists Details");
                    viewPhysiotherapists(system.getPhysios()); // fixed this line
                    break;

                case 4:
                    System.out.print("Enter patient ID to remove: ");
                    String rid = scanner.nextLine();
                    system.removePatient(rid);
                    break;
                case 5:
                    System.out.print("Enter patient ID: ");
                    String pid = scanner.nextLine();
                    Patient p = system.getPatients().stream()
                        .filter(x -> x.getId().equals(pid)).findFirst().orElse(null);
                    if (p == null) {
                        System.out.println("Patient not found.");
                        break;
                    }
                    System.out.print("Enter physio name: ");
                    String pname = scanner.nextLine();
                    Physiotherapist ph = system.getPhysios().stream()
                        .filter(x -> x.getName().equalsIgnoreCase(pname)).findFirst().orElse(null);
                    if (ph == null) {
                        System.out.println("Physio not found.");
                        break;
                    }
                    for (Treatment t : ph.getTreatments()) {
                        System.out.println("Treatment: " + t);
                    }
                    System.out.print("Book which treatment (name): ");
                    String tname = scanner.nextLine();
                    Treatment selected = ph.getTreatments().stream()
                        .filter(x -> x.getName().equalsIgnoreCase(tname)).findFirst().orElse(null);
                    if (selected == null) {
                        System.out.println("Treatment not found.");
                        break;
                    }
                    String aid = UUID.randomUUID().toString().substring(0, 8);
                    system.bookAppointment(new Appointment(aid, selected, ph, p));
                    System.out.println("Booked appointment with ID: " + aid);
                    break;
                case 6:
                    System.out.print("Enter appointment ID to cancel: ");
                    String cid = scanner.nextLine();
                    system.cancelAppointment(cid);
                    break;

                case 7:
                    System.out.print("Enter appointment ID to attend: ");
                    String atid = scanner.nextLine();
                    system.attendAppointment(atid);
                    break;
                case 8:
                    system.printReport();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }

        }
    }
    public static void viewPhysiotherapists(List<Physiotherapist> physiotherapists) {
        if (physiotherapists.isEmpty()) {
            System.out.println("No physiotherapists available.");
        } else {
            for (Physiotherapist p : physiotherapists) {
                System.out.println("ID: " + p.getId());
                System.out.println("Name: " + p.getName());
                System.out.println("Address: " + p.getAddress());
                System.out.println("Phone: " + p.getPhone());
                System.out.println("Expertise: " + String.join(", ", p.getExpertise()));
                System.out.println("Treatments: " + p.getTreatments().size());
                System.out.println("------------------------");
            }
        }
    }


}
