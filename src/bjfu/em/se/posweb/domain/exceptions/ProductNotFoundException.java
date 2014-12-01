package bjfu.em.se.posweb.domain.exceptions;

/**
 * 未找到商品异常
 * @author Roy
 *
 */
public class ProductNotFoundException extends Exception {

	public ProductNotFoundException(String itemId) {
		super("未找到id为"+itemId+"的商品");
	}

}
