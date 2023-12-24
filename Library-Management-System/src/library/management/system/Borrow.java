package library.management.system;


import java.sql.*;



public class Borrow extends Database {

	private int user_id;

	private int book_id;
	private String start_date;
	private String end_date;

	public Borrow(int user_id, int book_id, String end_date) {
		this.user_id = user_id;
		this.book_id = book_id;
		this.end_date = end_date;
	}
	public Borrow() {
		this.user_id = 0;
		this.book_id = 0;
		this.end_date = null;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getStart_date() {
		return start_date;
	}
	public Date getStart_date_as_sqlFormat() {
		return Date.valueOf(start_date);
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}
	public Date getEnd_date_as_sqlFormat() {
		return Date.valueOf(end_date);
	}
	/**
	* must format yyyy-mm-dd
	*/
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	// handle insert Statement to borrow
	// This function inserts a record of a user borrowing a book into the
	// 'user_borrow_books' table.
	@Override
	public  int insert() throws SQLException {
		// SQL query to insert values into the 'user_borrow_books' table.
		sql = "INSERT INTO user_borrow_books (user_id, book_id, end_date) VALUES (?,?,?);";
		int result = 0;

		try {
			// Prepare the statement for executing the insert query.
			stmt = con.prepareStatement(sql);

			// Set the values for the placeholders in the prepared statement.
			stmt.setInt(1, getUser_id());
			stmt.setInt(2, getBook_id());
			stmt.setDate(3, getEnd_date_as_sqlFormat());


			// Execute the insert query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			e.printStackTrace();
		} finally {
			stmt.close();
		}

		// Return the result of the insert query.
		return result;
	}

	// This function updates a record of a user borrowing a book in the
	// 'user_borrow_books' table.
	@Override
	public  int update() throws SQLException {
		// SQL query to update values in the 'user_borrow_books' table.
		sql = "UPDATE user_borrow_books SET "
				+ "user_ID=?,"
				+ " start_date=?,"
				+ " end_date=?"
				+ " WHERE book_id=?;";
		int result = 0;

		try {
			// Prepare the statement for executing the update query.
			stmt = con.prepareStatement(sql);

			// Set the values for the placeholders in the prepared statement.
			stmt.setInt(1, getUser_id());
			stmt.setInt(2, getBook_id());
			stmt.setDate(3, getStart_date_as_sqlFormat());
			stmt.setDate(4, getEnd_date_as_sqlFormat());


			// Execute the update query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			e.printStackTrace();
		} finally {
			stmt.close();
		}

		// Return the result of the update query.
		return result;
	}

	// This function deletes a record of a user borrowing a book from the
	// 'user_borrow_books' table.
	@Override
	public  int delete() throws SQLException {
		// SQL query to delete a record from the 'user_borrow_books' table.
		sql = "DELETE FROM user_borrow_books WHERE book_id=?";
		int result = 0;

		try {
			// Prepare the statement for executing the delete query.
			stmt = con.prepareStatement(sql);

			// Set the value for the placeholder in the prepared statement.
			stmt.setInt(1, getBook_id());

			// Execute the delete query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			e.printStackTrace();
		} finally {
			stmt.close();
		}

		// Return the result of the delete query.
		return result;
	}
}
