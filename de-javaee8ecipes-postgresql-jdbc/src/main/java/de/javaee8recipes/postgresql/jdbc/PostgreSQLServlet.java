package de.javaee8recipes.postgresql.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/postgresql")
public class PostgreSQLServlet extends HttpServlet {
	private static final long serialVersionUID = -6640388127891525018L;
	private static final String JDBC_CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		try {
			Connection connection = getDbConnection();
			writer.println("<hprintlntml>");
			writer.println("<head/>");
			writer.println("<body>");
			writer.println("<h1>postgresql database version: </h1>");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT version()");
			while (resultSet.next()) {
				String version = resultSet.getString(1);
				writer.println(version);
			}
			writer.println("</body>");
			writer.println("</html>");
			connection.close();
		} catch (SQLException e) {
			writer.print(e);
		} catch (ClassNotFoundException e) {
			writer.print(e);
		}
	}

	private Connection getDbConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Properties map = new Properties();
		map.put("user", System.getProperty("dbuser"));
		map.put("password", System.getProperty("dbpassword"));
		map.put("ssl", Boolean.FALSE);

		Connection connection = DriverManager.getConnection(JDBC_CONNECTION_URL, map);
		return connection;
	}
}
