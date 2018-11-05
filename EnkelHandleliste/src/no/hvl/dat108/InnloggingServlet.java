package no.hvl.dat108;

import static no.hvl.dat108.URLMappings.HANDLELISTE_URL;
import static no.hvl.dat108.URLMappings.LOGIN_URL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;;

/**
 * Servlet implementation class HandlelisteServlet
 */
@WebServlet(name = "InnloggingServlet", urlPatterns = "/InnloggingServlet")
public class InnloggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String invalidUser = request.getParameter("InvalidUsername");
		String feilmelding = "";
		if (invalidUser != null) {
			feilmelding = "Feil passord";
		}

		response.setContentType(MediaType.TEXT_HTML);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Login-Handleliste</title>");
		out.println("</head>");
		out.println("<body>");
		if (invalidUser != null) {
			out.println("	<p style=\"color:red\">" + feilmelding + "</p>");
		}
		out.println("	<form action=\"" + LOGIN_URL + "\" method=\"post\">");
		out.println("		<p>Gi inn passord:</p>");
		out.println("		<p>Password: <input type=\"password\" name=\"passord\"></p>");
		out.println("		<p><input type=\"submit\" value=\"Logg inn\"></p>");
		out.println("	</form>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String passord = request.getParameter("passord");

		if (!getInitParameter("passord").equals(passord)) {
			response.sendRedirect(LOGIN_URL + "?InvalidUsername");
		} else {
			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);
			sesjon.setMaxInactiveInterval(Integer.parseInt(getInitParameter("tid")));
			sesjon.setAttribute("bruker", request.getParameter("passord"));
			response.sendRedirect(HANDLELISTE_URL);
		}
	}

}
