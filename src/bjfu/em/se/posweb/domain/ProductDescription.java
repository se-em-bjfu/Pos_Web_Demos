package bjfu.em.se.posweb.domain;

/**
 * 商品信息
 * @author Roy
 *
 */
public class ProductDescription {
	private String id;
	private String name;
	private String description;
	private int price;
	public ProductDescription(String id, String name, String description,
			int price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getPrice() {
		return price;
	}
	
}
