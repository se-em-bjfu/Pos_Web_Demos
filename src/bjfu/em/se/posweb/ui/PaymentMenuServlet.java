package bjfu.em.se.posweb.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjfu.em.se.posweb.domain.Register;
import bjfu.em.se.posweb.domain.payment.PaymentType;

/**
 * Servlet implementation class PaymentMainServlet
 */
public class PaymentMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Register register=(Register)(request.getSession().getAttribute("register"));
		request.setAttribute("total", register.getSale().getTotal());
		request.setAttribute("paymentTypes", PaymentType.values());
		request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);
	}

}
