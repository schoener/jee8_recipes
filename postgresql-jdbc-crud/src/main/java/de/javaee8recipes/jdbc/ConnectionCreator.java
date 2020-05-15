package de.javaee8recipes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {

	private static final String JDBC_CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres";

	public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Properties map = new Properties();
		map.put("user", System.getProperty("dbuser"));
		map.put("password", System.getProperty("dbpassword"));
		map.put("ssl", Boolean.FALSE);
		Connection connection = DriverManager.getConnection(JDBC_CONNECTION_URL, map);
		return connection;
	}
}
