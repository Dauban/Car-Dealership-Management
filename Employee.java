package carDealership;

import java.io.IOException;
import java.nio.file.Path;
// Assignment: 5
// Author: Or Adar, ID: 305468506
/**
 * The Employee class represents an employee with their attributes and behaviors.
 * It implements the Comparable interface to enable comparison between employees based on their number of sales.
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private String ID;
    private int numberSales;

    /**
     * Constructs an Employee object with the specified attributes.
     *
     * @param name        the employee's name
     * @param ID          the employee's ID
     * @param numberSales the number of sales made by the employee
     * @throws Exception if any of the attributes are invalid
     */
    public Employee(String name, String ID, int numberSales) throws Exception {
        setName(name);
        setID(ID);
        setNumberSales(numberSales);
    }

    /**
     * Retrieves the employee's name.
     *
     * @return the employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the employee's name.
     *
     * @param name the employee's name
     * @throws Exception if the name is invalid
     */
    public void setName(String name) throws Exception {
        if (!name.matches("[a-zA-Z]+"))
            throw new Exception("Name must have letters only.");
        this.name = name;
    }

    /**
     * Retrieves the employee's ID.
     *
     * @return the employee's ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the employee's ID.
     *
     * @param ID the employee's ID
     * @throws Exception if the ID is invalid
     */
    public void setID(String ID) throws Exception {
        if (!ID.matches("[0-9]+"))
            throw new Exception("ID must have numbers only.");
        if (ID.length() != 9)
            throw new Exception("ID must be exactly 9 digits long.");
        this.ID = ID;
    }

    /**
     * Performs a car sale for the employee and updates the number of sales.
     *
     * @param car  the car being sold
     * @param path the path to the file
     * @throws IOException if an I/O error occurs
     */
    public void carSale(Car car, Path path) throws IOException {
        car.carSale(path);
        numberSales++;
    }

    /**
     * Calculates the salary of the employee based on the number of sales.
     *
     * @return the salary of the employee
     */
    public int salary() {
        return 6000 + numberSales * 100;
    }

    /**
     * Retrieves the number of sales made by the employee.
     *
     * @return the number of sales
     */
    public int getNumberSales() {
        return numberSales;
    }

    /**
     * Sets the number of sales made by the employee.
     *
     * @param numberSales the number of sales
     * @throws Exception if the number of sales is invalid
     */
    public void setNumberSales(int numberSales) throws Exception {
        if (numberSales < 0)
            throw new Exception("Number must be positive.");
        this.numberSales = numberSales;
    }

    /**
     * Returns a string representation of the employee.
     *
     * @return a string representation of the employee
     */
    @Override
    public String toString() {
        return name + " " + ID + " " + numberSales;
    }

    /**
     * Checks if the given object is equal to the current employee.
     *
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
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
     * Compares the current employee to another employee based on their number of sales.
     *
     * @param other the other employee to compare
     * @return a negative integer if the current employee has fewer sales, zero if they have the same number of sales,
     * or a positive integer if the current employee has more sales
     */
    @Override
    public int compareTo(Employee other) {
        if (numberSales == other.numberSales)
            return 0;
        if (numberSales < other.numberSales)
            return -1;
        return 1;
    }
}
