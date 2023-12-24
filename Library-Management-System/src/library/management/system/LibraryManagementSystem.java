/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library.management.system;


import library.management.system.GUI.GUI;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * @author PC
 */
public class LibraryManagementSystem {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws SQLException, IOException {

		new GUI();
//		addusers();
//		addbook();
//		addborrow();

	}

	static void addusers() throws SQLException {
		User user = new User();
		for (int i = 2; i < 50; i++) {

			user.setUsername("user" + i);
			user.setPassword("user" + i);
			user.setEmail("user" + i + "@gmail.com");
			user.insert();
		}

	}

	static void addbook() throws SQLException {
		Book book = new Book();
		for (int i = 1; i < 100; i++) {

			book.setBook_id(i);
			book.setName("bookname " + i);
			book.setAuthor_name("arafa");
			book.setDescribtion("Describtion " + i);
			book.setNum_page(i);
			book.setAdmin_id(1);
			book.setCategory(new ArrayList<>(Arrays.asList(new String[]{"CS", "SE", "IS"})));

			book.insert();
		}

		System.out.println(Database.stmt.isClosed());
	}

	static void addborrow() throws SQLException {
		Borrow borrow = new Borrow();
		int j = 10;
		for (int i = 1; i < 10; i++) {

			borrow.setUser_id(i + j);
			borrow.setBook_id(i);
			borrow.setEnd_date("2024-" + i + "-" + (i + 10));

			borrow.insert();

		}
	}

}
