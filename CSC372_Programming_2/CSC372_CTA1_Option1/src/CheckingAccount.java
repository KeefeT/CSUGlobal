
public class CheckingAccount extends BankAccount{

	double interest;
	final double fee = 30;
	
	public CheckingAccount(String firstName, String lastName, int accountID, double interest) {
		super(firstName, lastName, accountID);
		this.interest = interest;
	}

	public void displayAccount() {
		super.accountSummary();
		System.out.printf("Interest rate: %.2f%%\n", interest*100);
	}
	
	public void processWithdrawal(double amount) {
		if (amount > getBalance()) {
			amount += fee;
			withdrawal(amount);
			System.out.printf("You have been charged a $%.2f overdraft fee!\n", fee);
			System.out.printf("New balance: $%.2f\n", getBalance());
		} else {
			withdrawal(amount);
		}
	}
}
