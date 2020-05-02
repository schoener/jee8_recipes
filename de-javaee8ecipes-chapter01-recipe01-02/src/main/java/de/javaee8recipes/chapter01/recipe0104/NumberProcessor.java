package de.javaee8recipes.chapter01.recipe0104;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "numberProcessor", urlPatterns = { "/numberProcessor" })
public class NumberProcessor extends HttpServlet {
	private static final long serialVersionUID = 120958383585693513L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			// Place page output here
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet NumberProcessor</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Servlet NumberProcessor at " + request.getContextPath() + "</h2>");
			out.println("<br/>Welcome to Java EE Recipes!");
			out.println("<br/> Numa:" + request.getParameter("numa"));
			out.println("<br/> Numb:" + request.getParameter("numb"));
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
}
