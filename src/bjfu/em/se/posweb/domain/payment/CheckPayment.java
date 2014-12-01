package bjfu.em.se.posweb.domain.payment;

public class CheckPayment extends Payment {
	public CheckPayment(int amount){
		super(amount,PaymentType.ByCheck);
	}
}
