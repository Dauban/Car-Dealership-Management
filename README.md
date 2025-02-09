Car Dealership Management System

Overview

This Car Dealership Management System is an advanced software application developed in Java, leveraging object-oriented programming principles to facilitate the management of vehicular sales and personnel oversight within a dealership environment. The system integrates structured file handling techniques to enable persistent data storage and retrieval, ensuring a seamless operational workflow.

Features

Comprehensive Employee Management – Implements structured data organization for employee records, enabling sorting by performance metrics (e.g., number of sales completed).

Vehicle Inventory Control – Maintains a dynamically updated list of available and sold vehicles.

Transaction Processing – Facilitates car sales through an integrated mechanism that associates transactions with specific employees.

Dynamic Data Persistence – Utilizes file-based storage mechanisms to maintain dealership records across multiple sessions.

Menu-Driven Interface – Employs an intuitive, structured user interface for efficient data navigation and operational execution.

Technologies Used

Java – Applied object-oriented programming methodologies to create a modular, scalable system architecture.

File I/O Operations – Implements Files API for robust data persistence and retrieval.

Data Structures & Sorting Algorithms – Utilizes ArrayList for dynamic data handling and implements a sorting mechanism using the Comparable interface.

Enumerations – Leverages enum to enhance code readability and facilitate structured menu-driven functionality.

Project Architecture

CarDealership/
│── Car.java               # Encapsulates vehicle attributes and behaviors
│── Employee.java           # Defines employee data structure and sales tracking
│── CarDealership.java      # Core application logic and data processing
│── Menu.java               # Enumerates menu options for streamlined execution
│── CarDealership.txt       # Persistent storage of vehicle inventory
│── Employee.txt            # Repository of employee records
│── Sold.txt (Generated)    # Logs transaction history
│── README.md               # Documentation and usage guide

Execution Instructions

Compile the Java source files:

javac CarDealership.java

Run the compiled application:

java CarDealership

Interact via menu-driven prompts to execute dealership operations.

Sample Dataset

Vehicle Inventory (CarDealership.txt)

123456 2018 Toyota 100000 70000
987546 2020 Toyota 50000 95000
659874 2022 Kia 20000 120000
986532 2019 Honda 30000 65000
487541 2023 Mazda 0 150000

Employee Records (Employee.txt)

Yossi 456548123 5
Omer 128745965 1
Tal 659878320 4
Bar 333112658 2
Stav 875487659 3

Proposed Enhancements

Database Integration – Transition from file-based storage to a relational database for improved scalability and data integrity.

Graphical User Interface (GUI) – Implement a user-friendly GUI to enhance usability.

Optimized Sorting Algorithms – Replace manual sorting with Java’s built-in Collections.sort() for improved efficiency.

Author

Or Adar 📧 orniky91@gmail.com

Developed for academic and professional use in software engineering and dealership management systems.