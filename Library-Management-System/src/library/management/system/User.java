/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;


import library.management.system.GUI.NLogin;

import java.sql.*;

/**
 * @author PC
 */
public class User extends Database {
	// Properties


	private int user_ID;
	private String username;
	private String password;
	private String email;

	// methods


	public User() {
		this.user_ID = 0;
		this.password = null;
		this.email = null;
	}

	public User(String username,String password, String email) {

		this.username = username;
		this.password = password;
		this.email = email;

	}

	public User(int user_ID,String username, String password, String email) {
		this.user_ID = user_ID;
		this.username = username;
		this.password = password;
		this.email = email;
	}


	public int getUser_ID() {
		return user_ID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.length() > 4) {
			this.password = password;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static boolean is_user(String username, String password) throws SQLException {
		String sql = "SELECT * FROM users WHERE username=? AND password=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			// Set parameters using PreparedStatement to prevent SQL injection.
			stmt.setString(1, username);
			stmt.setString(2, password);

			try (ResultSet resultSet = stmt.executeQuery()) {
				if (resultSet.next()) {
					NLogin.user_id = resultSet.getInt("user_ID");
					return true;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	// This function inserts a new user into the 'users' table.
	@Override
	public  int insert() throws SQLException {
		// SQL query to insert values into the 'users' table.
		String sql = "INSERT INTO users VALUES (?,?, ?);";

		int result = 0; // Variable to store the execution result.

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, getUsername());
			stmt.setString(2, getPassword());
			stmt.setString(3, getEmail());

			// Execute the update query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle any exceptions, close the statement, and print the error message.
			stmt.close();
			e.printStackTrace();
		} finally {
			stmt.close();
		}

		// Return the result of the execution.
		return result;
	}

	// This function updates user information in the 'users' table based on the user
	// ID.
	@Override
	public  int update() throws SQLException {
		// SQL query to update user information in the 'users' table.
		String sql = "UPDATE users SET username=? password=?, email=? WHERE user_id = ?;";

		int result = 0; // Variable to store the execution result.

		try {
			// Prepare the statement for execution.
			stmt = con.prepareStatement(sql);

			// Set the values for the placeholders in the prepared statement.
			stmt.setString(1, getUsername());
			stmt.setString(2, getPassword());
			stmt.setString(3, getEmail());
			stmt.setInt(4, getUser_ID());

			// Execute the update query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle any exceptions, close the statement, and print the error message.
			stmt.close();
			e.printStackTrace();
		} finally {
			stmt.close();
		}

		// Return the result of the execution.
		return result;
	}

	// This function deletes a user from the 'users' table based on the user ID.
	@Override
	public  int delete() throws SQLException {
		// SQL query to delete a user from the 'users' table.
		String sql = "DELETE FROM users WHERE user_ID=?;";

		int result = 0; // Variable to store the execution result.

		try {
			// Prepare the statement for execution.
			stmt = con.prepareStatement(sql);

			// Set the value for the placeholder in the prepared statement.
			stmt.setInt(1, getUser_ID());

			// Execute the delete query and store the result.
			result = stmt.executeUpdate();
		} catch (Exception e) {
			// Handle any exceptions, close the statement, and print the error message.
			stmt.close();
			e.printStackTrace();
		} finally {
			stmt.close();
		}

		// Return the result of the execution.
		return result;
	}
}
