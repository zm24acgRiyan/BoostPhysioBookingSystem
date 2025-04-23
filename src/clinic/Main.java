package clinic;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        Scanner scanner = new Scanner(System.in);

        Validations v = new Validations();
        // Declare ph at the class level
        Physiotherapist ph = null; // Initialize ph as null


        // Sample physiotherapists
        // Create physiotherapists
        Physiotherapist helen = new Physiotherapist("P001", "Helen Smith", "123 London St", "0123456789");
        helen.addExpertise("Physiotherapy");
        helen.addExpertise("Rehabilitation");

        Physiotherapist john = new Physiotherapist("P002", "Jupiter Brihas", "456 Main Rd", "0987654321");
        john.addExpertise("Osteopathy");

        Physiotherapist emily = new Physiotherapist("P003", "Emily Clarke", "789 Elm Ave", "0171234567");
        emily.addExpertise("Osteopathy");
        emily.addExpertise("Rehabilitation");

        Physiotherapist david = new Physiotherapist("P004", "David Lee", "321 Maple Ln", "0154321987");
        david.addExpertise("Physiotherapy");
        david.addExpertise("Osteopathy");

        Physiotherapist nina = new Physiotherapist("P005", "Nina Patel", "654 Birch St", "0134567890");
        nina.addExpertise("Physiotherapy");


// Assign treatments to physiotherapists for 4 weeks
        // Week 1
        // Week 1
        helen.addTreatment(new Treatment("Massage", "Massage", LocalDateTime.of(2025, 5, 5, 10, 0), 60)); // OK
        john.addTreatment(new Treatment("Acupuncture", "Acupuncture", LocalDateTime.of(2025, 5, 6, 11, 0), 60)); // OK
        emily.addTreatment(new Treatment("Pool rehabilitation", "Pool rehabilitation", LocalDateTime.of(2025, 5, 7, 14, 0), 60)); // OK (changed from "Rehabilitation")
        david.addTreatment(new Treatment("Neural mobilisation", "Neural mobilisation", LocalDateTime.of(2025, 5, 8, 9, 0), 45)); // OK
        nina.addTreatment(new Treatment("Massage", "Massage", LocalDateTime.of(2025, 5, 9, 13, 0), 60)); // changed from "Pool rehabilitation" to "Massage"

// Week 2
        helen.addTreatment(new Treatment("Pool rehabilitation", "Pool rehabilitation", LocalDateTime.of(2025, 5, 12, 9, 0), 60)); // OK
        john.addTreatment(new Treatment("Acupuncture", "Acupuncture", LocalDateTime.of(2025, 5, 13, 10, 0), 60)); // OK
        emily.addTreatment(new Treatment("Osteopathy", "Osteopathy", LocalDateTime.of(2025, 5, 14, 15, 0), 60)); // OK
        david.addTreatment(new Treatment("Neural mobilisation", "Neural mobilisation", LocalDateTime.of(2025, 5, 15, 8, 30), 60)); // changed from "Physiotherapy"
        nina.addTreatment(new Treatment("Massage", "Massage", LocalDateTime.of(2025, 5, 16, 12, 0), 60)); // changed from "Mobilisation of the spine and joints"

// Week 3
        helen.addTreatment(new Treatment("Massage", "Massage", LocalDateTime.of(2025, 5, 19, 10, 0), 60)); // OK
        john.addTreatment(new Treatment("Acupuncture", "Acupuncture", LocalDateTime.of(2025, 5, 20, 11, 30), 60)); // OK
        emily.addTreatment(new Treatment("Pool rehabilitation", "Pool rehabilitation", LocalDateTime.of(2025, 5, 21, 13, 30), 60)); // OK
        david.addTreatment(new Treatment("Neural mobilisation", "Neural mobilisation", LocalDateTime.of(2025, 5, 22, 10, 0), 45)); // OK
        nina.addTreatment(new Treatment("Massage", "Massage", LocalDateTime.of(2025, 5, 23, 14, 0), 60)); // changed from "Pool rehabilitation"

// Week 4
        helen.addTreatment(new Treatment("Pool rehabilitation", "Pool rehabilitation", LocalDateTime.of(2025, 5, 26, 11, 0), 60)); // OK
        john.addTreatment(new Treatment("Acupuncture", "Acupuncture", LocalDateTime.of(2025, 5, 27, 9, 0), 60)); // OK
        emily.addTreatment(new Treatment("Osteopathy", "Osteopathy", LocalDateTime.of(2025, 5, 28, 15, 30), 60)); // OK
        david.addTreatment(new Treatment("Mobilisation of the spine and joints", "Mobilisation of the spine and joints", LocalDateTime.of(2025, 5, 29, 8, 45), 60)); // OK
        nina.addTreatment(new Treatment("Massage", "Massage", LocalDateTime.of(2025, 5, 30, 13, 0), 60)); // changed from "Mobilisation of the spine and joints"

        // Add physiotherapists to the system
        system.addPhysiotherapist(helen);
        system.addPhysiotherapist(john);
        system.addPhysiotherapist(emily);
        system.addPhysiotherapist(david);
        system.addPhysiotherapist(nina);

        // Sample patients
        Patient alice = new Patient("001", "Alice Brown", "789 High St", "0778899001");
        Patient bob = new Patient("002", "Bob Green", "101 Maple Ave", "0778899002");
        Patient rajesh = new Patient("003", "Rajesh Kumar", "22 B-Block, London", "0998877665");
        Patient priya = new Patient("004", "Priya Sharma", "56 C-Block, Manchester", "0998877666");
        Patient ananya = new Patient("005", "Ananya Patel", "34 Oak Rd, Birmingham", "0998877667");
        Patient amit = new Patient("006", "Amit Verma", "12 Green Park, Leeds", "0998877668");
        Patient neha = new Patient("007", "Neha Gupta", "78 Sadar Bazar, Glasgow", "0998877669");
        Patient vikram = new Patient("008", "Vikram Reddy", "44 MG Rd, Liverpool", "0998877670");
        Patient swati = new Patient("009", "Swati Iyer", "23 South St, Edinburgh", "0998877671");
        Patient siddharth = new Patient("010", "Siddharth Mehta", "89 East Ave, Bristol", "0998877672");
        Patient sonal = new Patient("011", "Sonal Kapoor", "56 Royal Road, Sheffield", "0998877673");
        Patient ajay = new Patient("012", "Ajay Singh", "101 West Lane, Cambridge", "0998877674");
        Patient manisha = new Patient("013", "Manisha Joshi", "76 Hilltop Road, Oxford", "0998877675");
        Patient rohit = new Patient("014", "Rohit Kumar", "35 Main St, Newcastle", "0998877676");
        Patient deepika = new Patient("015", "Deepika Thakur", "11 Bridge St, Cardiff", "0998877677");

        system.addPatient(alice);
        system.addPatient(bob);
        system.addPatient(rajesh);
        system.addPatient(priya);
        system.addPatient(ananya);
        system.addPatient(amit);
        system.addPatient(neha);
        system.addPatient(vikram);
        system.addPatient(swati);
        system.addPatient(siddharth);
        system.addPatient(sonal);
        system.addPatient(ajay);
        system.addPatient(manisha);
        system.addPatient(rohit);
        system.addPatient(deepika);

        // ANSI Escape codes for colors and styles
        String reset = "\u001B[0m";
        String bold = "\u001B[1m";
        String underline = "\u001B[4m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";
        String purple = "\u001B[35m";
        String cyan = "\u001B[36m";
        String lightGreen = "\u001B[92m";
        String lightPurple = "\u001B[35m";

        // Console interface with more stylistic elements
        while (true) {
            System.out.println(blue + bold + "╔══════════════════════════════════╗" + reset);
            System.out.println(blue + "║  " + green + "Boost Physio Clinic" + reset + " ║");
            System.out.println(blue + "╠══════════════════════════════════╣" + reset);
            System.out.println(blue + "║  " + cyan + "1. Add patient" + reset + "              ║");
            System.out.println(blue + "║  " + cyan + "2. View patients" + reset + "            ║");
            System.out.println(blue + "║  " + cyan + "3. View Physiotherapists" + reset + "    ║");
            System.out.println(blue + "║  " + cyan + "4. Remove patient" + reset + "           ║");
            System.out.println(blue + "║  " + cyan + "5. Book appointment" + reset + "         ║");
            System.out.println(blue + "║  " + cyan + "6. Cancel appointment" + reset + "       ║");
            System.out.println(blue + "║  " + cyan + "7. Change an appointment" + reset + "    ║");
            System.out.println(blue + "║  " + cyan + "8. Attend appointment" + reset + "       ║");
            System.out.println(blue + "║  " + cyan + "9. Print report" + reset + "             ║");
            System.out.println(blue + "║  " + yellow + "0. Exit" + reset + "                   ║");
            System.out.println(blue + "╠══════════════════════════════════╣" + reset);
            System.out.print(blue + "║ " + green + "Choose an option: " + reset);

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
                    System.out.println("1. Search by area of expertise");
                    System.out.println("2. Search by physiotherapist name");
                    System.out.print("Choose option: ");
                    int choice = Integer.parseInt(scanner.nextLine());

                //    Physiotherapist ph = null;

                    if (choice == 1) {
                        // Sub-options for expertise
                        System.out.println("Choose area of expertise:");
                        System.out.println("1. Physiotherapy");
                        System.out.println("2. Rehabilitation");
                        System.out.println("3. Osteopathy");
                        System.out.print("Enter option: ");
                        int expertiseChoice = Integer.parseInt(scanner.nextLine());

                        String expertise = switch (expertiseChoice) {
                            case 1 -> "Physiotherapy";
                            case 2 -> "Rehabilitation";
                            case 3 -> "Osteopathy";
                            default -> null;
                        };

                        if (expertise == null) {
                            System.out.println("Invalid expertise option.");
                            break;
                        }

                        // Filter physiotherapists with that expertise
                        List<Physiotherapist> physios = system.getPhysios().stream()
                                .filter(x -> x.getExpertise().stream()
                                        .anyMatch(e -> e.equalsIgnoreCase(expertise)))
                                .toList();

                        if (physios.isEmpty()) {
                            System.out.println("No physiotherapists found with that expertise.");
                            break;
                        }

                        // Display physios and their treatments
                        System.out.println("Available physiotherapists and their treatments:");
                        int physioIndex = 1;
                        Map<Integer, Physiotherapist> physioMap = new HashMap<>();
                        for (Physiotherapist x : physios) {
                            System.out.println(physioIndex + ". " + x.getName());
                            List<Treatment> treatments = x.getTreatments();
                            if (treatments.isEmpty()) {
                                System.out.println("   No treatments available.");
                            } else {
                                for (int i = 0; i < treatments.size(); i++) {
                                    Treatment t = treatments.get(i);
                                    System.out.println("   [" + (i + 1) + "] " + t.getName() + " on " +
                                            t.getDateTime().toLocalDate() + " at " + t.getDateTime().toLocalTime());
                                }
                            }
                            physioMap.put(physioIndex, x);
                            physioIndex++;
                        }

                        System.out.print("Select physiotherapist by number: ");
                        int physioSelection = Integer.parseInt(scanner.nextLine());
                        ph = physioMap.get(physioSelection);
                        if (ph == null || ph.getTreatments().isEmpty()) {
                            System.out.println("Invalid selection or no treatments.");
                            break;
                        }

                        System.out.print("Select treatment by number: ");
                        int treatmentSelection = Integer.parseInt(scanner.nextLine());
                        if (treatmentSelection < 1 || treatmentSelection > ph.getTreatments().size()) {
                            System.out.println("Invalid treatment choice.");
                            break;
                        }

                        Treatment selected = ph.getTreatments().get(treatmentSelection - 1);

                        // Get patient
                        System.out.print("Enter patient ID: ");
                        String pid = scanner.nextLine();
                        Patient p = system.getPatients().stream()
                                .filter(x -> x.getId().equals(pid)).findFirst().orElse(null);
                        if (p == null) {
                            System.out.println("Patient not found.");
                            break;
                        }

                        String aid = UUID.randomUUID().toString().substring(0, 8);
                        system.bookAppointment(new Appointment(aid, selected, ph, p));
                        System.out.println("Booked appointment with ID: " + aid);

                    } else if (choice == 2) {
                        List<Physiotherapist> allPhysios = system.getPhysios();
                        if (allPhysios.isEmpty()) {
                            System.out.println("No physiotherapists available.");
                            break;
                        }

                        System.out.println("Available physiotherapists:");
                        Map<Integer, Physiotherapist> physioMap = new HashMap<>();
                        int index = 1;
                        for (Physiotherapist x : allPhysios) {
                            System.out.println(index + ". " + x.getName());
                            physioMap.put(index, x);
                            index++;
                        }

                        System.out.print("Select physiotherapist by number: ");
                        int physioSelection = Integer.parseInt(scanner.nextLine());
                        ph = physioMap.get(physioSelection);

                        if (ph == null) {
                            System.out.println("Invalid selection.");
                            break;
                        }


                        if (ph == null) {
                            System.out.println("Physiotherapist not found.");
                            break;
                        }

                        if (ph.getTreatments().isEmpty()) {
                            System.out.println("No treatments available from this physiotherapist.");
                            break;
                        }

                        // Display treatments
                        System.out.println("Available treatments:");
                        for (int i = 0; i < ph.getTreatments().size(); i++) {
                            Treatment t = ph.getTreatments().get(i);
                            System.out.println((i + 1) + ". " + t.getName() + " on " +
                                    t.getDateTime().toLocalDate() + " at " + t.getDateTime().toLocalTime());
                        }

                        System.out.print("Select treatment by number: ");
                        int treatmentSelection = Integer.parseInt(scanner.nextLine());
                        if (treatmentSelection < 1 || treatmentSelection > ph.getTreatments().size()) {
                            System.out.println("Invalid treatment choice.");
                            break;
                        }

                        Treatment selected = ph.getTreatments().get(treatmentSelection - 1);

                        // Get patient
                        System.out.print("Enter patient ID: ");
                        String pid = scanner.nextLine();
                        Patient p = system.getPatients().stream()
                                .filter(x -> x.getId().equals(pid)).findFirst().orElse(null);
                        if (p == null) {
                            System.out.println("Patient not found.");
                            break;
                        }

                        String aid = UUID.randomUUID().toString().substring(0, 8);
                        system.bookAppointment(new Appointment(aid, selected, ph, p));
                        System.out.println("Booked appointment with ID: " + aid);

                    } else {
                        System.out.println("Invalid choice.");
                    }

                    break;


                case 6:
                    System.out.print("Enter appointment ID to cancel: ");
                    String cid = scanner.nextLine();
                    system.cancelAppointment(cid);
                    break;

                case 7:
                    System.out.println("Change an appointment:");

                    // Ask for the old appointment ID
                    System.out.print("Enter the old appointment ID: ");
                    String oldAppointmentId = scanner.nextLine();

                    // If ph is already null, ask for physiotherapist name for the new appointment
                    if (ph == null) {
                        System.out.print("Enter the physiotherapist name for the new appointment: ");
                        String physioName = scanner.nextLine();

                        // Fetch the physiotherapist
                        ph = system.getPhysios().stream()
                                .filter(x -> x.getName().equalsIgnoreCase(physioName))
                                .findFirst().orElse(null);

                        if (ph == null) {
                            System.out.println("Physiotherapist not found.");
                            break;
                        }
                    }

                    // Collect patient ID
                    System.out.print("Enter the patient ID: ");
                    String pid = scanner.nextLine();
                    Patient p = system.getPatients().stream()
                            .filter(x -> x.getId().equals(pid)).findFirst().orElse(null);
                    if (p == null) {
                        System.out.println("Patient not found.");
                        break;
                    }

                    // List available treatments from the selected physiotherapist
                    System.out.println("Available treatments for " + ph.getName() + ":");
                    int treatmentNumber = 1;
                    for (Treatment t : ph.getTreatments()) {
                        System.out.println(treatmentNumber + ". " + t.getName() + " on " + t.getDateTime().toLocalDate() +
                                " at " + t.getDateTime().toLocalTime());
                        treatmentNumber++;
                    }

                    System.out.print("Select the treatment for the new appointment (enter the number): ");
                    int treatmentChoice = Integer.parseInt(scanner.nextLine());

                    if (treatmentChoice < 1 || treatmentChoice > ph.getTreatments().size()) {
                        System.out.println("Invalid treatment choice.");
                        break;
                    }

                    // Get the selected treatment
                    Treatment selectedTreatment = ph.getTreatments().get(treatmentChoice - 1);

                    // Create a new appointment
                    String newAppointmentId = UUID.randomUUID().toString().substring(0, 8);
                    Appointment newAppointment = new Appointment(newAppointmentId, selectedTreatment, ph, p);

                    // Call the changeAppointment method to cancel old and book new
                    system.changeAppointment(oldAppointmentId, newAppointment);
                    break;



                case 8:
                    System.out.print("Enter appointment ID to attend: ");
                    String atid = scanner.nextLine();
                    system.attendAppointment(atid);
                    break;
                case 9:
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
            // ANSI Escape codes for colors and styles
            String reset = "\u001B[0m";
            String bold = "\u001B[1m";
            String underline = "\u001B[4m";
            String green = "\u001B[32m";
            String yellow = "\u001B[33m";
            String blue = "\u001B[34m";
            String purple = "\u001B[35m";
            String cyan = "\u001B[36m";
            String lightGreen = "\u001B[92m";

            if (physiotherapists.isEmpty()) {
                System.out.println(blue + bold + "No physiotherapists available." + reset);
            } else {
                for (Physiotherapist p : physiotherapists) {
                    System.out.println(purple + "╔═════════════════════════════════════╗" + reset);
                    System.out.println(purple + "║ " + green + "ID: " + cyan + p.getId() + reset);
                    System.out.println(purple + "║ " + green + "Name: " + cyan + p.getName() + reset);
                    System.out.println(purple + "║ " + green + "Address: " + cyan + p.getAddress() + reset );
                    System.out.println(purple + "║ " + green + "Phone: " + cyan + p.getPhone() + reset );
                    System.out.println(purple + "║ " + green + "Expertise: " + cyan + String.join(", ", p.getExpertise()) + reset );
                    System.out.println(purple + "║ " + green + "Treatments: " + cyan + p.getTreatments().size() + reset );

                    if (!p.getTreatments().isEmpty()) {
                        System.out.println(purple + "║ " + green + "Available treatments and timings:" + reset);
                        for (Treatment t : p.getTreatments()) {
                            System.out.println(purple + "║ - " + green + t.getName() + reset + " on " + cyan + t.getDateTime().toLocalDate() +
                                    " at " + cyan + t.getDateTime().toLocalTime() + reset );
                        }
                    } else {
                        System.out.println(purple + "║ " + yellow + "No available treatments." + reset );
                    }
                    System.out.println(purple + "╚═════════════════════════════════════╝" + reset);
                    System.out.println();
                }
            }
        }




}
