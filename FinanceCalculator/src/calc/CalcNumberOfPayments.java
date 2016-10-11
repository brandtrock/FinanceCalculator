package calc;

/**
 * @author Brandt Jorgensen
 */

public class CalcNumberOfPayments {
	
	private double total, convertedAPR, principal, apr, paymentPerMonth, logValue;
	
	public CalcNumberOfPayments( double principal, double apr, double paymentPerMonth ) {
		this.principal = principal;
		this.apr = apr;
		this.paymentPerMonth = ( paymentPerMonth > 0 ) ? paymentPerMonth : 1;
	}

	public int calculate() {
		convertedAPR = (apr / 100) / 12;		
		logValue = 1 - ((principal * convertedAPR) / paymentPerMonth);
		total = -1 * ( Math.log(logValue) / Math.log(1 + convertedAPR) );
		return (int)(Math.ceil(total));
	}
}
