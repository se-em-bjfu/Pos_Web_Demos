package bjfu.em.se.posweb.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjfu.em.se.posweb.domain.Sale;
import bjfu.em.se.posweb.domain.Store;

public class SaleInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Store store=(Store)(this.getServletContext().getAttribute("store"));
		Sale s=store.getSales().get(id);
		request.setAttribute("sale", s);
		request.getRequestDispatcher("/WEB-INF/jsp/saleinfo.jsp").forward(request, response);
	}

}
