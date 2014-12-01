package bjfu.em.se.posweb.domain;

/**
 * 销售单项
 * 代表顾客所购买的每一种商品(同一种商品可能会购买好几个)
 * @author Roy
 *
 */
public class SalesLineItem {
	private ProductDescription desc;
	private int quantity;
	public SalesLineItem(ProductDescription desc, int qty) {
		this.desc=desc;
		this.quantity=qty;
	}
	public ProductDescription getProductDescription() {
		return desc;
	}
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * 计算单项商品的金额
	 * @return 商品金额
	 */
	public int getSubTotal() {
		return quantity * desc.getPrice();
	}

}
