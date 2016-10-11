package calc;

/**
 * @author Brandt Jorgensen
 */

public class CalcPrincipal {

	private double apr, paymentsPerMonth, total, convertedAPR, powApr, powNumPay;
	private int numberOfPayments;
	
	public CalcPrincipal( double apr, double paymentsPerMonth, int numberOfPayments ){
		this.apr = ( apr > 0 ) ? apr : 0.001;
		this.paymentsPerMonth = paymentsPerMonth;
		this.numberOfPayments = numberOfPayments;
	}

	public double calculate() {		
		convertedAPR = (apr / 100) / 12;
		powApr = 1 + convertedAPR;
		powNumPay = -1 * numberOfPayments;
		total = paymentsPerMonth * (1 - Math.pow(powApr, powNumPay)) / convertedAPR ;
		return Math.round( total * 100) / 100.0d;
	}
	
}
