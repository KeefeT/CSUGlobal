
import java.util.Scanner;
import java.util.LinkedList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Portfolio {

	LinkedList<Car> list;
	Scanner scnr;
	
	public Portfolio() {
		this.list = new LinkedList<Car>();
		this.scnr = new Scanner(System.in);	
	}
	
	public void printList() {
		System.out.println("List of Cars:\n");
		for (Car car : this.list) {
			System.out.println(car);
		}
	}
		
	public Car createCar(Scanner scnr) {
		try {
			Car newCar;
			String make, model;
			double mpg;
			
			System.out.print("Enter new car make: ");
			make = scnr.nextLine();
			
			System.out.print("Enter new car model: ");
			model = scnr.nextLine();
			
			System.out.print("Enter new car mpg: ");
			mpg = Double.parseDouble(scnr.nextLine());
			
			newCar = new Car(make, model, mpg);
			System.out.println("New car: " + newCar);
			
			this.list.add(newCar);
			
			return newCar;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creating new car: " + e + "\n");
			return null;
		}
	}
	
	public boolean writeToFile() {
		
		boolean ret = false;
		
		try {
			File file = new File("mpg-output.txt");
			FileWriter fw = new FileWriter(file);
			
			for (Car car : this.list) {
				fw.write(car.toString());
			}
			
			fw.close();
			ret = true;
		} catch (IOException e) {
			System.out.println("Error with writing to file: " + e + "\n");
		}

		return ret;
	}
	
	public static void main(String args[]) {
		Portfolio po = new Portfolio();
		int flag;
		
		do {
			flag = -1;
			System.out.println("Options:\n1. Add new car to list.\n2. End data entry.\n(1/2)\n");
			try {
				flag = Integer.parseInt(po.scnr.nextLine());
				
				if (flag == 1) {
					po.createCar(po.scnr);
				}
				
			} catch (Exception e) {
				System.out.println("Error parsing options: " + e + "\n");
			}
			
		} while (flag != 2);
		
		po.scnr.close();
		
		System.out.println("Before sorting:");
		po.printList();
		
		po.list.sort(new CompareCarsMPG());
		
		System.out.println("After sorting:");
		po.printList();
		
		System.out.println("Writing list to disk...\n");
		if (po.writeToFile()) {
			System.out.println("List written successfully");
		} else {
			System.out.println("Failed to write list to disk");
		}
		
	}

}
