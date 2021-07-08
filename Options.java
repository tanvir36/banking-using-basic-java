package ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class Options extends Account {
	
	Scanner input = new Scanner (System.in);
	DecimalFormat money= new DecimalFormat ("'$',###,##0.00");
	String uname ="";
	int pin;
	HashMap <String, Integer> info = new HashMap <String, Integer>();
	
	public void getLogin() throws IOException{
		int x=1;
		do {
			try {
				info.put("tanvir", 3413);
				info.put("manjit", 1804);
				
				System.out.println("Welcome To Tani's Bank");
				System.out.println("Enter your username number");
				setUsername(input.next());
				
				System.out.println("Enter Your Pin");
				setPassword(input.nextInt());
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				x=2;	
			}
			String user = getUsername();
			int password = getPassword();
			if(info.containsKey(user) && info.get(user)==password) {
				getAccountType();
			}else {
				System.out.println("wrong user");
			}
		} while(x==1); 		
		
	
	}
	
	
	public void getAccountType() {
		System.out.println("******Select the Account you wan to access*****");
		System.out.println("Enter 1: Checking Account");
		System.out.println("Enter 2: Saving Account");
		System.out.println("Enter 3: Exit");
		
		int options = input.nextInt();
		
		switch (options) {
		
		case 1:
			getChecking();		
			break;
			
		case 2:
			getSaving();
			break;
			
		case 3:
			System.out.println("Thanks!! for using Tani's bank");
			end();
			break;
			
		default: 
			System.out.println("Invalid choice");
		}
		
	}
	
	public void getChecking() {
		System.out.println("******CHECKING ACCOUNT*****");
		System.out.println("Enter 1: View Balance");
		System.out.println("Enter 2: Deposit Money");
		System.out.println("Enter 3: Withdraw Money");
		System.out.println("Enter 4: Exit");		
		
		int options = input.nextInt();
		
		switch(options) {
		
			case 1: 
				System.out.println(money.format(getCheckingBalance()));
				getChecking();
				break;
				
			case 2:
				getCheckingDeposit();
				getChecking();
				break;
				
			case 3:
				getCheckingWithdraw();
				getChecking();
				break;
				
			case 4: 
				System.out.println("EXITING CHECKING ACCOUNT");
				getAccountType();
				
				break;
				
			default: 
				System.out.println("Invalid choice");
		}

		
	}

	public void getSaving() {
		System.out.println("******SAVING ACCOUNT*****");
		System.out.println("Enter 1: View Balance");
		System.out.println("Enter 2: Deposit Money");
		System.out.println("Enter 3: Withdraw Money");
		System.out.println("Enter 4: Exit");
		
		int options = input.nextInt();
		
		switch(options) {
		
			case 1: 
				System.out.println(money.format(getSavingBalance()));
				getSaving();
				break;
				
			case 2:
				getSavingDeposit();
				getSaving();
				break;
				
			case 3:
				getSavingWithdraw();
				getSaving();
				break;
				
			case 4: 
				System.out.println("EXITING SAVING ACCOUNT");
				getAccountType();
				break;
				
			default: 
				System.out.println("Invalid choice");
		}		
	}
	

}
