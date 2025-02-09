package carDealership;

import java.io.IOException;
import java.nio.file.Path;

// Author: Or Adar

/**
 * The Employee class represents an employee at the car dealership.
 * It tracks their personal details and performance metrics.
 * Implements Comparable to allow sorting employees based on sales.
 */
public class Employee implements Comparable<Employee> {
    private String name; // Employee's full name (only letters allowed)
    private String ID; // Unique 9-digit employee ID
    private int numberSales; // Number of cars sold by the employee

    /**
     * Constructs an Employee object with the specified attributes.
     *
     * @param name        The employee's name (letters only)
     * @param ID          The employee's unique 9-digit ID
     * @param numberSales Number of sales attributed to the employee (must be non-negative)
     * @throws Exception If any input validation fails.
     */
    public Employee(String name, String ID, int numberSales) throws Exception {
        setName(name);
        setID(ID);
        setNumberSales(numberSales);
    }

    /**
     * Retrieves the employee's name.
     *
     * @return The employee's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the employee's name.
     *
     * @param name The employee's name (must contain only letters)
     * @throws Exception If the name contains invalid characters.
     */
    public void setName(String name) throws Exception {
        if (!name.matches("[a-zA-Z]+"))
            throw new Exception("Name must have letters only.");
        this.name = name;
    }

    /**
     * Retrieves the employee's ID.
     *
     * @return The employee's unique ID.
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the employee's ID.
     *
     * @param ID The unique 9-digit identifier for the employee.
     * @throws Exception If the ID is not exactly 9 numeric characters.
     */
    public void setID(String ID) throws Exception {
        if (!ID.matches("\\d{9}"))
            throw new Exception("ID must be exactly 9 digits.");
        this.ID = ID;
    }

    /**
     * Records a car sale and increments the employee's sales count.
     *
     * @param car  The car being sold.
     * @param path The file path where sales are logged.
     * @throws IOException If an I/O error occurs.
     */
    public void carSale(Car car, Path path) throws IOException {
        car.carSale(path);
        numberSales++;
    }

    /**
     * Calculates the employee's salary based on the number of sales.
     *
     * @return The employee's calculated salary.
     */
    public int salary() {
        return 6000 + numberSales * 100;
    }

    /**
     * Retrieves the number of sales made by the employee.
     *
     * @return The number of sales.
     */
    public int getNumberSales() {
        return numberSales;
    }

    /**
     * Sets the number of sales.
     *
     * @param numberSales The number of sales made (must be non-negative)
     * @throws Exception If the number is negative.
     */
    public void setNumberSales(int numberSales) throws Exception {
        if (numberSales < 0)
            throw new Exception("Number of sales must be a non-negative integer.");
        this.numberSales = numberSales;
    }

    /**
     * Returns a formatted string representation of the employee.
     *
     * @return A string with employee details.
     */
    @Override
    public String toString() {
        return name + " " + ID + " " + numberSales;
    }

    /**
     * Checks if two Employee objects are equal based on their attributes.
     *
     * @param obj The object to compare.
     * @return True if all attributes match, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Employee employee))
            return false;
        return name.equals(employee.getName()) && ID.equals(employee.getID()) && numberSales == employee.getNumberSales();
    }

    /**
     * Compares two Employee objects based on their number of sales.
     *
     * @param other The employee to compare to.
     * @return A negative integer if this employee has fewer sales, zero if equal, or a positive integer if greater.
     */
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.numberSales, other.numberSales);
    }
}

