import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Inventory {

	ArrayList<Car> inventory;
	
	private static class Car {
		
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
		
		public String toString() {
			String out = "";
			out += "Make: " + this.make + "\n";
			out += "Model: " + this.model + "\n";
			out += "Color: " + this.color + "\n";
			out += "Year: " + this.year + "\n";
			out += "Mileage: " + this.mileage + "\n";
			return out;
		}
		
		@SuppressWarnings("unused")
		public boolean equals(Car c) {
			if(this.make.equals(c.model) && this.model.equals(c.model) && this.color.equals(c.color) && (this.year == c.year) && (this.mileage == c.mileage)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public Inventory() {
		this.inventory =  new ArrayList<Car>();
	}
		
	public boolean addCar(Car newCar) {
		return this.inventory.add(newCar);
	}
	
	public boolean removeCar(Car carToRemove) {
		return this.inventory.remove(carToRemove);
	}
	
	public boolean updateCar(int index, Car updateCar) {
		this.inventory.set(index, updateCar);
		return true;
	}
	
	public boolean export() {
		
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
			return true;
		} catch (IOException e) {
			System.out.println("Error exporting file: " + e);
			return false;
		}
	}
	
	public String toString() {
		String out = "";
		
		for (int i = 0; i < this.inventory.size(); i++) {
			out += "Car " + (i+1) + ":\n";
			out += this.inventory.get(i).toString() + "\n";
		}
		
		return out;
	}
	
	public static void main(String[] args) {
		//Create an additional class to call your automobile class (e.g., Main or AutomobileInventory). 
		//Include a try..catch construct and print it to the console.
		Inventory carInventory = new Inventory();
		Scanner scanner = new Scanner(System.in);
		
		//Call automobile class with parameterized constructor (e.g., "make, model, color, year, mileage").
		//Then call the method to list the values. Loop through the array and print to the screen
		Car car1 = new Car("Subaru", "Forester", "black", 2012, 155000);
		carInventory.addCar(car1);
		System.out.println(carInventory);
		
		//Call the remove vehicle method to clear the variables.
		//Print the return value.
		System.out.println(carInventory.removeCar(car1));
		
		//Add a new vehicle.
		//Print the return value.
		//Call the list method and print the new vehicle information to the screen.
		Car defaultCar = new Car();
		System.out.println(carInventory.addCar(defaultCar));
		System.out.println(carInventory);

		//Update the vehicle.
		//Print the return value.
		//Call the listing method and print the information to the screen.
		defaultCar.mileage = 200000;
		carInventory.updateCar(0, defaultCar);
		System.out.println(carInventory);
		
		//Display a message asking if the user wants to print the information to a file (Y or N).
		//Use a scanner to capture the response. If "Y", print the file to a predefined location (e.g., C:\Temp\Autos.txt). Note: you may want to create a method to print the information in the main class.
		//If "N", indicate that a file will not be printed.
		System.out.println("Would you like to export the inventory to a file? (Y/N): ");
		
		if (scanner.next().equals("Y")) {
			System.out.println("Exporting inventory...");
			carInventory.export();
		} else {
			System.out.println("Not exporting inventory...");
		}
		
		System.out.println("Exiting...");
		scanner.close();
	}
}
