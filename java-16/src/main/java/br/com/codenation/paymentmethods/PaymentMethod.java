package br.com.codenation.paymentmethods;

public enum PaymentMethod {

	CASH(new CashDiscountRule()), DEBIT_CARD(new DebitCardDiscountRule()), CREDIT_CARD(new CreditCardDiscountRule()),
	TRANSFER(new TransferDiscountRule());

	private PriceStrategy priceStrategy;

	PaymentMethod(PriceStrategy priceStrategy) {
		this.priceStrategy = priceStrategy;
	}

	public PriceStrategy getPaymentStrategy() {
		return priceStrategy;
	}
}