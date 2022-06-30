package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account;
		
		try {
			System.out.print("Enter account number: ");
			int number = sc.nextInt();
			System.out.print("Enter account holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			System.out.print("Is there an initial deposit (y/n)? ");
			char response = sc.next().charAt(0);
			response = Character.toUpperCase(response);
			
			if (response == 'Y') {
				System.out.print("Enter initial deposit value: ");
				double initialDeposit = sc.nextDouble();
				account = new Account(number, holder, withdrawLimit, initialDeposit);
			}
			else {
				account = new Account(number, holder, withdrawLimit);
			}
			
			System.out.println();
			System.out.println("Account data:");
			System.out.println(account);
			
			System.out.println();
			System.out.print("Enter a deposit value: ");
			double amount = sc.nextDouble();
			account.deposit(amount);
			System.out.println("Updated account data:");
			System.out.println(account);
			
			System.out.println();
			System.out.print("Enter a withdraw value: ");
			double withdrawValue = sc.nextDouble();
			account.withdraw(withdrawValue);
			System.out.println("Updated account data:");
			System.out.println(account);
		}
		
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}
		sc.close();

	}

}
