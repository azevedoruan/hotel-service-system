package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		if (connection == null) {
			try {
				Properties prop = loadProperties();
				String url = prop.getProperty("dburl");
				connection = DriverManager.getConnection(url, prop);
			} catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
		return connection;
	}
	
	public static Properties loadProperties() {

		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties properties = new Properties();
			properties.load(fs);
			return properties;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeConnection() {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st) {

		try {
			st.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeResultSet(ResultSet rs) {

		try {
			rs.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}
