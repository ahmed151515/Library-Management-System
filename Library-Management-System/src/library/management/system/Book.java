/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.management.system;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.LinkedList;
/**
 *
 * @author PC
 */
public class Book
{
    private static int count;

    static {
        try {
            count = Database.count_books() + 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int book_id;
	private String name;
	private int num_page;
	private LinkedList<String> category;
	private String author_name;
	private boolean  translator;
	private String describtion;
	private File cover_page;

    public Book()
    {
        this.book_id = count;
        this.name = null;
        this.num_page = 0;
        this.category = null;
        this.author_name = null;
        this.translator = false;
        this.describtion = null;
        this.cover_page = null;
        count++;
    }
    
    public Book(String name, int num_page, LinkedList<String> category,
            String author_name, boolean translator, String describtion,
            File cover_page)
    {
        this.book_id = count;
        this.name = name;
        this.num_page = num_page;
        this.category = category;
        this.author_name = author_name;
        this.translator = translator;
        this.describtion = describtion;
        this.cover_page = cover_page;
        count++;
    }

    public int getBook_id()
    {
        return book_id;
    }

    public void setBook_id(int book_id)
    {
        if (book_id < 0)
        {
            System.out.println("Error: book_id is less than 0");
            return;
        }
        this.book_id = book_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if (name.isEmpty())
        {
            System.out.println("Error: name is empty");
            return;
        }
        this.name = name;
    }

    public int getNum_page()
    {
        return num_page;
    }

    public void setNum_page(int num_page)
    {
        this.num_page = num_page;
    }

    public LinkedList<String> getCategory()
    {
        return category;
    }

    public void setCategory(LinkedList<String> category)
    {
        this.category = category;
    }

    public String getAuthor_name()
    {
        
        return author_name;
    }

    public void setAuthor_name(String author_name)
    {
        if (author_name.isEmpty())
        {
            System.out.println("Error: author name is empty");
            return;
        }
        this.author_name = author_name;
    }

    public boolean isTranslator()
    {
        return translator;
    }

    public void setTranslator(boolean translator)
    {
        this.translator = translator;
    }

    public String getDescribtion()
    {
        return describtion;
    }

    public void setDescribtion(String describtion)
    {
        this.describtion = describtion;
    }

    public File getCover_page() {
        return cover_page;
    }

    public void setCover_page(File cover_page) {
        this.cover_page = cover_page;
    }
}
