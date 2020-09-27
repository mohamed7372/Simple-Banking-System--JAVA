package simpleBankingSystem;

import java.util.Scanner;

public class Main {
	
	public static final Scanner sc = new Scanner(System.in);
	public static BankingSystem banking = new BankingSystem();
	
	public static void main(String [] args) {
		menu();
		int choix = sc.nextInt();
		System.out.println();
		while(choix != 0) {
			String stat = "";
			switch (choix) {
			case 1: 
				createCard();
				break;
			case 2:
				stat = login();
				break;
			default:
			}
			System.out.println();
			if(stat.equals("exit"))
				break;
			menu();
			choix = sc.nextInt();
		}
		System.out.println("Bye!");
	}
	
	static void menu() {
		System.out.println("1. Create an account");
		System.out.println("2. Log into account");
		System.out.println("0. Exit");
	}
	static void menuLogin() {
		System.out.println("1. Balance");
		System.out.println("2. Log out");
		System.out.println("0. Exit");
	}
	static void createCard() {
		System.out.println("Your card has been created");
		Card card = new Card();
		banking.addCard(card);
		System.out.println("Your card number:\n" + card.codeCard());
		System.out.println("Your card PIN:\n" + card.PIN);
	}
	static String login() {
		System.out.println();
		System.out.println("Enter your card number:");
		String cardNumber = sc.next();
		System.out.println("Enter your PIN:");
		String pin = sc.next();
		Card c = banking.isExiste(cardNumber, pin);
		if(c != null) {
			System.out.println("\nYou have successfully logged in!\n");
			menuLogin();
			int choix = sc.nextInt();
			System.out.println();
			while(choix != 0) {
				boolean st = false;
				switch (choix) {
				case 1: 
					System.out.println("Balance: " + c.Balance);
					break;
				case 2:
					System.out.println("You have successfully logged out!");
					st = true;
					break;
				default:
				}
				if(st)
					break;
				System.out.println();
				menuLogin();
				choix = sc.nextInt();
			}
			if (choix == 0)
				return "exit";
		}
		else
			System.out.println("\nWrong card number or PIN!");
		return "";
	}
}

