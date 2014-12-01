package bjfu.em.se.posweb.domain.payment;

public class CreditCardPayment extends Payment {
	public CreditCardPayment(int amount) {
		super(amount,PaymentType.ByCreditCard);
	}
}
