package de.javaee8recipes.cdi.injection.explicit.bean.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.javaee8recipes.cdi.injection.explicit.bean.CDIBean;
import de.javaee8recipes.cdi.injection.explicit.bean.ejb.EJBBean;
import de.javaee8recipes.cdi.injection.explicit.named.bean.NamedBean;

@WebServlet(urlPatterns = "/explicit-bean-archive")
public class ExplicitBeanArchiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private CDIBean bean;
	@Inject
	private NamedBean namedBean;
	@Inject
	private EJBBean ejbBean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head/>");
		writer.println("<body>");
		writer.println("<h1>Output Beans: </h1>");
		writer.println(bean.getMessage());
		writer.println(namedBean.getMessage());
		writer.println(ejbBean.getMessage());
		writer.println("</body>");
		writer.println("</html>");
	}

}