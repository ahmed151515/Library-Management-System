/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author PC
 */
public class Book extends Database {
	private static int count;

	static {
		try {
			count = count_books() + 1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private int book_id;
	private String name;
	private int num_page;
	private ArrayList<String> category;
	private String author_name;

	private String describtion;
	private int admin_id;


	public Book() {
		this.book_id = count++;
		this.name = null;
		this.num_page = 0;
		this.category = null;
		this.author_name = null;
		this.describtion = null;
		this.admin_id = 0;


	}



	public Book(String name, int num_page, ArrayList<String> category,
	            String author_name, String describtion, int admin_id) {
		this.book_id = count++;
		this.name = name;
		this.num_page = num_page;
		this.category = category;
		this.author_name = author_name;
		this.describtion = describtion;

		this.admin_id = admin_id;

	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		if (book_id < 0) {
			System.out.println("Error: book_id is less than 0");
			return;
		}
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isEmpty()) {
			System.out.println("Error: name is empty");
			return;
		}
		this.name = name;
	}

	public int getNum_page() {
		return num_page;
	}

	public void setNum_page(int num_page) {
		this.num_page = num_page;
	}

	public ArrayList<String> getCategory() {
		return category;
	}

	public void setCategory(ArrayList<String> category) {
		this.category = category;
	}

	public String getAuthor_name() {

		return author_name;
	}

	public void setAuthor_name(String author_name) {
		if (author_name.isEmpty()) {
			System.out.println("Error: author name is empty");
			return;
		}
		this.author_name = author_name;
	}



	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public static int count_books() throws SQLException {
		int count = 0; // Variable to store the number of books.

		// SQL query to count the rows in the 'books' table.
		String sql = "SELECT max(book_id) FROM books;";

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
			e.printStackTrace();
		}

		// Return the total count of books.
		return count;
	}


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


	/**
	 * Inserts a new book record into the 'books' table in the database.
	 *
	 * This method prepares and executes an SQL query to insert book details into the 'books' table.
	 * Additionally, it invokes the insert_categorise method to handle the insertion of book categories.
	 *
	 * @return The number of rows affected by the insert operation.
	 * @throws SQLException If a database access error occurs.
	 */
	@Override
	public int insert() throws SQLException {
		// SQL query to insert values into the 'books' table.
		String sql = "INSERT INTO books VALUES (?,?,?,?,?,?);";
		int result = 0;

		try {
			// Prepare the statement for executing the first insert query.
			stmt = con.prepareStatement(sql);

			// Set the values for the placeholders in the prepared statement.
			stmt.setInt(1, getBook_id());
			stmt.setString(2, getName());
			stmt.setInt(3, getNum_page());
			stmt.setString(4, getDescribtion());
			stmt.setString(5, getAuthor_name());
			stmt.setInt(6, getAdmin_id());

			// Execute the first insert query and store the result.
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// Handle SQL exceptions, close the statement, and print the error.
			e.printStackTrace();
		} finally {
			stmt.close();
		}

		// Insert book categories using the insert_categorise method.
		insert_categorise();

		return result;
	}


	private int[] insert_categorise() throws SQLException {
		// Insert book categories into the 'book_categories' table.


		try {
			// Prepare the statement for executing the second insert query.
			sql = "INSERT INTO book_categorise VALUES (?,?,?);";
			stmt = con.prepareStatement(sql);
			for (int i = 0; i < category.size(); i++) {


				// Set the values for the placeholders in the prepared statement.
				stmt.setInt(1, getBook_id());
				stmt.setString(2, category.get(i));
				stmt.setInt(3, i);

				// Execute the second insert query.
				stmt.addBatch();


			}
			return stmt.executeBatch();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			e.printStackTrace();
		} finally {
			stmt.close();

		}


		return null;
	}

	// This function updates a book's information in the 'books' table and its
	// categories in the 'book_categorise' table.
	// It requires an Admin object for authorization and a Book object for book
	// details.

	private int[] update_categorise(ArrayList<String> category) throws SQLException {
//		handle_edit_categorise(category.size());
		String sql = "delete from book_categorise WHERE book_ID=?";

		stmt = con.prepareStatement(sql);

		stmt.setInt(1, book_id);
		stmt.executeUpdate();
		stmt.close();

		return insert_categorise();

	}

	@Override
	public int update() throws SQLException {
		update_categorise(category);
		// Update book information in the 'books' table.
		String sql = "UPDATE books SET"
				+ " book_name=?," // 1
				+ " num_page=?," // 2
				+ " book_descnbtion=?," // 3
				+ " book_author=?," // 4
				+ " admin_ID=?" // 5
				+ " WHERE book_ID=?;"; // 7
		int result = 0;

		try {
			// Prepare the statement for executing the update query.
			stmt = con.prepareStatement(sql);

			// Set the values for the placeholders in the prepared statement.
			stmt.setString(1, getName());
			stmt.setInt(2, getNum_page());
			stmt.setString(3, getDescribtion());
			stmt.setString(4, getAuthor_name());
			stmt.setInt(5, getAdmin_id());
			stmt.setInt(6, getBook_id());

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

	// This function deletes a book from the 'books' table along with its categories
	// from the 'book_categorise' table.
	// It is assumed that the book deletion does not require admin authorization.
	@Override
	public int delete() throws SQLException {
		// Delete book categories from the 'book_categorise' table.
		String sql = "DELETE FROM book_categorise WHERE book_ID=?;";
		try {
			// Prepare the statement for executing the delete query.
			stmt = con.prepareStatement(sql);

			// Set the value for the placeholder in the prepared statement.
			stmt.setInt(1, getBook_id());

			// Execute the delete query.
			stmt.executeUpdate();
		} catch (Exception e) {
			// Handle exceptions, close the statement, and print the error.
			stmt.close();
			e.printStackTrace();
		}

		// Delete the book from the 'books' table.
		sql = "DELETE FROM books WHERE book_ID=?;";
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

	@Override
	public String toString() {
		return "Book{" +
				"book_id=" + book_id +
				", name='" + name + '\'' +
				", num_page=" + num_page +
				", category=" + category +
				", author_name='" + author_name + '\'' +
				", describtion='" + describtion + '\'' +
				", admin_id=" + admin_id +
				'}';
	}
}
