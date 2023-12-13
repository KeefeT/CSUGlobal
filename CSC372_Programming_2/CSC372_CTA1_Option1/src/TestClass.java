

public class TestClass {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckingAccount account = new CheckingAccount("Thomas", "Keefe", 12345, .15);
		account.displayAccount();
		System.out.println("\nAdding money to account\n");
		account.deposit(100);
		account.displayAccount();
		System.out.println("\nWithdrawing money from account\n");
		account.processWithdrawal(50);
		account.displayAccount();
		System.out.println("\nWithdrawing and overdrafting from account\n");
		account.processWithdrawal(100);
		account.displayAccount();
	}

}
