/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

import library.management.system.GUI.NLogin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author PC
 */
public class Admin extends User {

	public Admin() {
		super();
	}

	public Admin(int user_ID, String username, String password, String email) {
		super(user_ID, username, password, email);
	}


	public static boolean is_admin(String username, String password) throws SQLException {
		String sql = "SELECT * FROM admins WHERE username=? AND password=?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			// Set parameters using PreparedStatement to prevent SQL injection.
			stmt.setString(1, username);
			stmt.setString(2, password);

			try (ResultSet resultSet = stmt.executeQuery()) {
				if (resultSet.next()) {
					NLogin.user_id = resultSet.getInt("admin_ID");
					return true;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

}
