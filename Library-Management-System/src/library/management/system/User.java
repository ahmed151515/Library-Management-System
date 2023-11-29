/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;



/**
 *
 * @author PC
 */
public class User
{
    // Properties
    
    private String username;
    private String password;
    private String email;
    
    // methods

    
    public User()
    {
        this.username = null;
        this.password = null;
        this.email = null;
    }
    public User(String username, String password, String email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void set_Username_And_Password(String username, String password)
    {
        if (username.isEmpty() && password.isEmpty())
        {
            System.out.println("Error: username or password is empty");
            return;
        }
        if (password.length() < 4)
        {
            System.out.println("Error: password less than 4");
            return;
        }
        
        this.username = username;
        this.password = password;
        
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
