package de.javaee8recipes.cdi.injection.implicit.bean.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.javaee8recipes.cdi.injection.implicit.bean.impl.CDIBeanImpl;

@WebServlet(urlPatterns = "/implicit-bean-archive")
public class ImplicitBeanArchiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private CDIBeanImpl bean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head/>");
		writer.println("<body>");
		writer.println("<h1>Output from CDI Bean: </h1>");
		writer.println(bean.getMessage());
		writer.println("</body>");
		writer.println("</html>");
	}

}