package bjfu.em.se.posweb.domain;

import bjfu.em.se.posweb.domain.exceptions.PaymentNotEnoughException;
import bjfu.em.se.posweb.domain.exceptions.ProductNotFoundException;
import bjfu.em.se.posweb.domain.exceptions.WrongPaymentTypeException;
import bjfu.em.se.posweb.domain.payment.PaymentType;

/***
 * 收款台类
 * @author Roy
 *
 */
public class Register {
	private Sale currentSale=null;
	private ProductCatalog productCatalog;
	private Store store;
	private String name;
	private String id;
	
	public Register(String id, String name, Store store, ProductCatalog productCatalog) {
		this.id=id;
		this.name=name;
		this.store=store;
		this.productCatalog=productCatalog;
	}
	
	/**
	 * 收银员登陆
	 * @param cashierId 收银员id
	 * @param password 收银员密码
	 * @return true 登陆成功
	 *         false 登陆失败
	 */
	public boolean login(String cashierId, String password) {
		//TODO 实际处理留作练习题
		return true;
	}
	
	/**
	 * 开始新销售
	 */
	public void makeNewSale(){
		currentSale=new Sale();		
	}
	/**
	 * 输入购买的商品
	 * @param itemId 商品条码
	 * @param qty 商品数量
	 * @return 所购买商品的信息
	 * @throws ProductNotFoundException 
	 */
	public ProductDescription enterItem(String itemId,int qty) throws ProductNotFoundException{
		ProductDescription desc=productCatalog.getProduct(itemId);
		if (desc==null) {
			throw new ProductNotFoundException(itemId);
		}
		currentSale.makeLineItem(desc,qty);
		return desc;
	}
	/**
	 * 结束商品输入
	 * @return 商品总金额(单位为分)
	 */
	public int endSale(){
		currentSale.becomeComplete();
		return currentSale.getTotal();
	}
	/**
	 * 支付
	 * @param amount 
	 * @param type
	 * @return 找零金额(单位为分)
	 * @throws PaymentNotEnoughException 支付金额不足
	 * @throws WrongPaymentTypeException 错误支付类型 
	 */
	public int makePayment(int amount, String type) throws WrongPaymentTypeException, PaymentNotEnoughException{
		int balance=currentSale.makePayment(amount,type);
		store.addSale(currentSale);
		return balance;
	}
	
	/**
	 * 获取当前正在处理的销售对象
	 * @return
	 */
	public Sale getSale() {
		return currentSale;
	}
}
