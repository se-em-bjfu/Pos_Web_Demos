package bjfu.em.se.posweb.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjfu.em.se.posweb.domain.Store;

public class ListSalesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Store store=(Store)(this.getServletContext().getAttribute("store"));
		
		request.setAttribute("sales", store.getSales());
		request.getRequestDispatcher("/WEB-INF/jsp/listsales.jsp").forward(request, response);
	}

}
