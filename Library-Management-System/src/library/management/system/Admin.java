/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class Admin extends User
{

    public Admin()
    {
        super();
    }

    public Admin(int user_ID, String password, String email)
    {
        super(user_ID,password, email);
    }


    public static boolean is_admin(String id, String password) throws SQLException {
        String sql = "SELECT * FROM admins WHERE admin_id=? AND password=?";

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
    
}
