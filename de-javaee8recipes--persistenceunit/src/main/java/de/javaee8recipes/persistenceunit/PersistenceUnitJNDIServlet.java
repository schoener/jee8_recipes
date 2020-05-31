package de.javaee8recipes.persistenceunit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/persistenceunitjndi")
public class PersistenceUnitJNDIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnitJNDI");
		EntityManager em = emf.createEntityManager();
		Query query = em.createNativeQuery("SELECT version()");
		Object result = query.getSingleResult();
		writer.println("<html>");
		writer.println("<head/>");
		writer.println("<body>");
		writer.println("<h1>postgresql database version: </h1>");
		writer.println(result.toString());
		writer.println("</body>");
		writer.println("</html>");
	}
}
