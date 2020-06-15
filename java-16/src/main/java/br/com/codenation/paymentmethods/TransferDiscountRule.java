package br.com.codenation.paymentmethods;

public class TransferDiscountRule implements PriceStrategy {
	
	public static final Double DISCOUNT = 0.92;
	
	@Override
	public Double calculate(Double price) {
		return price * DISCOUNT;
	}

}
