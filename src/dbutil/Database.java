package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	// Database URL
	private static String url = "jdbc:mysql://localhost:3306/xls";
	// Database driver name
	private static String driverName = "com.mysql.jdbc.Driver";
	// Database user name
	private static String userName = "root";
	//Database password
	private static String userPasswd = "";

	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName(driverName).newInstance();
			connection = DriverManager.getConnection(url, userName, userPasswd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static Statement getStatement() {

		Statement statement = null;

		try {
			Class.forName(driverName).newInstance();
			Connection connection = DriverManager.getConnection(url, userName,
					userPasswd);
			statement = connection.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;
	}
	
	public static PreparedStatement getPreparedStatement(String prepare) {
		PreparedStatement ps = null;
		
		try {
			Class.forName(driverName).newInstance();
			Connection connection = DriverManager.getConnection(url, userName,
					userPasswd);
			ps = connection.prepareStatement(prepare);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
}
