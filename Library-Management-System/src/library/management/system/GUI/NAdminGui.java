/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package library.management.system.GUI;

import library.management.system.Book;
import library.management.system.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ahmed
 */
public class NAdminGui extends javax.swing.JPanel {

	/**
	 * Creates new form NAdminGui
	 */
	public NAdminGui() throws SQLException {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() throws SQLException {


		PanelAdd_Edit_book = new javax.swing.JPanel();
		EditBookButton = new javax.swing.JButton();
		AddBookButton = new javax.swing.JButton();
		ButtonBack = new javax.swing.JButton();
		view_borrow = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();



		EditBookButton.setText("Edit book");
		EditBookButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					editbook(evt);

				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		});


		AddBookButton.setText("Add book");
		AddBookButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addbook(e);
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		});

		ButtonBack.setText("<<<");
		ButtonBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ButtonBackActionPerformed(evt);
			}
		});

		view_borrow.setText("view_borrow");
		view_borrow.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					borrow(e);
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		});

		javax.swing.GroupLayout PanelAdd_Edit_bookLayout = new javax.swing.GroupLayout(PanelAdd_Edit_book);
		PanelAdd_Edit_book.setLayout(PanelAdd_Edit_bookLayout);
		PanelAdd_Edit_bookLayout.setHorizontalGroup(
				PanelAdd_Edit_bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(PanelAdd_Edit_bookLayout.createSequentialGroup()
								.addGap(23, 23, 23)
								.addComponent(ButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(240, 240, 240)
								.addComponent(AddBookButton)
								.addGap(246, 246, 246)
								.addComponent(EditBookButton)
								.addGap(246, 246, 246)
								.addComponent(view_borrow)
								.addContainerGap(323, Short.MAX_VALUE))
		);
		PanelAdd_Edit_bookLayout.setVerticalGroup(
				PanelAdd_Edit_bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(PanelAdd_Edit_bookLayout.createSequentialGroup()
								.addGap(20, 20, 20)
								.addGroup(PanelAdd_Edit_bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(AddBookButton)
										.addComponent(EditBookButton)
										.addComponent(ButtonBack)
										.addComponent(view_borrow))
								.addContainerGap(27, Short.MAX_VALUE))
		);

//        BookTable.setForeground(new java.awt.Color(70, 73, 75));
//        BookTable.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null}
//            },
//            new String [] {
//                "Title 1", "Title 2", "Title 3", "Title 4"
//            }
//        ));
// -------------------------------------------------------------------------------

		String[] columns = {
				"Book ID"
				, "Book Name"
				, "Num Page"
				, "Book Descnbtion"
				, "Book Author"
				, "Admin ID"
				, "categorise"
		};
		model = new DefaultTableModel(columns, 0);
		BookTable = new JTable(model);
		jScrollPane1 = new JScrollPane(BookTable);

// -------------------------------------------------------------------------------

//		ResultSet rs = Database.select_stmt("*", "books");
//
//		while (rs.next()) {
//			String categories = Book.getBookCategories(rs.getInt("book_ID"));
//			Object[] row = {
//					rs.getInt("book_ID")
//					, rs.getString("book_name")
//					, rs.getInt("num_page")
//					, rs.getString("book_descnbtion")
//					, rs.getString("book_author")
//					, rs.getInt("admin_ID")
//					, categories
//			};
//
//			model.addRow(row);
//		}
//		rs.close();
//		Database.close_stmt();
//        jScrollPane1.setViewportView(BookTable);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(PanelAdd_Edit_book, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(PanelAdd_Edit_book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		);
	}// </editor-fold>//GEN-END:initComponents

// -------------------------------------------------------------------------------

	private void editbook(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_jButton1ActionPerformed
		int book_id = Integer.parseInt(JOptionPane.showInputDialog("book ID: "));

		ResultSet rs = Database.select_stmt("*", "books", "book_ID = " + book_id);

		if (rs.next()) {
			EditBook.setData(book_id);
			GUI.cardLayout.show(GUI.frame.getContentPane(), "editBook");
		} else {
			JOptionPane.showMessageDialog(GUI.frame, "not found", "result", JOptionPane.WARNING_MESSAGE);
		}
		rs.close();
		Database.close_stmt();


	}//GEN-LAST:event_jButton1ActionPerformed

	private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
		GUI.cardLayout.show(GUI.frame.getContentPane(), "LoginPanel");
	}//GEN-LAST:event_ButtonBackActionPerformed

	private void addbook(java.awt.event.ActionEvent evt) throws SQLException {


		GUI.cardLayout.show(GUI.frame.getContentPane(), "addBook");

	}

	private void borrow(java.awt.event.ActionEvent evt) throws SQLException {


		GUI.cardLayout.show(GUI.frame.getContentPane(), "borrowGui");
		Borrow_GUI.getData();

	}

	public static void refresh() throws SQLException {
		ResultSet rs;
		if (model.getRowCount() > 0) {
			int max_book_id = Integer.parseInt(
					model.getValueAt(model.getRowCount() - 1
							, model.findColumn("Book ID")).toString()
			);
			rs = Database.select_stmt("*", "books", "book_id > " + max_book_id);
		} else {

			rs = Database.select_stmt("*", "books");
		}
		// must handle delete row
		while (rs.next()) {
			String categories = Book.getBookCategories(rs.getInt("book_ID"));
			Object[] row = {
					rs.getInt("book_ID")
					, rs.getString("book_name")
					, rs.getInt("num_page")
					, rs.getString("book_descnbtion")
					, rs.getString("book_author")
					, rs.getInt("admin_ID")
					, categories
			};

			model.addRow(row);
		}
		rs.close();
		Database.close_stmt();

	}

	public static void refresh(int book_id) throws SQLException {


		ResultSet rs = Database.select_stmt("*", "books", "book_id = " + book_id);

		if (rs.next()) {
			String categories = Book.getBookCategories(rs.getInt("book_ID"));
			Object[] row = {
					rs.getInt("book_ID")
					, rs.getString("book_name")
					, rs.getInt("num_page")
					, rs.getString("book_descnbtion")
					, rs.getString("book_author")
					, rs.getInt("admin_ID")
					, categories
			};
			int rowIndex = findRowIndex(book_id);

			if (rowIndex != -1) {

				for (int i = 0; i < model.getColumnCount(); i++) {
					model.setValueAt(row[i], rowIndex, i);
				}
			}


		}
		rs.close();
		Database.close_stmt();

	}

	private static int findRowIndex(int book_id) {


		for (int i = 0; i < model.getRowCount(); i++) {
			if ((int) model.getValueAt(i, 0) == book_id) {
				return i;
			}
		}
		return -1;
	}

	public static void getData() throws SQLException {
		if (model.getRowCount() > 0) {
			return;
		}

		ResultSet rs = Database.select_stmt("*", "books");

		// must handle delete row
		while (rs.next()) {
			String categories = Book.getBookCategories(rs.getInt("book_ID"));
			Object[] row = {
					rs.getInt("book_ID")
					, rs.getString("book_name")
					, rs.getInt("num_page")
					, rs.getString("book_descnbtion")
					, rs.getString("book_author")
					, rs.getInt("admin_ID")
					, categories
			};

			model.addRow(row);
		}
		rs.close();
		Database.close_stmt();

	}
// -------------------------------------------------------------------------------
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton AddBookButton;
	private static javax.swing.JTable BookTable;
	private static DefaultTableModel model;
	private javax.swing.JButton ButtonBack;
	private javax.swing.JButton view_borrow;
	private javax.swing.JButton EditBookButton;
	private javax.swing.JPanel PanelAdd_Edit_book;
	private javax.swing.JScrollBar jScrollBar1;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables
}