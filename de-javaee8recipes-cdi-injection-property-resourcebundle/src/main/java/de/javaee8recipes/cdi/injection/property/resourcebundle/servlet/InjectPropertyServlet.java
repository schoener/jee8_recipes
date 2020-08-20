package de.javaee8recipes.cdi.injection.property.resourcebundle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.javaee8recipes.cdi.injection.property.resourcebundle.producer.Property;

@WebServlet(urlPatterns = "/servlet")
public class InjectPropertyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	@Property(key = "firstPropertyKey")
	private String property;
	
	@Inject
	@Property(key = "secondPropertyKey")
	private Double propertyTwo;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head/>");
		writer.println("<body>");
		writer.println("<h1>Output from CDI Bean: </h1>");
		writer.println(property);
		writer.println(propertyTwo);
		writer.println("</body>");
		writer.println("</html>");
	}
}
