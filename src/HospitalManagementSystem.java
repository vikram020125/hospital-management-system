import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Patient {
    String patientId;
    String name;
    int age;
    String ailment;

    public Patient(String name, int age, String ailment) {
        this.patientId = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.ailment = ailment;
    }
}

class Appointment {
    String appointmentId;
    String patientId;
    String doctorName;
    String date;
    String time;

    public Appointment(String patientId, String doctorName, String date, String time) {
        this.appointmentId = UUID.randomUUID().toString();
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }
}

class Bill {
    String billId;
    String patientId;
    List<String> services;
    double totalAmount;

    public Bill(String patientId, List<String> services, double totalAmount) {
        this.billId = UUID.randomUUID().toString();
        this.patientId = patientId;
        this.services = services;
        this.totalAmount = totalAmount;
    }
}

public class HospitalManagementSystem {

    private List<Patient> patients;
    private List<Appointment> appointments;
    private List<Bill> bills;

    public HospitalManagementSystem() {
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        bills = new ArrayList<>();
    }

    // Patient-related functionalities
    public void addPatient(String name, int age, String ailment) {

        Patient patient = new Patient(name, age, ailment);
        patients.add(patient);

        System.out.println(
            "Patient " + name +
            " added successfully! Patient ID: " +
            patient.patientId
        );
    }

    public void viewPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (Patient patient : patients) {

            System.out.println(
                "ID: " + patient.patientId +
                ", Name: " + patient.name +
                ", Age: " + patient.age +
                ", Ailment: " + patient.ailment
            );
        }
    }

    public void searchPatient(String patientId) {

        for (Patient patient : patients) {

            if (patient.patientId.equals(patientId)) {

                System.out.println(
                    "ID: " + patient.patientId +
                    ", Name: " + patient.name +
                    ", Age: " + patient.age +
                    ", Ailment: " + patient.ailment
                );

                return;
            }
        }

        System.out.println("Patient not found.");
    }

    // Appointment-related functionalities
    public String[] getNextAvailableSlot() {

        LocalDateTime currentTime = LocalDateTime.now();

        LocalDateTime slot =
            currentTime.plusMinutes(30);

        DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter timeFormatter =
            DateTimeFormatter.ofPattern("hh:mm a");

        String formattedDate =
            slot.format(dateFormatter);

        String formattedTime =
            slot.format(timeFormatter);

        return new String[] {
            formattedDate,
            formattedTime
        };
    }

    public void scheduleAppointment(
            String patientId,
            String doctorName) {

        String[] slot =
            getNextAvailableSlot();

        String date = slot[0];
        String time = slot[1];

        Appointment appointment =
            new Appointment(
                patientId,
                doctorName,
                date,
                time
            );

        appointments.add(appointment);

        System.out.println(
            "Appointment for patient ID " +
            appointment.patientId +
            " scheduled successfully! " +
            "Date: " + date +
            ", Time: " + time +
            ", Appointment ID: " +
            appointment.appointmentId
        );
    }

    public void viewAppointments() {

        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment appointment : appointments) {

            System.out.println(
                "Appointment ID: " +
                appointment.appointmentId +
                ", Patient ID: " +
                appointment.patientId +
                ", Doctor: " +
                appointment.doctorName +
                ", Date: " +
                appointment.date +
                ", Time: " +
                appointment.time
            );
        }
    }

    // Billing functionalities
    public void generateBill(
            String patientId,
            List<String> services,
            double totalAmount) {

        Bill bill =
            new Bill(
                patientId,
                services,
                totalAmount
            );

        bills.add(bill);

        System.out.println(
            "Bill generated successfully for patient ID " +
            bill.patientId +
            "! Bill ID: " +
            bill.billId
        );
    }

    public void viewBills() {

        if (bills.isEmpty()) {
            System.out.println("No bills found.");
            return;
        }

        for (Bill bill : bills) {

            System.out.println(
                "Bill ID: " +
                bill.billId +
                ", Patient ID: " +
                bill.patientId +
                ", Services: " +
                String.join(", ", bill.services) +
                ", Total Amount: ₹" +
                bill.totalAmount
            );
        }
    }

    // Main program
    public static void main(String[] args) {

        HospitalManagementSystem hms =
            new HospitalManagementSystem();

        java.util.Scanner scanner =
            new java.util.Scanner(System.in);

        while (true) {

            System.out.println(
                "\nHospital Management System"
            );

            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Schedule Appointment");
            System.out.println("5. View Appointments");
            System.out.println("6. Generate Bill");
            System.out.println("7. View Bills");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");

            String choice =
                scanner.nextLine();

            if (choice.equals("1")) {

                System.out.print(
                    "Enter Patient Name: "
                );

                String name =
                    scanner.nextLine();

                System.out.print(
                    "Enter Patient Age: "
                );

                int age =
                    Integer.parseInt(
                        scanner.nextLine()
                    );

                System.out.print(
                    "Enter Ailment: "
                );

                String ailment =
                    scanner.nextLine();

                hms.addPatient(
                    name,
                    age,
                    ailment
                );

            } else if (choice.equals("2")) {

                hms.viewPatients();

            } else if (choice.equals("3")) {

                System.out.print(
                    "Enter Patient ID to search: "
                );

                String patientId =
                    scanner.nextLine();

                hms.searchPatient(
                    patientId
                );

            } else if (choice.equals("4")) {

                System.out.print(
                    "Enter Patient ID: "
                );

                String patientId =
                    scanner.nextLine();

                System.out.print(
                    "Enter Doctor's Name: "
                );

                String doctorName =
                    scanner.nextLine();

                hms.scheduleAppointment(
                    patientId,
                    doctorName
                );

            } else if (choice.equals("5")) {

                hms.viewAppointments();

            } else if (choice.equals("6")) {

                System.out.print(
                    "Enter Patient ID: "
                );

                String patientId =
                    scanner.nextLine();

                System.out.print(
                    "Enter services provided " +
                    "(comma-separated): "
                );

                String serviceInput =
                    scanner.nextLine();

                String[] serviceArray =
                    serviceInput.split(",");

                List<String> services =
                    new ArrayList<>();

                for (String service : serviceArray) {

                    services.add(
                        service.trim()
                    );
                }

                System.out.print(
                    "Enter total amount (in ₹): "
                );

                double totalAmount =
                    Double.parseDouble(
                        scanner.nextLine()
                    );

                hms.generateBill(
                    patientId,
                    services,
                    totalAmount
                );

            } else if (choice.equals("7")) {

                hms.viewBills();

            } else if (choice.equals("8")) {

                System.out.println(
                    "Exiting the system. Goodbye!"
                );

                break;

            } else {

                System.out.println(
                    "Invalid choice! Please try again."
                );
            }
        }

        scanner.close();
    }
}
