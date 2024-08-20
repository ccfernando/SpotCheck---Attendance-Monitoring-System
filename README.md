# SpotCheck - Attendance Monitoring System

![image](https://github.com/user-attachments/assets/ac692450-1196-4ead-ac24-1dda2f9a0b4d)


## Overview

SpotCheck is an **Attendance Monitoring System** designed to help educators and organizers track student attendance during school events and activities. This Java-based application allows you to:

- **Add new events** with predefined sections and students
- **Mark attendance** for each student in a selected section
- **Display attendance records** for any event

## Features

- **Event Management:** Add new events with predefined sections and students.
- **Attendance Tracking:** Mark the attendance of students in different sections.
- **Detailed Reports:** View detailed attendance lists for any event.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or later
- An IDE or text editor of your choice (e.g., IntelliJ IDEA, Eclipse, VSCode)

### Usage
- **Add a New Event:**
Select option 1 from the menu.
Enter the event name and confirm.

- **Mark Attendance:**
Select option 2 from the menu.
Choose an event and a section.
For each student, indicate if they are present (Y) or absent (N).

- **Display Attendance:**
Select option 3 from the menu.
Choose an event to view the attendance records.

- **Exit the Program:**
Select option 4 from the menu to exit.

### Code Structure

- **SpotCheckProgram.java:** Main class containing the core functionality.
- **Student:** Represents a student with attendance status.
- **Section:** Represents a section with a list of students.
- **Event:** Represents an event with multiple sections.
- **addEvent():** Adds a new event with predefined sections.
- **markAttendance():** Marks attendance for students in a selected section.
- **displayAttendance():** Displays attendance records for an event.
