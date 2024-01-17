import java.util.Scanner;

public class Recursion {
	
	public static int sum(int[] arr, int len) {
		if (len == 0) {
			//base case
			return arr[len];
		} else {
			//recursive case
			return arr[len] + sum(arr, len-1);
		}
	}
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int arr[] = new int[5]; 
				
		for (int i = 0; i < 5; i++) {
			System.out.print("Please enter int number " + i + ": ");
			try {
				arr[i] = Integer.parseInt(s.next());
			} catch (Exception e) {
				System.out.print("Not an int!\n");
				i -= 1;
			}
		}
		
		s.close();
		
		int sum = sum(arr, arr.length-1);
		
		System.out.println("Sum: " + sum);
		
	}
}
