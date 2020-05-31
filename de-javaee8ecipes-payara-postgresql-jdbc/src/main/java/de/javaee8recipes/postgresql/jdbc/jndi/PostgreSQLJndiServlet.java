package de.javaee8recipes.postgresql.jdbc.jndi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(urlPatterns = "/postgresql")
public class PostgreSQLJndiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		try {
			Connection connection = getDbConnection();
			writer.println("<html>");
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
		}
	}

	public static Connection getDbConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("jdbc/__PostgresqlPool");
			conn = ds.getConnection();
		} catch (NamingException | SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

}
