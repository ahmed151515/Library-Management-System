/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package library.management.system.GUI;

import library.management.system.Book;
import library.management.system.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;

/**
 *
 * @author Ahmed
 */
public class AddBook extends javax.swing.JPanel {
    
    
    
    /**
     * Creates new form AddBook
     */
    public AddBook() throws SQLException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextFieldBookName = new javax.swing.JTextField();
        TextFieldBookAuthor = new javax.swing.JTextField();
        TextFieldBookPages = new javax.swing.JTextField();
        TextFieldBookCategory = new javax.swing.JTextField();
        LabelBookName = new javax.swing.JLabel();
        LabelBookAuthor = new javax.swing.JLabel();
        LabelBookPages = new javax.swing.JLabel();
        LabelBookCategory = new javax.swing.JLabel();
        LabelEditPage = new javax.swing.JLabel();
        TextFieldBookDesc = new javax.swing.JTextField();
        LabelBookDesc = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setForeground(new java.awt.Color(60, 63, 65));

        LabelBookName.setText("Book Name");

        LabelBookAuthor.setText("Book author");

        LabelBookPages.setText("Book pages");

        LabelBookCategory.setText("Category");

        LabelEditPage.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LabelEditPage.setText("Edit page");

        TextFieldBookDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldBookDescActionPerformed(evt);
            }
        });

        LabelBookDesc.setText("Description");

        jButton1.setText("<<<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 342, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LabelBookName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldBookName)
                                    .addComponent(TextFieldBookAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                    .addComponent(TextFieldBookPages, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                    .addComponent(TextFieldBookCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                    .addComponent(LabelBookAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LabelBookPages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LabelBookCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldBookDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                    .addComponent(LabelBookDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(341, 341, 341))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabelEditPage)
                                .addGap(444, 444, 444))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(40, 40, 40)
                .addComponent(LabelEditPage)
                .addGap(58, 58, 58)
                .addComponent(LabelBookName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextFieldBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(LabelBookAuthor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextFieldBookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(LabelBookPages)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextFieldBookPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(LabelBookCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextFieldBookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(LabelBookDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextFieldBookDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldBookDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldBookDescActionPerformed
        // TODO add your handling code here:
        GUI.cardLayout.previous(GUI.frame.getContentPane());
    }//GEN-LAST:event_TextFieldBookDescActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

	public static void setData(int book_ID) throws SQLException {
		ResultSet rs = Database.select_stmt("*", "books", "book_Id = " + book_ID);
		if (rs.next()) {
			TextFieldBookName.setText(rs.getString("book_name"));
			TextFieldBookCategory.setText(Book.getBookCategories(book_ID));
			TextFieldBookDesc.setText(rs.getString("book_descnbtion"));
			TextFieldBookPages.setText(rs.getString("num_page"));
			TextFieldBookAuthor.setText(rs.getString("book_author"));
		}
		rs.close();
		Database.close_stmt();
	}
    public static void supmit(int book_ID) throws SQLException {


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBookAuthor;
    private javax.swing.JLabel LabelBookCategory;
    private javax.swing.JLabel LabelBookDesc;
    private javax.swing.JLabel LabelBookName;
    private javax.swing.JLabel LabelBookPages;
    private javax.swing.JLabel LabelEditPage;
    private javax.swing.JTextField TextFieldBookAuthor;
    private javax.swing.JTextField TextFieldBookCategory;
    private javax.swing.JTextField TextFieldBookDesc;
    private javax.swing.JTextField TextFieldBookName;
    private javax.swing.JTextField TextFieldBookPages;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
