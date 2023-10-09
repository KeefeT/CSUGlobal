import java.util.Scanner;


public class CSC320_CTA4_Option2 {

	/*
	 * pseudocode:
	 * 
	 * create scanner
	 * for loop
	 *  take user input and fill into array
	 *  if we see smallest value yet, set min to it
	 *  if we see largest value yet, set max to it
	 * send array to computeAverage function
	 * print average
	 * print min
	 * print max
	 * 
	 * computeAverage:
	 *  for each element in array
	 *   add element to avg variable
	 *  return avg / array length 

	 */
	
	
	public static float computeAverage(float[] array) {
		float avg = 0;
		
		for (float elem : array) {
			avg += elem;
		}
		
		return avg / (float)array.length;		
	}
	
	public static void main(String[] args) {		
		
		final int CLASS_SIZE = 10;
		
		Scanner input = new Scanner(System.in);
		float[] arr = new float[CLASS_SIZE];
		
		float min = Float.MAX_VALUE;
		float max = Float.MIN_VALUE;
		
		for(int i = 0; i < CLASS_SIZE; i++) {
			
			System.out.print("Enter grade number " + (i+1) + ": ");
			arr[i] = input.nextFloat();
			
			if (arr[i] < min) {
				min = arr[i];
			}
			
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		System.out.println("Average: " + computeAverage(arr));
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
		
		input.close();
	}
}
