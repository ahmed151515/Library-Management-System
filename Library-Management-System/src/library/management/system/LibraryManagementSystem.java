/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library.management.system;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class LibraryManagementSystem
{
    static String url = "jdbc:sqlserver://192.168.1.12:1433;"
            + "Database=Library_Management_System;"
//            + "IntegratedSecurity=true;"
            + "encrypt=true;"
            + "trustServerCertificate=true";
    static  String user = "admin";
    static  String password = "admin";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Database DB = new Database(url, user, password);

        ResultSet rs = DB.select_stmt("*", "users", "user_id = 2");
        rs.next();
        User user1 = new User(rs.getInt(1),rs.getString(2),rs.getString(3));

        System.out.println("id: " + user1.getUser_ID() + " passwrod: " + user1.getPassword() + " email: "+ user1.getEmail());

        user1.setPassword("99999");
        user1.setEmail("8768@gmail.com");

        int i = DB.update_user(user1);


        DB.close();
    }
    
}
