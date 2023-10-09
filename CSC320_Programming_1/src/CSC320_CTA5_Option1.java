import java.util.Scanner;
import java.util.ArrayList;

public class CSC320_CTA5_Option1 {

	/*
	 * pseudocode:
	 * 
	 * create temp list
	 * create week list
	 * calculate weekly avg from average function
	 * 
	 * while loop
	 *  input of q quits
	 *  gets user input
	 *  if input is 'week', return weekly avg
	 *  checks to see if input in in weeks list, if not, error
	 *  loop through list to get index number of day
	 *  return temps[index] and week[index]
	 * end loop
	 * 
	 * average function
	 *  loop through list and sum elements
	 *  return sum / list.size()
	 */
	
	public static double average(ArrayList<Double> list) {
		
		double out = 0;
		
		for (double elem : list) {
			out += elem;
		}
		
		return out / list.size();
	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input = "";
		ArrayList<Double> temps = new ArrayList<Double>();
		temps.add(80.4);
		temps.add(75.8);
		temps.add(62.0);
		temps.add(72.4);
		temps.add(81.1);
		temps.add(72.9);
		temps.add(69.3);
		ArrayList<String> week = new ArrayList<String>();
		week.add("monday");
		week.add("tuesday");
		week.add("wednesday");
		week.add("thursday");
		week.add("friday");
		week.add("saturday");
		week.add("sunday");
		double avg = average(temps);
		
		while (!input.equals("q")) {
			
			System.out.println("Enter day of the week to get average temperature for that day, or enter q to quit: ");
			input = scanner.next();
			
			if (input.equals("q")) {
				continue;
			}
			
			input = input.toLowerCase();
			
			if (week.contains(input)) {
				
				int index = -1;
				
				for (int i = 0; i < week.size(); i++) {
					if (week.get(i).equals(input)) {
						index = i;
					}
				}
				
				System.out.println("The average temperature for " + week.get(index) + " was " + temps.get(index) + " degrees F.");
			} else if (input.equals("week")) {
				System.out.format("The weekly average was %.2f degrees F", avg);
			} else {
				System.out.println("Error: " + input + " is not a day of the week.\n");
				continue;
			}
		}
		
		scanner.close();
	}

}
