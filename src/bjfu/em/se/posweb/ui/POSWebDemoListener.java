package bjfu.em.se.posweb.ui;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bjfu.em.se.posweb.domain.ProductCatalog;

/**
 * Application Lifecycle Listener implementation class POSWebDemoListner
 *
 */
public class POSWebDemoListener implements ServletContextListener {

	/**
     * 在Web App开始运行时被调用
     * 用于程序初始化
     */
    public void contextInitialized(ServletContextEvent event) {
        ProductCatalog productCatalog=new ProductCatalog();
		productCatalog.addProductDescription("1", "面包", "好吃的面包", 400);
		productCatalog.addProductDescription("2", "香肠", "好吃的香肠", 350);
		productCatalog.addProductDescription("3", "榨菜", "好吃的榨菜", 050);
		productCatalog.addProductDescription("4", "方便面", "好吃的方便面", 300);
		productCatalog.addProductDescription("5", "可乐", "好喝的可乐", 200);
		productCatalog.addProductDescription("6", "饼干", "好吃的饼干", 430);
		productCatalog.addProductDescription("7", "蛋糕", "好吃的蛋糕", 680);
		productCatalog.addProductDescription("8", "牛奶", "盒装牛奶", 530);
		productCatalog.addProductDescription("9", "煮鸡蛋", "好吃的鸡蛋", 150);
		productCatalog.addProductDescription("10", "鸡腿", "好吃的鸡腿", 1200);        
        bjfu.em.se.posweb.domain.Store store=new bjfu.em.se.posweb.domain.Store("学院路美廉美",productCatalog);
        
        //将初始化好的Store对象放到Application Context中
        event.getServletContext().setAttribute("store", store);
}

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        
    }
	
}
