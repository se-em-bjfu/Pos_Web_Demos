package bjfu.em.se.posweb.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import bjfu.em.se.posweb.domain.exceptions.PaymentNotEnoughException;
import bjfu.em.se.posweb.domain.exceptions.WrongPaymentTypeException;
import bjfu.em.se.posweb.domain.payment.CashPayment;
import bjfu.em.se.posweb.domain.payment.CheckPayment;
import bjfu.em.se.posweb.domain.payment.CreditCardPayment;
import bjfu.em.se.posweb.domain.payment.Payment;
import bjfu.em.se.posweb.domain.payment.PaymentType;

/**
 * 销售类
 * 一个Sale对象对应现实中的一次购物
 * @author Roy
 *
 */
public class Sale {
	private boolean isComplete=false;
	private List<SalesLineItem> lineItems;
	private Payment payment=null;
	private Date date;
	
	public Sale() {
		lineItems=new ArrayList<SalesLineItem> ();
		date = new Date(); 
	}
	/**
	 * 输入新的购买商品
	 * @param desc 商品信息
	 * @param qty 购买数量
	 */
	void makeLineItem(ProductDescription desc, int qty) {
		SalesLineItem sl=new SalesLineItem(desc,qty);

		lineItems.add(sl);
	}
	
	/**
	 * 标记商品输入结束
	 */
	void becomeComplete() {
		isComplete=true;		
	}
	public int getTotal() {
		int total=0;
		//JavaSE 5引入的集合遍历语法
		for (SalesLineItem item:lineItems){
			total+=item.getSubTotal();
		}
		return total;
	}
	/**
	 * 生成支付
	 * @param amount
	 * @param type
	 * @return
	 * @throws WrongPaymentTypeException 支付类型错误
	 * @throws PaymentNotEnoughException 所付金额不足
	 */
	int makePayment(int amount, String type) throws WrongPaymentTypeException, PaymentNotEnoughException {
		int change=amount-getTotal();
		if (change<0) {
			throw new PaymentNotEnoughException(
				String.format("所付金额%.2f不足,需要%.2f",amount,getTotal()));
		}
		//这里使用了Java 7的String case功能.Java 6无法编译
		switch(type) {
		case "ByCash":
			payment=new CashPayment(amount);
			break;
		case "ByCreditCard":
			payment=new CreditCardPayment(amount);
			break;
		case "ByCheck":
			payment=new CheckPayment(amount);
			break;
		default:
			throw new WrongPaymentTypeException("支付类型"+type+"错误!");
		}
		return change;
	}
	/**
	 * 获取购买的商品列表
	 * @return
	 */
	public List<SalesLineItem> getLineItems() {
		return Collections.unmodifiableList(lineItems);
	}
	/**
	 * 获取支付信息
	 * @return
	 */
	public Payment getPayment() {
		return payment;
	}
	/**
	 * 计算找零
	 * @return
	 */
	public int getChange() {
		return payment.getAmount()-getTotal();
	}
	/**
	 * 获取日期
	 * @return
	 */
	public Date getDate() {
		return date;
	}
	
	
}
