package carDealership;
// Assignment: 5
// Author: Or Adar, ID: 305468506
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
/**
 * The Car class represents a car with its attributes and behaviors.
 */
public class Car {
    private String carID;
    private int manuYear;
    private String manuName;
    private int km;
    private int price;
    /**
     * Constructs a Car object with the specified attributes.
     *
     * @param carID     the car's ID
     * @param manuYear  the manufacturing year of the car
     * @param manuName  the manufacturer's name
     * @param km        the car's mileage
     * @param price     the price of the car
     * @throws Exception if any of the attributes are invalid
     */
    public Car(String carID,int manuYear,String manuName,int km,int price) throws Exception {
        setCarID(carID);
        setManuYear(manuYear);
        setManuName(manuName);
        setKm(km);
        setPrice(price);
    }
    /**
     * Calculates the value of the car after applying a discount.
     *
     * @param percent the discount percentage
     * @throws Exception if the discount percentage is invalid
     */
    public void carValue(int precent)throws Exception{
        int discount=price*precent/100;
        if(precent<0)
            throw new Exception("Precent must be a positive number.");
        if(discount>5000)
            throw new Exception("Discount cannot be more than 5000.");
        price-=discount;
    }
    /**
     * Performs a car sale and appends the car's details to a file.
     *
     * @param path the path to the file
     * @throws IOException if an I/O error occurs
     */
    public void carSale(Path path) throws IOException {
        Files.writeString(path,toString(), StandardOpenOption.APPEND);
    }
    /**
     * Retrieves the car's ID.
     *
     * @return the car's ID
     */
    public String getCarID() {
        return carID;
    }
    /**
     * Sets the car's ID.
     *
     * @param carID the car's ID
     * @throws Exception if the car ID is invalid
     */
    public void setCarID(String carID)throws Exception {
        if(carID.length()!=6){
            throw new Exception("Car ID must be 6 digits long.");
        }
        try{
            int x=Integer.parseInt(carID);
            if(x<0)
                throw new Exception("Number must be positive.");
        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Car ID must be digits only.");
        }
        this.carID = carID;
    }
    /**
     * Retrieves the manufacturing year of the car.
     *
     * @return the manufacturing year of the car
     */
    public int getManuYear() {
        return manuYear;
    }
    /**
     * Sets the manufacturing year of the car.
     *
     * @param manuYear the manufacturing year of the car
     * @throws Exception if the manufacturing year is invalid
     */
    public void setManuYear(int manuYear)throws Exception {
        if(manuYear<2017)
            throw new Exception("Manufactured year must be after 2017.");
        if(manuYear>2023)
            throw new Exception("Time travel is not allowed.");
        this.manuYear = manuYear;
    }
    /**
     * Retrieves the manufacturer's name.
     *
     * @return the manufacturer's name
     */
    public String getManuName() {
        return manuName;
    }
    /**
     * Sets the manufacturer's name.
     *
     * @param manuName the manufacturer's name
     * @throws Exception if the manufacturer's name is invalid
     */
    public void setManuName(String manuName)throws Exception {
        if(!manuName.matches("[a-z,A-Z]+"))
            throw new Exception("Name must include letters.");
        this.manuName = manuName;
    }
    /**
     * Retrieves the car's mileage.
     *
     * @return the car's mileage
     */
    public int getKm() {
        return km;
    }
    /**
     * Sets the car's mileage.
     *
     * @param km the car's mileage
     * @throws Exception if the mileage is invalid
     */
    public void setKm(int km) throws Exception{
        if(km<0)
            throw new Exception("KM must be a positive number.");
        this.km = km;
    }
    /**
     * Retrieves the price of the car.
     *
     * @return the price of the car
     */
    public int getPrice() {
        return price;
    }
    /**
     * Sets the price of the car.
     *
     * @param price the price of the car
     * @throws Exception if the price is invalid
     */
    public void setPrice(int price)throws Exception {
        if(price<0)
            throw new Exception("Price must be positive.");
        this.price = price;
    }
    /**
     * Returns a string representation of the car.
     *
     * @return a string representation of the car
     */
    @Override
    public String toString(){
        return carID+" "+manuYear+" "+manuName+" "+km+" "+price;
    }
    /**
     * Checks if the given object is equal to the current car.
     *
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object O){
        if(this==O)
            return true;
        if(!(O instanceof Car car))
            return false;
        return carID.equals(car.getCarID())&&manuYear==(car.getManuYear())&&getManuName().equals(car.manuName)&&
                km==(car.getKm())&&price==(car.getPrice());
    }
}
