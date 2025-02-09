package carDealership;
// Assignment: 5
// Author: Or Adar, ID: 305468506
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CarDealership {
    public static<T extends Comparable<T>> void sort(ArrayList<T> list){
        int size= list.size();
        T temp;
        for(int i=0;i<size-1;i++){
            for(int j=0;j<size-1;j++){
                if(list.get(j).compareTo(list.get(j+1))>0){
                    temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Path sold=Paths.get("C:\\Users\\ornik\\IdeaProjects\\FifthHW\\src\\carDealership\\Sold.txt");
        //Files.createFile(sold);

        ArrayList<Car> carList=new ArrayList<>();
        Path fileCars= Paths.get("C:\\Users\\ornik\\IdeaProjects\\FifthHW\\src\\carDealership\\CarDealership.txt");
        String carContent=Files.readString(fileCars);
        String[] lines=carContent.split("\n");
        for(int i=0;i< lines.length;i++){
            String[] values=lines[i].split(" ");
            try {
                Car car = new Car(values[0], Integer.parseInt(values[1]),
                        values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]));
                carList.add(car);
            }
            catch(Exception e){
                System.out.println("Can't add a car with incorrect values");
            }
        }
        ArrayList<Employee> employeeList=new ArrayList<>();
        Path fileEmployees=Paths.get("C:\\Users\\ornik\\IdeaProjects\\FifthHW\\src\\carDealership\\Employee.txt");
        String employeeContent=Files.readString(fileEmployees);
        String[] lines2=employeeContent.split("\n");
        for(int i=0;i< lines2.length;i++){
            String[] values=lines2[i].split(" ");
            try {
               Employee employee = new Employee(values[0],values[1],Integer.parseInt(values[2]));
               employeeList.add(employee);
            }
            catch(Exception e){
                System.out.println("Can't add a employee with incorrect values");
            }
        }
        System.out.println(employeeList);
        int choice;
        Scanner scan=new Scanner(System.in);
        while(true){
            Menu.printMenu();
            choice=scan.nextInt();
            switch(choice){
                case 1:
                    sort(employeeList);
                    System.out.println("list of employees:");
                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    break;
                case 2:
                    System.out.println("cars in the agency that have yet to be sold:");
                    for (Car car : carList) {
                        if (!Files.readString(sold).contains(car.getCarID())) {
                            System.out.println(car);
                        }
                    }
                    break;
                case 3:
                    System.out.println("List of employees:");
                    for (Employee employee : employeeList) {
                        System.out.println(employee.getName() + " - " + employee.getID());
                    }

                    System.out.print("Enter employee ID: ");
                    String selectedEmployeeID = scan.next();

                    Employee selectedEmployee = null;
                    for (Employee employee : employeeList) {
                        if (employee.getID().equals(selectedEmployeeID)) {
                            selectedEmployee = employee;
                            break;
                        }
                    }

                    if (selectedEmployee == null) {
                        throw new Exception("Incorrect ID");
                    }

                    System.out.println("Unsold cars:");
                    for (Car car : carList) {
                        if (!Files.readString(sold).contains(car.getCarID())) {
                            System.out.println(car);
                        }
                    }

                    System.out.print("Enter car ID: ");
                    String selectedCarNumber = scan.next();

                    Car selectedCar = null;
                    for (Car car : carList) {
                        if (car.getCarID().equals(selectedCarNumber)) {
                            selectedCar = car;
                            break;
                        }
                    }

                    if (selectedCar == null) {
                        throw new Exception("Incorrect car ID");
                    }

                    selectedEmployee.carSale(selectedCar, sold);
                    carList.remove(selectedCar);

                    System.out.println("Sale done successfully");

                    break;

                case 4:
                    System.out.print("Enter car ID: ");
                    String carNumber = scan.next();

                    System.out.print("Enter manufactured year: ");
                    int year = scan.nextInt();

                    System.out.print("Enter manufactur name:");
                    String manufacturer = scan.next();

                    System.out.print("Enter KM:");
                    int km = scan.nextInt();

                    System.out.print("Enter price:");
                    int price = scan.nextInt();

                    try {
                        Car newCar = new Car(carNumber, year, manufacturer, km, price);
                        carList.add(newCar);
                        System.out.println("Car added Successfully!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                    default:
                    System.out.println("Wrong input try again.");
                    break;

            }
        }
    }

}
