package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private PersonEAO paameldingEAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/paameldingsskjema_MAL.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Skjema skjema = new Skjema(request);
		if (skjema.AllInputGyldig()) {
			HttpSession sesjon = request.getSession(false);
			Person person = skjema.lagPerson();
			paameldingEAO.leggTil(person);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);
			request.getSession().setAttribute("fornavn", skjema.getFornavn());
			request.getSession().setAttribute("etternavn", skjema.getEtternavn());
			request.getSession().setAttribute("mobil", skjema.getMobil());
			request.getSession().setAttribute("kjonn", skjema.getKjonn());
			request.getSession().removeAttribute("skjema");
			response.sendRedirect("BekreftelseServlet?fornavn=");
		} else {
			skjema.settOppFeilmeldinger();
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("PaameldingServlet");
		
		}
	}
	

}
