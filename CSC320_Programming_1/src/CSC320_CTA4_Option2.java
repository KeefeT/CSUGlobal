import java.util.Scanner;


public class CSC320_CTA4_Option2 {

	/*
	 * pseudocode:
	 * 
	 * create scanner
	 * for loop 10 times
	 * 	get user input
	 * 	add input to array
	 * 	check to see if input is min num seen
	 * 	check to see if input is max num seen
	 * 	add input to avg
	 * 
	 * divide avg by CLASS_SIZE to get average
	 * 
	 * print all data to console
	 * 
	 */
	
	public static void main(String[] args) {		
		
		final int CLASS_SIZE = 10;
		
		Scanner input = new Scanner(System.in);
		float[] arr = new float[CLASS_SIZE];
		
		float min = Float.MAX_VALUE;
		float max = Float.MIN_VALUE;
		float avg = 0;
		
		for(int i = 0; i < CLASS_SIZE; i++) {
			
			System.out.print("Enter grade number " + (i+1) + ": ");
			arr[i] = input.nextFloat();
			
			if (arr[i] < min) {
				min = arr[i];
			}
			
			if (arr[i] > max) {
				max = arr[i];
			}
			
			avg += arr[i];
		}
		
		avg = avg / CLASS_SIZE;
		
		System.out.println("Average: " + String.format("%.2f", avg));
		System.out.println("Min: " + String.format("%.2f", min));
		System.out.println("Max: " + String.format("%.2f", max));
		
		input.close();
	}
}
