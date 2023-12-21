package library.management.system;

import java.io.IOException;
import java.sql.*;

/**
 * Database class handles the interaction with the database for the Library
 * Management System.
 * It provides methods for executing SQL queries and updates related to users,
 * books, and borrowing records.
 */
public abstract class Database {
	// Database connection details
	private static final String url =
			"jdbc:sqlserver://"
			+ "SQL8006.site4now.net:1433;" // server name or IP and port (POWER)  (DESKTOP-BBEFQFU)
			+ "Database=db_aa3272_ahmed1515;" // database name
//			 + "IntegratedSecurity=true;" // if you want to use Windows Authentication
			+ "encrypt=true;"
			+ "trustServerCertificate=true";
	private static final String user = "db_aa3272_ahmed1515_admin";
	private static final String password = "76549#$gcg";

	// Database connection object
	protected static Connection con;

	// PreparedStatement and SQL statement for queries
	protected static PreparedStatement stmt;
	protected static String sql;

	/*
	 * Static block to establish a connection to the database when the class is
	 * loaded.
	 * Throws a RuntimeException if a connection cannot be established.
	 */
	static {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static java.sql.Connection getCon() {
		return con;
	}

	public static PreparedStatement getStmt() {
		return stmt;
	}

	// close Connection
	public static void close() throws SQLException {

		stmt.close();
		con.close();
	}

	public static void close_stmt() throws SQLException {

		stmt.close();
	}

	// count users to set count in user
	// public static int count_users() throws SQLException {
	//
	// int count = 0;
	// sql = "select COUNT(user_ID) from users;";
	// try {
	// stmt = con.prepareStatement(sql);
	// ResultSet rs = stmt.executeQuery();
	// if (rs.next()) {
	// count = rs.getInt(1);
	// }
	// stmt.close();
	//
	// } catch (Exception e) {
	// stmt.close();
	// System.out.println(e);
	// }
	// return count;
	// }
	//

	// This function counts the number of books in the database.


	// This function executes a SELECT statement on the database and returns the
	// ResultSet.
	public static ResultSet select_stmt(String columns, String tables) throws SQLException {
		// Construct the SQL query by concatenating columns and tables.
		String sql = "SELECT " + columns + " FROM " + tables + ";";

		try {
			// Prepare the statement and execute the query.
			stmt = con.prepareStatement(sql);
			return stmt.executeQuery();
		} catch (Exception e) {
			// Handle any exceptions, close the statement, and print the error message.
			close_stmt();
			System.out.println(e);
		}

		// Return null in case of an exception or no result.
		return null;
	}

	// This function executes a parameterized SELECT statement on the database and
	// returns the ResultSet.
	public static ResultSet select_stmt(String columns, String tables, String conditions) throws SQLException {
		// Construct the SQL query by concatenating columns, tables, and conditions.
		String sql = "SELECT " + columns + " FROM " + tables + " WHERE " + conditions + ";";

		try {
			// Prepare the statement and execute the query.
			stmt = con.prepareStatement(sql);
			return stmt.executeQuery();
		} catch (Exception e) {
			// Handle any exceptions, close the statement, and print the error message.
			close_stmt();
			System.out.println(e);
		}

		// Return null in case of an exception or no result.
		return null;
	}


	public abstract int insert() throws SQLException;
	public abstract int update()throws SQLException;
	public abstract int delete()throws SQLException;


}
