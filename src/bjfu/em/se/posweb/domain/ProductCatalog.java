package bjfu.em.se.posweb.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 超市商品目录
 * @author Roy
 *
 */
public class ProductCatalog {
	Map<String,ProductDescription> products;
	
	public ProductCatalog() {
		products=new HashMap<String, ProductDescription> ();
	}
	
	/**
	 * 查找某id对应的商品
	 * @param id 商品id
	 * @return 对应的商品信息
	 */
	public ProductDescription getProduct(String id) {
		return products.get(id);
	}
	
	/**
	 * 向产品目录中添加商品
	 * @param id 商品id
	 * @param name 商品名称 
	 * @param description 商品描述
	 * @param price 商品单价
	 */
	public void addProductDescription(String id, String name,String description ,int price){
		ProductDescription desc=new ProductDescription(id,name,description,price);
		products.put(id, desc);
	}
}
