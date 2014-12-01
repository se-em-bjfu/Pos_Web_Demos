package bjfu.em.se.posweb.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjfu.em.se.posweb.domain.Register;

public class MakePaymentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Register register=(Register)(request.getSession().getAttribute("register"));
			//输入的金额单位为元，但业务层内部所用单位为分
			int amount=100*Integer.parseInt(request.getParameter("amount"));
			String type=request.getParameter("type");
			int change=register.makePayment(amount, type);
			
			request.setAttribute("change", change);
			request.setAttribute("total", register.getSale().getTotal());
			request.setAttribute("amount", amount);
			request.getRequestDispatcher("/WEB-INF/jsp/paymentok.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}
