package de.javaee8recipes.chapter01.recipe0102;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {
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
			out.println("<title>Servlet SimpleServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Servlet SimpleServlet at " + request.getContextPath() + "</h2>");
			out.println("<br/>Welcome to Java EE Recipes!");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
}
