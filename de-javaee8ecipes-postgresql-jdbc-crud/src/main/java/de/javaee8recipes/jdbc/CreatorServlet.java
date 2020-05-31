package de.javaee8recipes.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/creator")
public class CreatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String image = req.getParameter("image");
		int numChapters = Integer.valueOf(req.getParameter("numChapters"));
		int numPages = Integer.valueOf(req.getParameter("numPages"));
		String description = req.getParameter("description");
		Date publishDate = new Date(System.currentTimeMillis());

		try {
			Connection dbConnection = ConnectionCreator.getDbConnection();
			PreparedStatement statement = dbConnection
					.prepareStatement("INSERT INTO BOOK VALUES (BOOK_AUTHOR_S.NEXTVAL, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, title);
			statement.setString(2, image);
			statement.setInt(3, numChapters);
			statement.setInt(4, numPages);
			statement.setString(5, description);
			statement.setDate(6, publishDate);
			boolean dataInserted = statement.execute();
			PrintWriter writer = resp.getWriter();
			writer.println("<html>");
			writer.println("<body>");
			writer.println("data inserted " + dataInserted);
			writer.println("</body>");
			writer.println("</html>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
