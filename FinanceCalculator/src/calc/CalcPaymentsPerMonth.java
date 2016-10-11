package calc;

/**
 * @author Brandt Jorgensen
 */

public class CalcPaymentsPerMonth {
	
	private double total, convertedAPR, principal, apr, powApr, powNumPay, payPerMonth, lastPayment;
	private int numberOfPayments;
	
	public CalcPaymentsPerMonth( double principal, double apr, int numberOfPayments ){
		this.principal = principal;
		this.apr = ( apr > 0 ) ? apr : 0.001;
		this.numberOfPayments = ( numberOfPayments > 0 ) ? numberOfPayments : 1;
		calculate();
	}

	private void calculate() {
		convertedAPR = (apr / 100) / 12;
		powApr = 1 + convertedAPR;
		powNumPay = -1 * numberOfPayments;
		total = (principal * convertedAPR) / (1 - Math.pow(powApr, powNumPay));
		// final values
		payPerMonth = Math.round( total * 100) / 100.0d;
		lastPayment = principal - ( payPerMonth * (numberOfPayments - 1) );
	}
	
	public double getPayPerMonth() {
		return payPerMonth;
	}
	
	public double getLastPayment() {
		return lastPayment;
	}
}
