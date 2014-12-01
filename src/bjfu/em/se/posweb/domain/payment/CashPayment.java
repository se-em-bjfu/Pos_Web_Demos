package bjfu.em.se.posweb.domain.payment;

public class CashPayment extends Payment {
	public CashPayment(int amount) {
		super(amount,PaymentType.ByCash);
	}
}
