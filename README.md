# Hospital Management System

A console-based **Hospital Management System** developed in **Java** using **Object-Oriented Programming (OOP)** concepts.

The application provides a command-line interface for managing **patients, appointments, and billing records** using Java collections and UUID-based identification.

---

## Application Preview

![Hospital Management System Console](docs/screenshots/hms-console.png)

---

## Project Overview

The Hospital Management System (HMS) is a Java-based console application designed to demonstrate the implementation of basic hospital management operations using Object-Oriented Programming.

The system is organized into three primary functional areas:

- **Patient Management**
- **Appointment Management**
- **Billing Management**

Each record is assigned a unique identifier using Java's `UUID` functionality. Application data is maintained in memory using Java `ArrayList` collections.

---

## Key Features

### Patient Management

- Add new patients
- Automatically generate unique Patient IDs
- View all registered patients
- Search patients using Patient ID
- Store patient name, age, and ailment information

### Appointment Management

- Schedule appointments for patients
- Automatically generate unique Appointment IDs
- Automatically calculate the next available appointment slot
- Record doctor name, appointment date, and time
- View scheduled appointments

### Billing Management

- Generate bills for patients
- Automatically generate unique Bill IDs
- Record multiple services
- Store total billing amount
- View generated bills

---

## System Workflow

The application follows a simple menu-driven workflow:

```text
                         ┌───────────────┐
                         │     START     │
                         └───────┬───────┘
                                 │
                                 ▼
                ┌─────────────────────────────┐
                │ Hospital Management System  │
                └──────────────┬──────────────┘
                               │
                               ▼
                     ┌──────────────────┐
                     │   Display Menu   │
                     └────────┬─────────┘
                              │
              ┌───────────────┼───────────────┐
              │               │               │
              ▼               ▼               ▼
       ┌─────────────┐ ┌─────────────┐ ┌─────────────┐
       │   Patient   │ │ Appointment │ │   Billing   │
       │ Management  │ │ Management  │ │ Management  │
       └──────┬──────┘ └──────┬──────┘ └──────┬──────┘
              │               │               │
              ▼               ▼               ▼
       ┌─────────────┐ ┌─────────────┐ ┌─────────────┐
       │ Add / View  │ │ Schedule /  │ │ Generate /  │
       │ / Search    │ │ View        │ │ View Bills  │
       │ Patients    │ │ Appointments│ │             │
       └──────┬──────┘ └──────┬──────┘ └──────┬──────┘
              │               │               │
              └───────────────┼───────────────┘
                              │
                              ▼
                     ┌──────────────────┐
                     │ Return to Menu   │
                     └────────┬─────────┘
                              │
                              ▼
                         ┌───────────┐
                         │   Exit?   │
                         └─────┬─────┘
                               │
                    ┌──────────┴──────────┐
                    │                     │
                   No                    Yes
                    │                     │
                    └──────────┐          ▼
                               │     ┌──────────┐
                               └────►│   END    │
                                     └──────────┘
```

---

## Technologies Used

| Technology | Purpose |
|---|---|
| **Java** | Core application development |
| **Object-Oriented Programming** | Modular system design |
| **Java Collections Framework** | In-memory data management |
| **UUID** | Unique record identification |
| **Java Date & Time API** | Appointment slot calculation |
| **Scanner** | Command-line user input |
| **CLI** | User interaction |

---

## Application Menu

```text
Hospital Management System

1. Add Patient
2. View Patients
3. Search Patient by ID
4. Schedule Appointment
5. View Appointments
6. Generate Bill
7. View Bills
8. Exit
```

---

## Object-Oriented Design

The application is structured around four main classes:

```text
HospitalManagementSystem
│
├── Patient
│
├── Appointment
│
└── Bill
```

### `Patient`

Stores patient information:

- Patient ID
- Name
- Age
- Ailment

### `Appointment`

Stores appointment information:

- Appointment ID
- Patient ID
- Doctor Name
- Date
- Time

### `Bill`

Stores billing information:

- Bill ID
- Patient ID
- Services
- Total Amount

### `HospitalManagementSystem`

Acts as the main management class and handles:

- Patient operations
- Appointment operations
- Billing operations
- Application menu
- User interaction

---

## Data Management

The current implementation uses Java `ArrayList` collections for in-memory storage.

### Patient Records

```text
List<Patient> patients
```

### Appointment Records

```text
List<Appointment> appointments
```

### Billing Records

```text
List<Bill> bills
```

The system uses `UUID.randomUUID()` to generate unique identifiers for patients, appointments, and bills.

> **Note:** Data is stored only during the application's runtime and is lost when the program exits.

---

## Project Structure

```text
Hospital-Management-System/
│
├── README.md
├── LICENSE
├── .gitignore
│
├── src/
│   └── HospitalManagementSystem.java
│
└── docs/
    ├── Hospital-Management-System-Presentation.pptx
    ├── Hospital-Management-System-Project-Report.pdf
    ├── README.md
    │
    └── screenshots/
        └── hms-console.png
```

---

## How to Run

### Prerequisites

- **Java JDK 21** or compatible Java version
- Git
- A terminal or command prompt

### 1. Clone the Repository

```bash
git clone https://github.com/vikram020125/hospital-management-system.git
```

### 2. Navigate to the Project

```bash
cd hospital-management-system
```

### 3. Compile the Application

```bash
javac src/HospitalManagementSystem.java
```

### 4. Run the Application

```bash
java -cp src HospitalManagementSystem
```

---

## Current Limitations

The current version is intentionally designed as a **console-based academic project**.

- No database integration
- No permanent data storage
- No authentication or authorization
- No graphical user interface
- Basic input validation
- No patient update/delete functionality
- Appointment and billing operations do not currently validate patient existence

---

## Future Enhancements

The project can be extended with:

- MySQL or PostgreSQL database integration
- User authentication and role-based access
- GUI or web-based interface
- Patient record update and deletion
- Advanced appointment management
- Payment processing
- Medical inventory management
- Reports and analytics
- Data backup and recovery
- REST API integration
- AI-assisted hospital analytics

---

## Learning Outcomes

This project demonstrates practical understanding of:

- Java programming
- Object-Oriented Programming
- Classes and objects
- Constructors
- Lists and collections
- UUID-based identification
- Date and time handling
- Console-based application development
- Basic modular software design

---

## Project Documentation

Additional project documentation is available in the `docs` directory:

- [Project Presentation](docs/Hospital-Management-System-Presentation.pptx)
- [Project Report](docs/Hospital-Management-System-Project-Report.pdf)

---

## Author

**Vikram R.**

Academic Java Project  
Hospital Management System

---

## License

This project is licensed under the **MIT License**.

See the [LICENSE](LICENSE) file for details.
