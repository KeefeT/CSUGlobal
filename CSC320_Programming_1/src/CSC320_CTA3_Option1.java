import java.util.Scanner;


public class CSC320_CTA3_Option1 {

	/*
	 * 
	 * pseudocode:
	 * 
	 * take user input
	 * send input to a function which will return the tax on that income
	 * print tax withheld in main function
	 * 
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
		
		System.out.print("Enter income: ");
		double income = input.nextDouble();
		
		System.out.println("Tax withheld: " + calculateTax(income));
		
		input.close();
	}
}
