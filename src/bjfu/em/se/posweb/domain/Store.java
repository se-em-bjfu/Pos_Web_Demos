package bjfu.em.se.posweb.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bjfu.em.se.posweb.domain.exceptions.RegisterLoginFailException;
import bjfu.em.se.posweb.domain.exceptions.RegisterNotFoundException;

/**
 * 超市对象
 * @author Roy
 *
 */
public class Store {
	List<Sale> completedSales;
	Map<String,Register> registers;
	ProductCatalog productCatalog;
	String name;
	

	public Store(String name,ProductCatalog catalog) {
		this.name=name;
		this.productCatalog=catalog;
		completedSales=new ArrayList<Sale>();
		//初始化收银台哈希表

		registers=new HashMap<String,Register>();
		Register register=new Register("1","1号收银台",this,catalog);
		//ip 127.0.0.1 对应 1号收银台
		registers.put("127.0.0.1",register);
		//ipv6地址  0:0:0:0:0:0:0:1 对应 1号收银台
		registers.put("0:0:0:0:0:0:0:1", register);
		
	}



	/**
	 * 收银员登陆
	 * @param cashierId 收银员id
	 * @param password 收银员密码
	 * @param ipAddr 收银员登陆ip
	 * @return 收银员所在的收银台对象
	 * 
	 * 服务器应根据收银员登陆的ip来确定他所在的收银台
	 * @throws RegisterNotFoundException 未找到ip地址对应的收银台
	 * @throws RegisterLoginFailException 收银台登陆失败 
	 */
	public Register login(String cashierId, String password, String ipAddr) throws RegisterNotFoundException, RegisterLoginFailException {
		Register register=registers.get(ipAddr);
		if (register==null) 
			throw new RegisterNotFoundException("未找到"+ipAddr+"对应的收银台");
		if (!register.login(cashierId,password)) {
			throw new RegisterLoginFailException("用户名/密码错误!");
		}
		return register;
	}

	void addSale(Sale sale) {
		completedSales.add(sale);
	}
	
	/**
	 * 获取已完成销售列表
	 * @return
	 */
	public List<Sale> getSales() {
		return Collections.unmodifiableList(completedSales);
	}
	
	

}
