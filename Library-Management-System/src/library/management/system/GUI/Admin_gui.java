/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library.management.system.GUI;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

import library.management.system.Book;
import library.management.system.Database;

/**
 *
 * @author Ahmed
 */
public class Admin_gui extends javax.swing.JFrame {
    
    /**
     * Creates new form Admin
     * @throws SQLException
     */
    public Admin_gui() throws SQLException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() throws SQLException {

        jScrollPane1 = new javax.swing.JScrollPane();
        // BookTableAdmin = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        AddBook = new javax.swing.JButton();
        EditBook = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1050, 600));

        // BookTableAdmin.setModel(new javax.swing.table.DefaultTableModel(
        // new Object [][] {

        // },
        // new String [] {
        // "Book Id", "Book Name", "Category", "Author Name", "Borrow"
        // }
        // ) {
        // Class[] types = new Class [] {
        // java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
        // java.lang.String.class, java.lang.Boolean.class
        // };

        // public Class getColumnClass(int columnIndex) {
        // return types [columnIndex];
        // }
        // });
        String[] columns = {
                "Book ID", "Book Name", "Num Page", "Book Descnbtion", "Book Author", "Is Translator", "Admin ID",
                "categorise"
        };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        BookTableAdmin = new JTable(model);
        jScrollPane1 = new JScrollPane(BookTableAdmin);
//        GUI.frame.add(jScrollPane1, BorderLayout.CENTER);

        ResultSet rs = Database.select_stmt("*", "books");

        while (rs.next()) {
            String categories = Book.getBookCategories(rs.getInt("book_ID"));
            Object[] row = {
                    rs.getInt("book_ID"), rs.getString("book_name"), rs.getInt("num_page"),
                    rs.getString("book_descnbtion"), rs.getString("book_author"), rs.getBoolean("is_translator"),
                    rs.getInt("admin_ID"), categories
            };

            model.addRow(row);
        }
        rs.close();
        Database.close_stmt();

        BookTableAdmin.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(BookTableAdmin);
        BookTableAdmin.getColumnModel().getSelectionModel()
                .setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        AddBook.setBackground(new java.awt.Color(86, 0, 20));
        AddBook.setText("Add Book");
        AddBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookActionPerformed(evt);
            }
        });

        EditBook.setBackground(new java.awt.Color(0, 86, 20));
        EditBook.setText("Edit Book");
        EditBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(234, 234, 234)
                                .addComponent(AddBook)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EditBook)
                                .addGap(251, 251, 251)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(AddBook)
                                        .addComponent(EditBook))
                                .addContainerGap(18, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 12,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548,
                                                Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBookActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AddBookActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_AddBookActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBook;
    private javax.swing.JTable BookTableAdmin;
    private javax.swing.JButton EditBook;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
