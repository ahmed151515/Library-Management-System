/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;

/**
 *
 * @author PC
 */
public class Stuf extends User
{
    private int salary;

    public Stuf(int salary)
    {
        super();
        this.salary = 0;
    }

    public Stuf(int salary, String username, String password, String email)
    {
        super(username, password, email);
        this.salary = salary;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    
    
    
}
