package calc;

import java.util.Scanner;

/**
 * @author Brandt Jorgensen
 */
public class CalcMenu {
	
	// PRIVATE Variables
	private Scanner input = new Scanner(System.in);
	private double principal, paymentsPerMonth, lastPayment = 0;
	private double apr, inputDouble;
	private int numberOfPayments, inputInt;
	
	// PRIVATE Methods
	private void displayResults() {
		System.out.println("\nPrincipal: $" + principal );
		System.out.println("APR: " + apr + "%");
		System.out.println("Payments per month: $" + paymentsPerMonth + " per month");
		if ( lastPayment != 0 ) {
			System.out.println("Last Monthly Payment: $" + lastPayment );
		}
		System.out.println("Number of payments: " + numberOfPayments);
		
		System.out.print("\nRun again? (Y/N) >: ");
		if ( input.next().toLowerCase().equals("y") ) {
			displayMenu();
		} else {
			System.out.println("\nBye!");
		}
		
	}
	
	private int getNumberOfPayments() {
		do {
			System.out.print("Please enter the total number of payments >: ");
			while (!input.hasNextInt()){
				System.out.print("Please enter a valid number: ");
				input.next();
			}
			inputInt = input.nextInt();
		} while (inputInt < 0);
		return inputInt;
	}
	
	private double getPaymentsPerMonth() {
		do {
			System.out.print("Please enter the amount paid per month >: ");
			while (!input.hasNextDouble()){
				System.out.print("Please enter a valid amount: ");
				input.next();
			}
			inputDouble = input.nextDouble();
		} while (inputDouble < 0);
		return inputDouble;
	}
	
	private double getAPRValue() {
		do {
			System.out.print("Please enter the annual percentage rate (APR) >: ");
			while (!input.hasNextDouble()){
				System.out.print("Please enter a valid percentage: ");
				input.next();
			}
			inputDouble = input.nextDouble();
		} while (inputDouble < 0);
		return inputDouble;
	}
	
	private double getPrincipalValue() {
		do {
			System.out.print("Please enter the principal amount >: ");
			while (!input.hasNextDouble()){
				System.out.print("Please enter a valid amount: ");
				input.next();
			}
			inputDouble = input.nextDouble();
		} while (inputDouble < 0);
		return inputDouble;
	}
	
	private void redirectMenuSelection( String selectedMenuOption ) {
		switch ( selectedMenuOption ) {
			case "1": 
				// CALCULATE THE NUMBER OF PAYMENTS
				System.out.println("\nPrincipal, APR, Payments per Month\n");
				principal = getPrincipalValue();
				apr = getAPRValue();
				paymentsPerMonth = getPaymentsPerMonth();
				numberOfPayments = new CalcNumberOfPayments( principal, apr, paymentsPerMonth ).calculate();
				displayResults();
				break;
			case "2": 
				// CALCULATE THE PAYMENT AMOUNT PER MONTH
				System.out.println("\nPrincipal, APR, Number of Payments\n");
				principal = getPrincipalValue();
				apr = getAPRValue();
				numberOfPayments = getNumberOfPayments();
				CalcPaymentsPerMonth payPerMonth = new CalcPaymentsPerMonth( principal, apr, numberOfPayments );
				paymentsPerMonth = payPerMonth.getPayPerMonth();
				lastPayment = payPerMonth.getLastPayment();
				displayResults();
				break;
			case "3":
				// CALCULATE APR
				System.out.println("\nPrincipal, Number of Payments, Payments per Month\n");
				principal = getPrincipalValue();
				paymentsPerMonth = getPaymentsPerMonth();
				numberOfPayments = getNumberOfPayments();
				apr = new CalcAPR( principal, paymentsPerMonth, numberOfPayments ).calculate();
				displayResults();
				break;
			case "4": 
				// CALCULATE PRINCIPAL
				System.out.println("\nAPR, Number of Payments, Payments per Month\n");
				apr = getAPRValue();
				paymentsPerMonth = getPaymentsPerMonth();
				numberOfPayments = getNumberOfPayments();
				principal = new CalcPrincipal( apr, paymentsPerMonth, numberOfPayments ).calculate();
				displayResults();
				break;
			default: System.out.println("\nPlease try again.\n");
				displayMenu();
				break;
		}
	}
	
	
	// PUBLIC Methods
	public void displayMenu() {
		System.out.println("Please select an option: \n\n "
				+ "1) Principal, APR, Payment per Month (Caclulate Number of Payments) \n "
				+ "2) Principal, APR, Number of Payments (Calculate Payment per Month) \n "
				+ "3) Principal, Number of Payments, Payment per Month (Calculate APR) \n "
				+ "4) APR, Number of Payments, Payment per Month (Calculate Principal)");
		System.out.print(">: ");
		redirectMenuSelection ( input.next() );
	}

	public void instructions() {
		System.out.println("Welcome to the Finance Caclulator! \n\nThis application will provide the data for the following four items:\n\n"
				+ " 1. Principal Amount \n 2. Annual Percentage Rate (APR) \n 3. Payment Amount per Month \n 4. Total Number of Payments \n\n"
				+ "You will select an option in which you enter the data for three of the four options, \nthen the application will provide the data for the fourth option."
				+ "\n\nEnjoy!\n");
	}
	
}
