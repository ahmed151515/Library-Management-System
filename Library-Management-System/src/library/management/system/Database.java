package library.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private Connection con;
	private Statement stmt;

	public Database(String url, String user, String password) throws SQLException {

		con = DriverManager.getConnection(url);
	}
}
