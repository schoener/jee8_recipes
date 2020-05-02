package de.javaee8recipes.chapter01.recipe0104;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "de-javaee8ecipes-chapter01-recipe01-04", urlPatterns = {
		"/de-javaee8ecipes-chapter01-recipe01-04" })
public class NoWebappSimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 120958383585693513L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("RESPONSE_HEADER_FLAG", "false");
		PrintWriter out = response.getWriter();
		try {
			// Place page output here
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet NoWebappSimpleServlet!!!</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Servlet NoWebappSimpleServlet!!!! at " + request.getContextPath() + "</h2>");
			out.println("<br/>Welcome to Java EE Recipes!");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
}
