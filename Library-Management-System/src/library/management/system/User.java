/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;


import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class User
{
    // Properties
    private static int count;

    static {
        try {
            count = Database.count_users() + 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int user_ID;
    private String password;
    private String email;
    
    // methods

    
    public User()
    {
        this.user_ID = count;
        this.password = null;
        this.email = null;
        count++;
    }
    public User(String password, String email)
    {
        this.user_ID = count;
        this.password = password;
        this.email = email;
        count++;
    }
    public User(int user_ID,String password, String email)
    {
        this.user_ID = user_ID;
        this.password = password;
        this.email = email;
    }





    public int getUser_ID()
    {
        return user_ID;
    }
    
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() > 4) {
            this.password = password;
        }
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
