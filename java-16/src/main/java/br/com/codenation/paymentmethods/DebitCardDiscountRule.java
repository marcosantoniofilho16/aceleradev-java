package br.com.codenation.paymentmethods;

public class DebitCardDiscountRule implements PriceStrategy {
	
	public static final Double DISCOUNT = 0.95;
	
	@Override
	public Double calculate(Double price) {
		return price * DISCOUNT;
	}

}
