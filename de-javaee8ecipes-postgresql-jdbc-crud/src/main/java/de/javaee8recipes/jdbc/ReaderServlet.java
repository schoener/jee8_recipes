package de.javaee8recipes.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/reader")
public class ReaderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Connection connection = ConnectionCreator.getDbConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOK");
			PrintWriter writer = resp.getWriter();
			writer.println("<html>");
			writer.println("<body>");
			writer.println("<table>");
			while (resultSet.next()) {
				long id = resultSet.getLong(1);
				String title = resultSet.getString(2);
				String image = resultSet.getString(3);
				long numChapters = resultSet.getLong(4);
				long numPages = resultSet.getLong(5);
				String description = resultSet.getString(6);
				Date publishDate = resultSet.getDate(7);
				writer.println("<tr>");
				writer.println("<th>" + id + "</th>");
				writer.println("<th>" + title + "</th>");
				writer.println("<th>" + image + "</th>");
				writer.println("<th>" + numChapters + "</th>");
				writer.println("<th>" + numPages + "</th>");
				writer.println("<th>" + description + "</th>");
				writer.println("<th>" + publishDate + "</th>");
				writer.println("</tr>");
			}
			writer.println("</table>");
			writer.println("</body>");
			writer.println("</html>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
