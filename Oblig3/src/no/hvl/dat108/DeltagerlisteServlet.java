package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeltagerlisteServlet
 */
@WebServlet("/DeltagerlisteServlet")
public class DeltagerlisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PersonEAO EAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			request.getSession().setAttribute("liste", EAO.hentPaameldingsListe());
			request.getRequestDispatcher("WEB-INF/deltagerliste_MAL.jsp").forward(request, response);
		} else {
			response.sendRedirect("LogginnServlet");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
