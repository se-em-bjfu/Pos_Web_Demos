package bjfu.em.se.posweb.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjfu.em.se.posweb.domain.Register;
import bjfu.em.se.posweb.domain.Store;

public class MakeNewSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Register register=(Register)(request.getSession().getAttribute("register"));
		register.makeNewSale();
		//回到销售处理界面
		response.sendRedirect("saleMenu.do");		
	}

}
