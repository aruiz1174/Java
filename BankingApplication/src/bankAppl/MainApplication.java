package bankAppl;

import java.util.Scanner;

public class MainApplication 
{

	public static void main(String[] args) 
	{
		BankAccount bank = new BankAccount("Anibal Ruiz", "1234");
		bank.showMenu();

	}

}

class BankAccount
{
	int balance;
	int prevTrans;
	String costumer;
	String id;
	
	BankAccount(String costumerName, String cid)
	{
		costumer = costumerName;
		id = cid;
	}
	void deposit(int amount)
	{
		if(amount != 0)
		{
			balance = balance + amount;
			prevTrans = amount;
		}
	}
	
	void withdraw(int amount)
	{
		if(amount != 0)
		{
			
			balance = balance - amount;
			prevTrans = -amount;
		}
	}
	
	void getPrevTrans()
	{
		if(prevTrans > 0)
		{
			System.out.println("Deposited: " + prevTrans);
		}
		
		else if(prevTrans < 0)
		{
			System.out.println("Withdrawn: " + Math.abs(prevTrans));
		}
		else
			System.out.println("No transaction ocurred.");
	}
	
	void showMenu()
	{
		char options = '\0';
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome " + costumer);
		System.out.println("Your id is " + id);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous transaction");
		System.out.println("E. Exit");
		
		do
		{
			System.out.println("*******************************");
			System.out.println("Enter an option: ");
			options = scan.next().charAt(0);
			System.out.println("\n");
			
			switch(options)
			{
			
			case 'A':
				System.out.println("----------------------------");
				System.out.println("Balance = " + balance);
				System.out.println("----------------------------");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("----------------------------");
				System.out.println("Enter an amount of deposit: ");
				System.out.println("----------------------------");
				int amount = scan.nextInt();
				deposit(amount);
				System.out.println("----------------------------");
				break;
				
			case 'C':
				System.out.println("----------------------------");
				System.out.println("Enter an amount of withdraw: ");
				int amountWith = scan.nextInt();
				withdraw(amountWith);
				System.out.println("----------------------------");
				break;
				
			case 'D':
				System.out.println("----------------------------");
				getPrevTrans();
				System.out.println("----------------------------");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("-------------------------------");
				break;
				
			default:
				System.out.println("Invalid option!! Please enter again: ");
				break;
			
			}
		}
		while(options != 'E');
		
		System.out.println("Thank you for using our sevices.");
		
		scan.close();
	}
}
