package bjfu.em.se.posweb.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjfu.em.se.posweb.domain.Register;
import bjfu.em.se.posweb.domain.exceptions.ProductNotFoundException;

/**
 * Servlet implementation class EnterItemServlet
 */
public class EnterItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Register register=(Register)(request.getSession().getAttribute("register"));
			String itemID=request.getParameter("itemID");
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			register.enterItem(itemID, quantity);
			
			//回到销售处理界面
			response.sendRedirect("saleMenu.do");
		} catch (ProductNotFoundException e) {
			throw new ServletException(e);
		}
			
	}

}
