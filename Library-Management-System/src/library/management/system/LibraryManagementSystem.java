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
    static String url = "jdbc:sqlserver://"
            + "192.168.1.12:1433;" // server name or IP and port
            + "Database=Library_Management_System;" // database name
//            + "IntegratedSecurity=true;" // if you want use Windows Authentication
            + "encrypt=true;"
            + "trustServerCertificate=true";
    static  String user = "admin";
    static  String password = "admin";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Database DB = new Database(url, user, password);


        User ahmed = new User("12345", "12345@gmail.com");

        DB.insert_user(ahmed);


        DB.close();
    }
    
}
