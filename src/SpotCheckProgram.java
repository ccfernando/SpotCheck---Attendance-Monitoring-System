import java.util.ArrayList; // Import the ArrayList class for dynamic arrays
import java.util.Scanner;   // Import the Scanner class for user input

public class SpotCheckProgram {

    // Class to represent each student and their attendance status
    static class Student {
        String name;            // Name of the student
        boolean isPresent;     // Attendance status of the student (true if present, false otherwise)

        // Constructor to initialize the student with a name and set attendance status to false
        Student(String name) {
            this.name = name;          // Set the student's name
            this.isPresent = false;    // By default, the student is not present
        }
    }

    // Class to represent a section containing students
    static class Section {
        String sectionName;          // Name of the section (e.g., Electron, Graviton, Proton)
        ArrayList<Student> students; // List of students in this section

        // Constructor to initialize the section with a name and an array of student names
        Section(String sectionName, String[] studentNames) {
            this.sectionName = sectionName;    // Set the section name
            this.students = new ArrayList<>(); // Initialize the list of students

            // Loop through each student name and create a Student object
            for (String name : studentNames) {
                this.students.add(new Student(name)); // Add each student to the section
            }
        }
    }

    // Class to represent each event with a list of sections
    static class Event {
        String eventName;            // Name of the event
        ArrayList<Section> sections; // List of sections in this event

        // Constructor to initialize the event with a name and an empty list of sections
        Event(String eventName) {
            this.eventName = eventName;   // Set the event name
            this.sections = new ArrayList<>(); // Initialize the list of sections
        }
    }

    // Method to add a new event with predefined sections and students
    public static void addEvent(ArrayList<Event> events) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input

        // Prompt the user to enter the name of the event
        System.out.print("\nEnter the name of the event: ");
        String eventName = scanner.nextLine(); // Read the event name from user input

        // Create a new Event object with the entered name
        Event event = new Event(eventName);

        // Predefined student names for each section
        String[] electronStudents = {"Alice", "Bob", "Charlie", "David", "Eve"};
        String[] gravitonStudents = {"Frank", "Grace", "Hannah", "Ian", "Jack"};
        String[] protonStudents = {"Kate", "Liam", "Mia", "Nora", "Oscar"};

        // Create and add predefined sections to the event
        event.sections.add(new Section("Electron", electronStudents)); // Add Electron section
        event.sections.add(new Section("Graviton", gravitonStudents)); // Add Graviton section
        event.sections.add(new Section("Proton", protonStudents));     // Add Proton section

        // Add the newly created event to the list of events
        events.add(event);
        System.out.println("\nEvent '" + eventName + "' has been added successfully!\n"); // Notify user of successful addition
    }

    // Method to mark attendance for students in a selected section
    public static void markAttendance(Event event) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        System.out.println("\nMarking attendance for event: " + event.eventName); // Notify which event's attendance is being marked
        
        // Display available sections for the event
        System.out.println("\nAvailable sections:");
        for (int i = 0; i < event.sections.size(); i++) {
            // Print section number and name
            System.out.println((i + 1) + ". " + event.sections.get(i).sectionName);
        }
        System.out.print("\nSelect a section by number: ");
        int sectionChoice = scanner.nextInt(); // Read the user's choice of section number
        scanner.nextLine();  // Consume the newline character after integer input

        // Check if the selected section number is valid
        if (sectionChoice > 0 && sectionChoice <= event.sections.size()) {
            Section section = event.sections.get(sectionChoice - 1); // Get the selected section based on user input
            System.out.println("\nMarking attendance for " + section.sectionName); // Notify which section's attendance is being marked

            // Iterate over each student in the selected section
            for (Student student : section.students) {
                // Prompt the user to mark attendance for the student
                System.out.print("Is " + student.name + " present? (Y/N): ");
                String response = scanner.nextLine().trim().toUpperCase(); // Read and format the user's response
                if (response.equals("Y")) {
                    student.isPresent = true;  // Mark student as present
                } else if (response.equals("N")) {
                    student.isPresent = false; // Mark student as absent
                } else {
                    // Handle invalid input
                    System.out.println("Invalid input. Assuming absent.");
                    student.isPresent = false; // Default to absent for invalid input
                }
            }
        } else {
            // Handle invalid section selection
            System.out.println("Invalid section selection.");
        }
    }

    // Method to display the attendance list for a given event
    public static void displayAttendance(Event event) {
        // Print the header for the attendance list
        System.out.println("\nAttendance List for Event: " + event.eventName);
        
        // Iterate over each section in the event
        for (Section section : event.sections) {
            // Print the section name
            System.out.println("\nAttendance for " + section.sectionName + ":");
            // Iterate over each student in the section
            for (Student student : section.students) {
                // Determine the attendance status of the student
                String status = student.isPresent ? "Present" : "Absent";
                // Print student's name and attendance status
                System.out.println("  " + student.name + ": " + status);
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        ArrayList<Event> events = new ArrayList<>(); // Initialize a list to store all events
        boolean running = true; // Flag to control the main loop of the program

        // Main loop to handle user input and perform actions
        while (running) {
            // Print the menu options for the user
            System.out.println("\n=========================================");
            System.out.println("SpotCheck - Attendance Monitoring System");
            System.out.println("=========================================");
            System.out.println("1. Add a new event");
            System.out.println("2. Mark attendance");
            System.out.println("3. Display attendance");
            System.out.println("4. Exit");
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt(); // Read the user's menu choice
            scanner.nextLine();  // Consume the newline character after integer input

            // Handle the user's choice using a switch statement
            switch (choice) {
                case 1:
                    addEvent(events); // Call method to add a new event
                    break;
                case 2:
                    // Check if there are any events available
                    if (events.isEmpty()) {
                        System.out.println("\nNo events available. Please add an event first.");
                    } else {
                        // Display list of events for selection
                        System.out.println("\nAvailable events:");
                        for (int i = 0; i < events.size(); i++) {
                            // Print event number and name
                            System.out.println((i + 1) + ". " + events.get(i).eventName);
                        }
                        System.out.print("\nSelect an event by number: ");
                        int eventChoice = scanner.nextInt(); // Read the user's choice of event number
                        scanner.nextLine();  // Consume the newline character after integer input

                        // Check if the selected event number is valid
                        if (eventChoice > 0 && eventChoice <= events.size()) {
                            markAttendance(events.get(eventChoice - 1)); // Call method to mark attendance for the selected event
                        } else {
                            // Handle invalid event selection
                            System.out.println("Invalid event selection.");
                        }
                    }
                    break;
                case 3:
                    // Check if there are any events available
                    if (events.isEmpty()) {
                        System.out.println("\nNo events available. Please add an event first.");
                    } else {
                        // Display list of events for selection
                        System.out.println("\nAvailable events:");
                        for (int i = 0; i < events.size(); i++) {
                            // Print event number and name
                            System.out.println((i + 1) + ". " + events.get(i).eventName);
                        }
                        System.out.print("\nSelect an event by number: ");
                        int eventChoice = scanner.nextInt(); // Read the user's choice of event number
                        scanner.nextLine();  // Consume the newline character after integer input

                        // Check if the selected event number is valid
                        if (eventChoice > 0 && eventChoice <= events.size()) {
                            displayAttendance(events.get(eventChoice - 1)); // Call method to display attendance for the selected event
                        } else {
                            // Handle invalid event selection
                            System.out.println("Invalid event selection.");
                        }
                    }
                    break;
                case 4:
                    running = false; // Set the flag to false to exit the loop and terminate the program
                    System.out.println("\nExiting the system. Goodbye!");
                    break;
                default:
                    // Handle invalid menu choice
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}
