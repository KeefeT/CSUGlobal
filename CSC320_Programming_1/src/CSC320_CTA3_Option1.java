import java.util.Scanner;


public class CSC320_CTA3_Option1 {

	/*
	 * 
	 * pseudocode:
	 * 
	 * repeat - get user input (double) - until input > 0
	 * if input less than 500
	 *  rate = .1
	 * else if input < 1500
	 *  rate = .15
	 * else if input < 2500
	 *  rate = .2
	 * else 
	 *  rate = .3
	 *  
	 * print rate
	 * print input times rate
	 * 
	 */
	
	public static double calculateTax(double income) {
		double rate = 1;
		
		if (income < 500) {
			rate = .1;
		} else if (income < 1500) {
			rate = .15;
		} else if (income < 2500) {
			rate = .2;
		} else {
			rate = .3;
		}
		
		System.out.println("tax rate: " + rate);
		return income * rate;
	}
	
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		double income = -1;
		double withheld;
		
		while (income <= 0) {
			System.out.print("Enter income (above 0): ");
			income = input.nextDouble();	
		}
		
		withheld = calculateTax(income);
		
		System.out.printf("Tax withheld: %.2f", withheld);
		
		input.close();
	}
}
