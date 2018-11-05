package no.hvl.dat108;

import static no.hvl.dat108.URLMappings.HANDLELISTE_URL;
import static no.hvl.dat108.URLMappings.LOGIN_URL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Servlet implementation class EnkelHandlelisteServlet
 */
@WebServlet(name = HANDLELISTE_URL, urlPatterns = "/" + HANDLELISTE_URL)
public class EnkelHandlelisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> handleliste;

	@Override
	public void init() throws ServletException {
		handleliste = new ArrayList<String>();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession sesjon = request.getSession(false);
//		String bruker = (String) sesjon.getAttribute("bruker");

		response.setContentType(MediaType.TEXT_HTML);

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Min Handleliste</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>Min handleliste:</h1><br>");
//		out.println("	<p>Halla " + bruker + "!</p>");
		out.println("	<form action=\"" + HANDLELISTE_URL + "\" method=\"post\">");
		out.println("		<input type=\"submit\" value=\"Legg til\" name=\"leggtil\">");
		out.println("		<input type=\"text\" name=\"vare\">");
		out.println("	</form>");
		for (String s : handleliste) {
			out.println("	<form method=\"post\">");
			out.println("		<input type=\"hidden\" name=\"slett\" value=\"" + s
					+ "\"><input type=\"submit\" value=\"Slett\"> " + s + "</form>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);

		if (sesjon == null || sesjon.getAttribute("bruker") == null) {
			response.sendRedirect(LOGIN_URL + "?requiresLogin");
		} else {

			if (request.getParameter("slett") != null 
					&& handleliste.indexOf(StringEscapeUtils.escapeHtml(request.getParameter("slett"))) != -1) {
				synchronized (handleliste) {
					handleliste.remove(handleliste.indexOf(StringEscapeUtils.escapeHtml(request.getParameter("slett"))));
				}
			} else {
				String input = request.getParameter("vare");
				String inputRE = StringEscapeUtils.escapeHtml(input);
				if (inputRE.matches("^\\S+(?: \\S+)*$")) {
					synchronized (handleliste) {
						handleliste.add(inputRE);
					}
				}
			}
			response.sendRedirect(HANDLELISTE_URL);
		}
	}

}
