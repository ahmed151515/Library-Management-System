package library.management.system;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

/**
 * Database - to handel database part
 */
public class Database {
	static String url = "jdbc:sqlserver://"
			+ "192.168.1.12:1433;" // server name or IP and port
			+ "Database=Library_Management_System;" // database name
//            + "IntegratedSecurity=true;" // if you want use Windows Authentication
			+ "encrypt=true;"
			+ "trustServerCertificate=true";
	static String user = "admin";
	static String password = "admin";
	private static Connection con;

	static {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static PreparedStatement stmt;
	private static String sql;


	public Connection getCon() {
		return con;
	}

	public PreparedStatement getStmt() {
		return stmt;
	}

//	public Database(String url) throws SQLException {
//		try {
//			con = DriverManager.getConnection(url);
//		} catch (SQLException e) {
//			System.out.println("Connection failure");
//		}
//	}
//
//	public Database(String url, String usre, String password) throws SQLException {
//		try {
//			con = DriverManager.getConnection(url, usre, password);
//		} catch (SQLException e) {
//			System.out.println("Connection failure");
//		}
//	}

	// close Connection
	public void close() throws SQLException {
		stmt.close();
		con.close();
	}

	public void close_stmt() throws SQLException {
		stmt.close();
	}


	// count users to set count in user
	public static int count_users() throws SQLException {

		int count = 0;
		sql = "select COUNT(user_ID) from users;";
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			stmt.close();

		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}
		return count;
	}

	// count books to set count in book
	public static int count_books() throws SQLException {

		int count = 0;
		sql = "select COUNT(book_ID) from books;";
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			stmt.close();

		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}
		return count;
	}

	// handle select Statement
	public ResultSet select_stmt(String columns, String tables) throws SQLException {
		sql = "select " + columns + " from " + tables + ";";

		try {
			stmt = con.prepareStatement(sql);
			return stmt.executeQuery();
		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}
		return null;
	}

	// handle select Statement and where
	public ResultSet select_stmt(String columns, String tables, String conditions) throws SQLException {
		sql = "select " + columns + " from " + tables + " where " + conditions + ";";
		try {
			stmt = con.prepareStatement(sql);
			return stmt.executeQuery();
		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}
		return null;
	}

	// handle insert Statement to user
	public int insert_user(User user) throws SQLException {
		sql = "insert into users values (?,?,?);";
		int result = 0;
		try {


			stmt = con.prepareStatement(sql);

			stmt.setInt(1, user.getUser_ID());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}

		return result;
	}

	public int update_user(User user) throws SQLException {
		sql = "update users set password=?, email=? where user_id = ?;";
		int result = 0;
		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(3, user.getUser_ID());
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getEmail());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}

		return result;
	}

	public int delete_user(User user) throws SQLException {
		sql = "delete from users where user_ID=?;";
		int result = 0;
		try {


			stmt = con.prepareStatement(sql);

			stmt.setInt(1, user.getUser_ID());

			result = stmt.executeUpdate();

		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}

		return result;
	}

	// handle insert Statement to book
	public int insert_book(Admin admin, Book book) throws SQLException, IOException {
		for (String category : book.getCategory()) {

			sql = "insert into book_categorise values (?,?);";
			try {
				stmt = con.prepareStatement(sql);

				stmt.setInt(1, book.getBook_id());
				stmt.setString(2, category);

				stmt.executeUpdate();
				stmt.close();

			} catch (Exception e) {
				stmt.close();
				System.out.println(e);
			}
		}

		sql = "insert into books values (?,?,?,?,?,?,?);";
		int result = 0;

		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, book.getBook_id());
			stmt.setString(2, book.getName());
			stmt.setInt(3, book.getNum_page());
			stmt.setString(4, book.getDescribtion());
			stmt.setString(5, book.getAuthor_name());
			stmt.setBoolean(6, book.isTranslator());

			stmt.setInt(7, admin.getUser_ID());

			result = stmt.executeUpdate();
		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}

		return result;
	}

	public int update_book(Admin admin, Book book) throws SQLException, IOException {
		for (String category : book.getCategory()) {

			sql = "update book_categorise set category=? where book_ID=?;";
			try {
				stmt = con.prepareStatement(sql);

				stmt.setInt(2, book.getBook_id());
				stmt.setString(1, category);

				stmt.executeUpdate();
				stmt.close();
			} catch (Exception e) {
				stmt.close();
				System.out.println(e);
			}
		}

		sql = "update books set" + " book_name=?," // 1
				+ " num_page=?,"  // 2
				+ " book_descnbtion=?," // 3
				+ " book_author=?,"  // 4
				+ " is_translator=?,"  // 5

				+ " admin_ID=?"  // 7
				+ " where book_ID=?;"; // 8
		int result = 0;

		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(8, book.getBook_id());
			stmt.setString(1, book.getName());
			stmt.setInt(2, book.getNum_page());
			stmt.setString(3, book.getDescribtion());
			stmt.setString(4, book.getAuthor_name());
			stmt.setBoolean(5, book.isTranslator());

			stmt.setInt(6, admin.getUser_ID());

			result = stmt.executeUpdate();

		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}


		return result;
	}

	public int delete_book(Admin admin, Book book) throws SQLException, IOException {


		sql = "delete from book_categorise where book_ID=?;";
		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(2, book.getBook_id());

			stmt.executeUpdate();
		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}


		sql = "delete from books where book_ID=?;";
		int result = 0;
		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, book.getBook_id());
			stmt.executeUpdate();

			result = stmt.executeUpdate();
		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}
		return result;
	}

	// handle insert Statement to borrow
	public int insert_borrow(Borrow borrow) throws SQLException {

		java.sql.Date date;
		sql = "insert into user_borrow_books values (?,?,?,?,?);";
		int result = 0;
		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, borrow.getUser_id());
			stmt.setInt(2, borrow.getAdmin_id());
			date = java.sql.Date.valueOf(borrow.getStart_date());
			stmt.setDate(3, date);
			date = java.sql.Date.valueOf(borrow.getEnd_date());
			stmt.setDate(4, date);
			stmt.setInt(5, borrow.getBook_id());

			result = stmt.executeUpdate();
		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}
		return result;
	}

	public int update_borrow(Borrow borrow) throws SQLException {

		java.sql.Date date;
		sql = "update user_borrow_books set " + "user_ID=?," + " admin_ID=?," + " strart_date=?," + " end_date=?" + "where book_id=?;";
		int result = 0;
		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, borrow.getUser_id());
			stmt.setInt(2, borrow.getAdmin_id());
			date = java.sql.Date.valueOf(borrow.getStart_date());
			stmt.setDate(3, date);
			date = java.sql.Date.valueOf(borrow.getEnd_date());
			stmt.setDate(4, date);
			stmt.setInt(5, borrow.getBook_id());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}
		return result;
	}

	public int delete_borrow(Borrow borrow) throws SQLException {

		java.sql.Date date;
		sql = "delete from user_borrow_books where book_id=?";
		int result = 0;
		try {
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, borrow.getBook_id());
			result = stmt.executeUpdate();
		} catch (Exception e) {
			stmt.close();
			System.out.println(e);
		}

		return result;
	}


}
