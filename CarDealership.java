package carDealership;
// Author: Or Adar

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The CarDealership class represents a simple dealership management system.
 * It allows users to view employees, check unsold cars, register sales, and add new cars.
 */
public class CarDealership {
    
    /**
     * Generic sorting method using Bubble Sort (can be optimized with Collections.sort()).
     *
     * @param list The ArrayList of Comparable elements to sort.
     * @param <T>  A type that implements Comparable.
     */
    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        int size = list.size();
        T temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Main method to run the Car Dealership management system.
     *
     * @param args Command-line arguments (not used).
     * @throws Exception Handles incorrect user input.
     */
    public static void main(String[] args) throws Exception {
        
        // File paths for storing data
        Path sold = Paths.get("Sold.txt");
        ArrayList<Car> carList = new ArrayList<>();
        Path fileCars = Paths.get("CarDealership.txt");

        // Load cars from file
        String carContent = Files.readString(fileCars);
        String[] lines = carContent.split("\n");
        for (String line : lines) {
            String[] values = line.split(" ");
            try {
                Car car = new Car(values[0], Integer.parseInt(values[1]), values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]));
                carList.add(car);
            } catch (Exception e) {
                System.out.println("Invalid car entry: " + e.getMessage());
            }
        }

        // Load employees from file
        ArrayList<Employee> employeeList = new ArrayList<>();
        Path fileEmployees = Paths.get("Employee.txt");
        String employeeContent = Files.readString(fileEmployees);
        String[] lines2 = employeeContent.split("\n");
        for (String line : lines2) {
            String[] values = line.split(" ");
            try {
                Employee employee = new Employee(values[0], values[1], Integer.parseInt(values[2]));
                employeeList.add(employee);
            } catch (Exception e) {
                System.out.println("Invalid employee entry: " + e.getMessage());
            }
        }

        Scanner scan = new Scanner(System.in);
        int choice;

        while (true) {
            Menu.printMenu();
            choice = scan.nextInt();
            
            switch (choice) {
                case 1:
                    // Sort employees by number of sales
                    sort(employeeList);
                    System.out.println("List of employees:");
                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    break;
                case 2:
                    // Display unsold cars
                    System.out.println("Cars available for sale:");
                    for (Car car : carList) {
                        if (!Files.readString(sold).contains(car.getCarID())) {
                            System.out.println(car);
                        }
                    }
                    break;
                case 3:
                    // Process a car sale
                    System.out.println("Enter Employee ID:");
                    String empID = scan.next();
                    Employee selectedEmployee = null;
                    for (Employee e : employeeList) {
                        if (e.getID().equals(empID)) {
                            selectedEmployee = e;
                            break;
                        }
                    }
                    if (selectedEmployee == null) throw new Exception("Invalid Employee ID");
                    
                    System.out.println("Enter Car ID to sell:");
                    String carID = scan.next();
                    Car selectedCar = null;
                    for (Car c : carList) {
                        if (c.getCarID().equals(carID)) {
                            selectedCar = c;
                            break;
                        }
                    }
                    if (selectedCar == null) throw new Exception("Invalid Car ID");
                    
                    selectedEmployee.carSale(selectedCar, sold);
                    carList.remove(selectedCar);
                    System.out.println("Sale completed!");
                    break;
                case 4:
                    // Add a new car to inventory
                    System.out.println("Enter Car Details (ID, Year, Manufacturer, KM, Price):");
                    try {
                        Car newCar = new Car(scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt());
                        carList.add(newCar);
                        System.out.println("Car added successfully!");
                    } catch (Exception e) {
                        System.out.println("Invalid input: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
