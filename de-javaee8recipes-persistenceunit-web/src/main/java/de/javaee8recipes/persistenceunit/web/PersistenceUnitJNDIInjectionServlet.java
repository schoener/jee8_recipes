package de.javaee8recipes.persistenceunit.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.javaee8recipes.persistenceunit.ejb.BookAuthorFacade;

@WebServlet(urlPatterns = "/persistenceunitjndiinjection")
public class PersistenceUnitJNDIInjectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BookAuthorFacade bookAuthoerFacade;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head/>");
		writer.println("<body>");
		writer.println("<h1>postgresql database version: </h1>");
		writer.println(bookAuthoerFacade.getDbVersion());
		writer.println("</body>");
		writer.println("</html>");
	}
}
