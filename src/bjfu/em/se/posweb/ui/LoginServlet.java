package bjfu.em.se.posweb.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjfu.em.se.posweb.domain.Register;
import bjfu.em.se.posweb.domain.Store;

/**
 * Servlet implementation class MainMenu
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//从Application Context中获取Store对象并登陆
			Store store=(Store)(this.getServletContext().getAttribute("store"));
			Register register=store.login("收银员1","password1",request.getRemoteAddr());
			
			//将收银台对象保存到当前客户端对应的Session Context中
			request.getSession().setAttribute("register", register);
			response.sendRedirect("mainMenu.do");
		} catch (Exception e) {
			//如果登陆出错,则转给JavaEE服务器处理
			throw new ServletException(e);
		}
	}

}
