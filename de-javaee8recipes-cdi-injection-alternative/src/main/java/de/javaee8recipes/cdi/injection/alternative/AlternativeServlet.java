package de.javaee8recipes.cdi.injection.alternative;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet")
public class AlternativeServlet  extends HttpServlet {

		private static final long serialVersionUID = 1L;
		@Inject
		private CDIBean bean;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter writer = resp.getWriter();
			writer.println("<html>");
			writer.println("<head/>");
			writer.println("<body>");
			writer.println("<h1>Beans: </h1>");
			writer.println(bean.getMessage());
			writer.println("<br/>");
			writer.println("</body>");
			writer.println("</html>");
		}

	}
