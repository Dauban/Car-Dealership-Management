package carDealership;
// Author: Or Adar

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * The Car class encapsulates vehicle-related attributes and behaviors.
 * This class ensures data integrity through validation in setter methods.
 */
public class Car {
    private String carID; // Unique identifier for the car (6-digit format)
    private int manuYear; // Manufacturing year (restricted range: 2017-2023)
    private String manuName; // Manufacturer name (alphabetic only)
    private int km; // Car's mileage (non-negative)
    private int price; // Car's price (non-negative)

    /**
     * Constructs a Car object with the given parameters.
     *
     * @param carID     Unique 6-digit car identifier
     * @param manuYear  Manufacturing year (2017-2023 enforced)
     * @param manuName  Manufacturer's name (alphabetic validation)
     * @param km        Mileage (must be non-negative)
     * @param price     Price of the car (must be non-negative)
     * @throws Exception If any parameter fails validation.
     */
    public Car(String carID, int manuYear, String manuName, int km, int price) throws Exception {
        setCarID(carID);
        setManuYear(manuYear);
        setManuName(manuName);
        setKm(km);
        setPrice(price);
    }

    /**
     * Reduces the price of the car by applying a discount.
     *
     * @param percent Discount percentage (must be positive and not exceed 5000 in value)
     * @throws Exception If discount constraints are violated.
     */
    public void carValue(int percent) throws Exception {
        if (percent < 0)
            throw new Exception("Percent must be a positive number.");
        int discount = price * percent / 100;
        if (discount > 5000)
            throw new Exception("Discount cannot be more than 5000.");
        price -= discount;
    }

    /**
     * Logs the sale of the car by appending its details to a specified file.
     *
     * @param path File path where sale records are stored.
     * @throws IOException If an error occurs during file writing.
     */
    public void carSale(Path path) throws IOException {
        Files.writeString(path, toString() + "\n", StandardOpenOption.APPEND);
    }

    /** Getters and Setters with Validation */
    
    public String getCarID() { return carID; }
    
    public void setCarID(String carID) throws Exception {
        if (carID.length() != 6 || !carID.matches("\\d{6}"))
            throw new Exception("Car ID must be exactly 6 digits.");
        this.carID = carID;
    }
    
    public int getManuYear() { return manuYear; }
    
    public void setManuYear(int manuYear) throws Exception {
        if (manuYear < 2017 || manuYear > 2023)
            throw new Exception("Manufacturing year must be between 2017 and 2023.");
        this.manuYear = manuYear;
    }
    
    public String getManuName() { return manuName; }
    
    public void setManuName(String manuName) throws Exception {
        if (!manuName.matches("[a-zA-Z]+"))
            throw new Exception("Manufacturer name must contain only letters.");
        this.manuName = manuName;
    }
    
    public int getKm() { return km; }
    
    public void setKm(int km) throws Exception {
        if (km < 0)
            throw new Exception("Mileage must be a non-negative number.");
        this.km = km;
    }
    
    public int getPrice() { return price; }
    
    public void setPrice(int price) throws Exception {
        if (price < 0)
            throw new Exception("Price must be a non-negative value.");
        this.price = price;
    }
    
    /**
     * Returns a formatted string representation of the car.
     *
     * @return String containing car details.
     */
    @Override
    public String toString() {
        return carID + " " + manuYear + " " + manuName + " " + km + " " + price;
    }

    /**
     * Compares two Car objects for equality based on their attributes.
     *
     * @param obj Object to compare against.
     * @return True if all attributes match, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Car car))
            return false;
        return carID.equals(car.getCarID()) && manuYear == car.getManuYear() &&
               manuName.equals(car.getManuName()) && km == car.getKm() &&
               price == car.getPrice();
    }
}

