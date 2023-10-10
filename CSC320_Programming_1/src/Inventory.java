import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * @author Thomas Keefe
 * @email tjk819@gmail.com
 * @date 10/10/2023
 */

public class Inventory {
	//Create an additional class to call your automobile class (e.g., Main or AutomobileInventory). 

	ArrayList<Car> inventory;
	
	public Inventory() {
		//default constructor
		this.inventory =  new ArrayList<Car>();
	}
	
	public Inventory(Car car1, Car car2) {
		//parameterized constructor
		this.inventory =  new ArrayList<Car>();
		this.addCar(car1);
		this.addCar(car2);
	}
		
	public boolean addCar(Scanner scanner) {
		//add a new vehicle  method
		//All methods should include try..catch constructs. 
		//Except as noted all methods should return a success or failure message (failure message defined in "catch").

		try {
			Car newCar = new Car();
			
			System.out.println("Enter new car make: ");
			newCar.setMake(scanner.next());
			System.out.println("Enter new car model: ");
			newCar.setModel(scanner.next());
			System.out.println("Enter new car color: ");
			newCar.setColor(scanner.next());
			System.out.println("Enter new car year: ");
			newCar.setYear(scanner.nextInt());
			System.out.println("Enter new car mileage: ");
			newCar.setMileage(scanner.nextInt());
			
			this.inventory.add(newCar);
			System.out.println("addCar success!\n");
			return true;
		} catch (Exception e) {
			System.out.println("Error in addCar: " + e + "\n");
			return false;
		}
	}
	
	public boolean addCar(Car newCar) {
		//add a new vehicle  method
		//All methods should include try..catch constructs. 
		//Except as noted all methods should return a success or failure message (failure message defined in "catch").
		try {
			this.inventory.add(newCar);
			System.out.println("addCar success!\n");
			return true;
		} catch (Exception e) {
			System.out.println("Error in addCar(Car): " + e + "\n");
			return false;
		}
	}
	
	public boolean removeCar(Scanner scanner) {
		//remove a vehicle method
		//All methods should include try..catch constructs. 
		//Except as noted all methods should return a success or failure message (failure message defined in "catch").
		try {
			Car newCar = new Car();
			System.out.println("Please enter the information of the car you'd like to remove...");
			System.out.println("Enter car make: ");
			newCar.setMake(scanner.next());
			System.out.println("Enter car model: ");
			newCar.setModel(scanner.next());
			System.out.println("Enter car color: ");
			newCar.setColor(scanner.next());
			System.out.println("Enter car year: ");
			newCar.setYear(scanner.nextInt());
			System.out.println("Enter car mileage: ");
			newCar.setMileage(scanner.nextInt());
			
			boolean val = this.inventory.remove(newCar);
			
			if (val) {
				System.out.println("removeCar success!\n");
			} else {
				System.out.println("removeCar failure: no car in inventory that matches!\n");
			}
			return val;
		} catch (Exception e) {
			System.out.println("Error in removeCar: " + e + "\n");
			return false;
		}
	}	
	
	public boolean removeCar(Car carToRemove) {
		//remove a vehicle method
		//All methods should include try..catch constructs. 
		//Except as noted all methods should return a success or failure message (failure message defined in "catch").
		try {
			boolean val = this.inventory.remove(carToRemove);
			
			if (val) {
				System.out.println("removeCar success!\n");
			} else {
				System.out.println("removeCar failure: no car in inventory that matches!\n");
			}			
			
			return val;
		} catch (Exception e) {
			System.out.println("Error in removeCar(Car): " + e + "\n");
			return false;
		}
	}
	
	public boolean updateCar(int index, Scanner scanner) {
		//update vehicle attributes method
		//All methods should include try..catch constructs. 
		//Except as noted all methods should return a success or failure message (failure message defined in "catch").		
		try {
			
			if (index < 0 || index > this.inventory.size()) {
				throw new IndexOutOfBoundsException("Index is out of bounds!");
			}
			
			Car newCar = new Car();
			System.out.println("Please enter the information of the car you'd like to update at index " + index + "...");
			System.out.println("Enter new make: ");
			newCar.setMake(scanner.next());
			System.out.println("Enter new model: ");
			newCar.setModel(scanner.next());
			System.out.println("Enter new color: ");
			newCar.setColor(scanner.next());
			System.out.println("Enter new year: ");
			newCar.setYear(scanner.nextInt());
			System.out.println("Enter new mileage: ");
			newCar.setMileage(scanner.nextInt());
			
			Car val = this.inventory.set(index, newCar);
			
			if (val != null) {
				System.out.println("updateCar success\n");
				return true;
			} else {
				System.out.println("updateCar failure: no car was updated\n");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error in updateCar: " + e + "\n");
			return false;
		}
	}
	
	public boolean updateCar(int index, Car updateCar) {
		//update vehicle attributes method
		//All methods should include try..catch constructs. 
		//Except as noted all methods should return a success or failure message (failure message defined in "catch").
		try {
			
			if (index < 0 || index > this.inventory.size()) {
				throw new IndexOutOfBoundsException("Index is out of bounds!");
			}
			
			Car val = this.inventory.set(index, updateCar);
			
			if (val != null) {
				System.out.println("updateCar success\n");
				return true;
			} else {
				System.out.println("updateCar failure: no car was updated\n");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error in updateCar: " + e + "\n");
			return false;
		}
	}
	
	public boolean export() {
		//print the file to a predefined location
		//All methods should include try..catch constructs. 
		//Except as noted all methods should return a success or failure message (failure message defined in "catch").
		try {
			String fileName = "carInventory.txt";
			File output = new File(fileName);
			
			if(!output.exists()) {
				output.createNewFile();
			}
			
			FileWriter writer = new FileWriter(output);
					
			writer.write(this.toString());
			writer.flush();
			writer.close();
			System.out.println("export success\n");
			return true;
		} catch (IOException e) {
			System.out.println("Error exporting file: " + e + "\n");
			return false;
		}
	}
	
	public String toString() {
		//list inventory information
		String out = "";
		
		if (this.inventory.size() == 0) {
			return out += "No cars in inventory....\n";
		}
		
		for (int i = 0; i < this.inventory.size(); i++) {
			out += "Car " + i + ":\n";
			out += this.inventory.get(i).toString();
		}
		
		return out;
	}
	
	public static void main(String[] args) {
		//variables
		Inventory carInventory;
		Scanner input = new Scanner(System.in);
		
		try {
			//Create an additional class to call your automobile class (e.g., Main or AutomobileInventory). 
			//Include a try..catch construct and print it to the console.
			carInventory = new Inventory();
			System.out.println(carInventory);
			
			//Call automobile class with parameterized constructor (e.g., "make, model, color, year, mileage").
			//Then call the method to list the values. Loop through the array and print to the screen
			Car car1 = new Car("Subaru", "Forester", "black", 2012, 155000);
			carInventory.addCar(car1);
			System.out.println("current inventory: \n" + carInventory);
			
			//Call the remove vehicle method to clear the variables.
			//Print the return value.
			System.out.println("return value of removeCar(Car): " + carInventory.removeCar(car1) + "\n");
			
			//Add a new vehicle.
			//Print the return value.
			//Call the list method and print the new vehicle information to the screen.
			Car defaultCar = new Car();
			System.out.println("return value of addCar(Car): " + carInventory.addCar(defaultCar) + "\n");
			System.out.println("current inventory: \n" + carInventory);

			//Update the vehicle.
			//Print the return value.
			//Call the listing method and print the information to the screen.
			carInventory.updateCar(0, input);
			System.out.println(carInventory);
			
			//Display a message asking if the user wants to print the information to a file (Y or N).
			//Use a scanner to capture the response. If "Y", print the file to a predefined location (e.g., C:\Temp\Autos.txt). Note: you may want to create a method to print the information in the main class.
			//If "N", indicate that a file will not be printed.
			String check = "";
			do {
				System.out.println("Would you like to export the inventory to a file? (Y/N): ");
				check = input.next();
				if (check.equals("Y")) {
					carInventory.export();
					break;
				}
			} while (!check.equals("N"));
		} catch (Exception e) {
			System.out.println("Error in main: " + e);
		} finally {
			System.out.println("Exiting...");	
			input.close();
		}
		
	}
}

class Car {
	
	//Create an automobile class that will be used by a dealership as a vehicle inventory program.
	//The following attributes should be present in your automobile class:
	//private string make
	//private string model
	//private string color
	//private int year
	//private int mileage
	
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	
	public Car() {
		//default constructor
		//my car, Lightning McQueen
		this.make = "Ford";
		this.model = "Fusion";
		this.color = "red";
		this.year = 2007;
		this.mileage = 190000;
	}
	
	public Car(String make, String model, String color, int year, int mileage) {
		//parameterized constructor
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
	}
		
	public String getMake() {
		//getter
		return this.make;
	}
	
	public void setMake(String newMake) {
		//setter
		this.make = newMake;
		return;
	}
	
	public String getModel() {
		//getter
		return this.model;
	}
	
	public void setModel(String newModel) {
		//setter
		this.model = newModel;
		return;
	}
	
	public String getColor() {
		//getter
		return this.color;
	}
	
	public void setColor(String newColor) {
		//setter
		this.color = newColor;
		return;
	}
	
	public int getYear() {
		//getter
		return this.year;
	}
	
	public void setYear(int newYear) {
		//setter
		this.year = newYear;
		return;
	}
	
	public int getMileage() {
		//getter
		return this.mileage;
	}
	
	public void setMileage(int newMileage) {
		this.mileage = newMileage;
		return;
	}
	
	public boolean equals(Car c) {
		//override equals
		if(this.make.equals(c.make) && this.model.equals(c.model) && this.color.equals(c.color) && (this.year == c.year) && (this.mileage == c.mileage)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		//override toString
		//list vehicle information
		String out = "";
		out += "Make: " + this.make + "\n";
		out += "Model: " + this.model + "\n";
		out += "Color: " + this.color + "\n";
		out += "Year: " + this.year + "\n";
		out += "Mileage: " + this.mileage + "\n";
		return out;
	}
}

