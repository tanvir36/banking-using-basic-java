package ATM;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Account {
	
	private String username;
	private int password;
	private double checkingBalance=0;
	private double savingBalance=0;
	
	Scanner input = new Scanner (System.in);
	DecimalFormat money = new DecimalFormat("'$' ###,##0.00");
	
//	Getters and Setters for username and password
	
	public String setUsername(String username) {
		this.username = username;
		return username;
	}
	
	public String getUsername() {
		return username;
	}

	public int setPassword(int password) {
		this.password= password;
		return password;
	}
	 
	public int getPassword() {
		return password;
	}
	
//	methods for Balance check
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public double getSavingBalance() {
		return savingBalance;
	}
	
// Methods for Withdrawing amount
	public double calcCheckingWithdraw( double amount) {
		checkingBalance = checkingBalance-amount;
		return checkingBalance;
	}
	
	public double calcSavingWithdraw( double amount) {
		savingBalance = savingBalance-amount;
		return savingBalance;
	}
	
//	Methods for amount Deposit
	public double calcCheckingDeposit(double amount) {
		checkingBalance = checkingBalance+ amount;
		return checkingBalance;
	}
	
	public double calcSavingDeposit( double amount) {
		savingBalance = savingBalance+amount;
		return savingBalance;
	}
	
	
// Methods to get the amount we want to withdraw
	public void getCheckingWithdraw() {
		System.out.println("ACCOUNT BALANCE: "+ money.format(checkingBalance));
		System.out.println("Enter the amount you want to withdraw ");
		double amount = input.nextDouble();
		
		if((checkingBalance-amount)>0) {
			calcCheckingWithdraw(amount);
			System.out.println("Your Remaining Balance is: " + money.format(checkingBalance));
		} else {
			System.out.println("You Do not have enough to Withdraw");
		}
	}
	
	
	public void getSavingWithdraw() {
		System.out.println("ACCOUNT BALANCE: "+ money.format(savingBalance));
		System.out.println("Enter amount you want to withdraw");
		double amount = input.nextDouble();
		
		if((savingBalance-amount>0)) {
			calcSavingWithdraw(amount);
			System.out.println("Your Remaining Balance is: "+ money.format(savingBalance));
		}else {
			System.out.println("You have insufficient funds");			
		}
	}
	
//	Methods to get the amount we want to deposit 
	public void getCheckingDeposit() {
		System.out.println("ACCOUNT BALANCE: " + money.format(checkingBalance));
		System.out.println("Enter the amount you want to deposit");
		double amount = input.nextDouble();
		if(amount>0) {
			calcCheckingDeposit(amount);
			System.out.println("Your new Balance is: " +money.format(checkingBalance));
		}else {
			System.out.println("Invalid Input");
		}
	}
	
	public void getSavingDeposit() {
		System.out.println("ACCOUNT BALANCE: "+ money.format(savingBalance));
		System.out.println("Enter the amount you want to deposit");
		double amount = input.nextDouble();
		if(amount>0) {
			calcSavingDeposit(amount);
			System.out.println("Your new Balance: "+ money.format(savingBalance));	
		}else {
			System.out.println("Invalid Input");
		}
	}
	public void end() {
		checkingBalance=0;
		savingBalance=0;
	}
}
