package calc;

/**
 * @author Brandt Jorgensen
 */

public class CalcAPR {
	
	private double principal, paymentPerMonth, testPrincipal;
	private int numberOfPayments;

	public CalcAPR( double principal, double paymentPerMonth, int numberOfPayments ){
		this.principal = principal;
		this.paymentPerMonth = paymentPerMonth;
		this.numberOfPayments = numberOfPayments;
	}
	

	private double aprSearch() {
		double mid = 0.0;
		double low = 0.0;
		double high = 100.0;
		
		while ( low <= high ) {
			// set the "mid" which is the temporary APR
			mid = (low + high) / 2;
			
			// Calculate the Principal with the temporary APR 
			testPrincipal = new CalcPrincipal( mid, paymentPerMonth, numberOfPayments ).calculate();
			
			// Modify the temporary APR
			if ( testPrincipal < principal ) {
				high = mid - 0.001;
			} else if ( testPrincipal > principal ) {
				low = mid + 0.001;
			} else {
				return Math.round( mid * 100) / 100.0d; // exact APR
			}
		}
		
		return Math.round( mid * 100) / 100.0d; // approximate APR
	}
	
	public double calculate() {
		return aprSearch();
	}
}
