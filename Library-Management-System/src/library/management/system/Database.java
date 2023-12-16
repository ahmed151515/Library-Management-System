package library.management.system;

import java.io.IOException;
import java.sql.*;

/**
 * Database class handles the interaction with the database for the Library
 * Management System.
 * It provides methods for executing SQL queries and updates related to users,
 * books, and borrowing records.
 */
public class Database {
	// Database connection details
	private static final String url = "jdbc:sqlserver://"
			+ "DESKTOP-BBEFQFU;" // server name or IP and port
			+ "Database=Library_Management_System;" // database name
			// + "IntegratedSecurity=true;" // if you want use Windows Authentication
			+ "encrypt=true;"
			+ "trustServerCertificate=true";
	private static final String user = "admin";
	private static final String password = "admin";

	// Database connection object
	private static Connection con;

	// PreparedStatement and SQL statement for queries
	private static PreparedStatement stmt;
	private static String sql;

	/**
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

	public static Connection getCon() {
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
	public static int count_books() throws SQLException {
		int count = 0; // Variable to store the number of books.

		// SQL query to count the rows in the 'books' table.
		String sql = "SELECT COUNT(book_ID) FROM books;";

		try {
			// Prepare and execute the query using PreparedStatement.
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			// Check the results and extract the count.
			if (rs.next()) {
				count = rs.getInt(1);
			}

			// Close the statement to free up resources.
			stmt.close();
		} catch (Exception e) {
			// Handle any exceptions and close the statement.
			stmt.close();
			System.out.println(e);
		}

		// Return the total count of books.
		return count;
	}

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

	public static boolean is_user(String id, String password) throws SQLException {
		String sql = "SELECT * FROM users WHERE user_id=? AND password=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			// Set parameters using PreparedStatement to prevent SQL injection.
			stmt.setString(1, id);
			stmt.setString(2, password);

			try (ResultSet resultSet = stmt.executeQuery()) {

				return resultSet.next();
			}
		} catch (Exception e) {

			System.out.println(e);
		}

		return false;
	}

	// This function inserts a new user into the 'users' table.
	public static int insert_user(User user) throws SQLException {
		// SQL query to insert values into the 'users' table.
		String sql = "INSERT INTO users VALUES (?, ?);";

		int result = 0; // Variable to store the execution result.

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getEmail());

			// Execute the update query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle any exceptions, close the statement, and print the error message.
			stmt.close();
			System.out.println(e);
		}

		// Return the result of the execution.
		return result;
	}

	// This function updates user information in the 'users' table based on the user
	// ID.
	public static int update_user(User user) throws SQLException {
		// SQL query to update user information in the 'users' table.
		String sql = "UPDATE users SET password=?, email=? WHERE user_id = ?;";

		int result = 0; // Variable to store the execution result.

		try {
			// Prepare the statement for execution.
			stmt = con.prepareStatement(sql);

			// Set the values for the placeholders in the prepared statement.
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getEmail());
			stmt.setInt(3, user.getUser_ID());

			// Execute the update query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle any exceptions, close the statement, and print the error message.
			stmt.close();
			System.out.println(e);
		}

		// Return the result of the execution.
		return result;
	}

	// This function deletes a user from the 'users' table based on the user ID.
	public static int delete_user(User user) throws SQLException {
		// SQL query to delete a user from the 'users' table.
		String sql = "DELETE FROM users WHERE user_ID=?;";

		int result = 0; // Variable to store the execution result.

		try {
			// Prepare the statement for execution.
			stmt = con.prepareStatement(sql);

			// Set the value for the placeholder in the prepared statement.
			stmt.setInt(1, user.getUser_ID());

			// Execute the delete query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle any exceptions, close the statement, and print the error message.
			stmt.close();
			System.out.println(e);
		}

		// Return the result of the execution.
		return result;
	}

	// This function retrieves book categories based on the provided book ID.
	public static String getBookCategories(int bookId) throws SQLException {
		// Execute a SELECT statement to retrieve categories for the specified book ID.
		ResultSet resultSet = select_stmt("category", "book_categorise", "book_ID = " + bookId);

		// StringBuilder to store the retrieved categories.
		StringBuilder categories = new StringBuilder();

		// Iterate through the result set and append categories to the StringBuilder.
		while (resultSet.next()) {
			categories.append(resultSet.getString("category")).append(", ");
		}

		// Remove the trailing comma and space if categories are present.
		if (categories.length() > 2) {
			categories.setLength(categories.length() - 2);
		}

		// Return the formatted categories as a string.
		return categories.toString();
	}

	// This function inserts a new book into the 'books' table along with its
	// categories.
	// It requires an Admin object for authorization and a Book object for book
	// details.
	public static int insert_book(Admin admin, Book book) throws SQLException, IOException {
		// SQL query to insert values into the 'books' table.
		String sql = "INSERT INTO books VALUES (?,?,?,?,?,?,?);";
		int result = 0;

		try {
			// Prepare the statement for executing the first insert query.
			stmt = con.prepareStatement(sql);

			// Set the values for the placeholders in the prepared statement.
			stmt.setInt(1, book.getBook_id());
			stmt.setString(2, book.getName());
			stmt.setInt(3, book.getNum_page());
			stmt.setString(4, book.getDescribtion());
			stmt.setString(5, book.getAuthor_name());
			stmt.setBoolean(6, book.isTranslator());
			stmt.setInt(7, admin.getUser_ID());

			// Execute the first insert query and store the result.
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// Handle SQL exceptions, close the statement, and print the error.
			stmt.close();
			e.printStackTrace();
		}

		// Insert book categories into the 'book_categories' table.
		for (String category : book.getCategory()) {
			sql = "INSERT INTO book_categorise VALUES (?,?);";
			try {
				// Prepare the statement for executing the second insert query.
				stmt = con.prepareStatement(sql);

				// Set the values for the placeholders in the prepared statement.
				stmt.setInt(1, book.getBook_id());
				stmt.setString(2, category);

				// Execute the second insert query.
				stmt.executeUpdate();

				// Close the statement.
				stmt.close();
			} catch (Exception e) {
				// Handle exceptions, close the statement, and print the error.
				stmt.close();
				System.out.println(e);
			}
		}

		// Return the result of the first insert query.
		return result;
	}

	// This function updates a book's information in the 'books' table and its
	// categories in the 'book_categorise' table.
	// It requires an Admin object for authorization and a Book object for book
	// details.
	public static int update_book(Admin admin, Book book) throws SQLException, IOException {
		// Update book categories in the 'book_categorise' table.
		for (String category : book.getCategory()) {
			String sql = "UPDATE book_categorise SET category=? WHERE book_ID=?;";
			try {
				// Prepare the statement for executing the update query.
				stmt = con.prepareStatement(sql);

				// Set the values for the placeholders in the prepared statement.
				stmt.setString(1, category);
				stmt.setInt(2, book.getBook_id());

				// Execute the update query.
				stmt.executeUpdate();

				// Close the statement.
				stmt.close();
			} catch (Exception e) {
				// Handle exceptions, close the statement, and print the error.
				stmt.close();
				System.out.println(e);
			}
		}

		// Update book information in the 'books' table.
		String sql = "UPDATE books SET"
				+ " book_name=?," // 1
				+ " num_page=?," // 2
				+ " book_descnbtion=?," // 3
				+ " book_author=?," // 4
				+ " is_translator=?," // 5
				+ " admin_ID=?" // 6
				+ " WHERE book_ID=?;"; // 7
		int result = 0;

		try {
			// Prepare the statement for executing the update query.
			stmt = con.prepareStatement(sql);

			// Set the values for the placeholders in the prepared statement.
			stmt.setString(1, book.getName());
			stmt.setInt(2, book.getNum_page());
			stmt.setString(3, book.getDescribtion());
			stmt.setString(4, book.getAuthor_name());
			stmt.setBoolean(5, book.isTranslator());
			stmt.setInt(6, admin.getUser_ID());
			stmt.setInt(7, book.getBook_id());

			// Execute the update query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			System.out.println(e);
		}

		// Return the result of the update query.
		return result;
	}

	// This function deletes a book from the 'books' table along with its categories
	// from the 'book_categorise' table.
	// It is assumed that the book deletion does not require admin authorization.
	public static int delete_book(Book book) throws SQLException, IOException {
		// Delete book categories from the 'book_categorise' table.
		String sql = "DELETE FROM book_categorise WHERE book_ID=?;";
		try {
			// Prepare the statement for executing the delete query.
			stmt = con.prepareStatement(sql);

			// Set the value for the placeholder in the prepared statement.
			stmt.setInt(1, book.getBook_id());

			// Execute the delete query.
			stmt.executeUpdate();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			System.out.println(e);
		}

		// Delete the book from the 'books' table.
		sql = "DELETE FROM books WHERE book_ID=?;";
		int result = 0;
		try {
			// Prepare the statement for executing the delete query.
			stmt = con.prepareStatement(sql);

			// Set the value for the placeholder in the prepared statement.
			stmt.setInt(1, book.getBook_id());

			// Execute the delete query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			System.out.println(e);
		}

		// Return the result of the delete query.
		return result;
	}

	// handle insert Statement to borrow
	// This function inserts a record of a user borrowing a book into the
	// 'user_borrow_books' table.
	public static int insert_borrow(Borrow borrow) throws SQLException {
		// SQL query to insert values into the 'user_borrow_books' table.
		sql = "INSERT INTO user_borrow_books VALUES (?,?,?,?,?);";
		int result = 0;

		try {
			// Prepare the statement for executing the insert query.
			stmt = con.prepareStatement(sql);

			// Set the values for the placeholders in the prepared statement.
			stmt.setInt(1, borrow.getUser_id());
			stmt.setInt(2, borrow.getAdmin_id());
			java.sql.Date date = java.sql.Date.valueOf(borrow.getStart_date());
			stmt.setDate(3, date);
			date = java.sql.Date.valueOf(borrow.getEnd_date());
			stmt.setDate(4, date);
			stmt.setInt(5, borrow.getBook_id());

			// Execute the insert query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			System.out.println(e);
		}

		// Return the result of the insert query.
		return result;
	}

	// This function updates a record of a user borrowing a book in the
	// 'user_borrow_books' table.
	public static int update_borrow(Borrow borrow) throws SQLException {
		// SQL query to update values in the 'user_borrow_books' table.
		sql = "UPDATE user_borrow_books SET "
				+ "user_ID=?,"
				+ " admin_ID=?,"
				+ " start_date=?,"
				+ " end_date=?"
				+ " WHERE book_id=?;";
		int result = 0;

		try {
			// Prepare the statement for executing the update query.
			stmt = con.prepareStatement(sql);

			// Set the values for the placeholders in the prepared statement.
			stmt.setInt(1, borrow.getUser_id());
			stmt.setInt(2, borrow.getAdmin_id());
			java.sql.Date date = java.sql.Date.valueOf(borrow.getStart_date());
			stmt.setDate(3, date);
			date = java.sql.Date.valueOf(borrow.getEnd_date());
			stmt.setDate(4, date);
			stmt.setInt(5, borrow.getBook_id());

			// Execute the update query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			System.out.println(e);
		}

		// Return the result of the update query.
		return result;
	}

	// This function deletes a record of a user borrowing a book from the
	// 'user_borrow_books' table.
	public static int delete_borrow(Borrow borrow) throws SQLException {
		// SQL query to delete a record from the 'user_borrow_books' table.
		sql = "DELETE FROM user_borrow_books WHERE book_id=?";
		int result = 0;

		try {
			// Prepare the statement for executing the delete query.
			stmt = con.prepareStatement(sql);

			// Set the value for the placeholder in the prepared statement.
			stmt.setInt(1, borrow.getBook_id());

			// Execute the delete query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			System.out.println(e);
		}

		// Return the result of the delete query.
		return result;
	}

}
