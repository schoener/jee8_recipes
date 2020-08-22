package de.javaee8recipes.cdi.event;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CDIEvenetServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private CDIEventProducerImpl cdiEventProducer;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head/>");
		writer.println("<body>");
		writer.println("<h1>CDI event fired: </h1>");
		cdiEventProducer.fireEvent(req.getParameter("eventType"));
		writer.println("</body>");
		writer.println("</html>");
	}
}
