package bjfu.em.se.posweb.domain.payment;

/**
 * 支付信息
 * @author Roy
 *
 */
public abstract class Payment {
	protected int amount;
	protected PaymentType type;
	public Payment(int amount, PaymentType type) {
		this.amount = amount;
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public PaymentType getType() {
		return type;
	}	
	
}
