/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package library.management.system.GUI;

import library.management.system.Book;
import library.management.system.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.*;

/**
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
        java.awt.GridBagConstraints gridBagConstraints;

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
        ButtonSend = new javax.swing.JButton();

        setForeground(new java.awt.Color(60, 63, 65));
        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 297;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 270, 0, 341);
        add(TextFieldBookName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 297;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 270, 0, 341);
        add(TextFieldBookAuthor, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 297;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 270, 0, 341);
        add(TextFieldBookPages, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 297;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 270, 0, 341);
        add(TextFieldBookCategory, gridBagConstraints);

        LabelBookName.setText("Book Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 299;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(58, 270, 0, 341);
        add(LabelBookName, gridBagConstraints);

        LabelBookAuthor.setText("Book author");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 296;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 270, 0, 341);
        add(LabelBookAuthor, gridBagConstraints);

        LabelBookPages.setText("Book pages");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 270, 0, 341);
        add(LabelBookPages, gridBagConstraints);

        LabelBookCategory.setText("Category");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 313;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 270, 0, 341);
        add(LabelBookCategory, gridBagConstraints);

        LabelEditPage.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LabelEditPage.setText("Add page");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 367, 0, 0);
        add(LabelEditPage, gridBagConstraints);

        TextFieldBookDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldBookDescActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 297;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 270, 0, 341);
        add(TextFieldBookDesc, gridBagConstraints);

        LabelBookDesc.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 301;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 270, 0, 341);
        add(LabelBookDesc, gridBagConstraints);

        jButton1.setText("<<<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            try {
		            jButton1ActionPerformed(evt);
	            } catch (SQLException e) {
		            throw new RuntimeException(e);
	            }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        add(jButton1, gridBagConstraints);

        ButtonSend.setText("send");
        ButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSendActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 416, 92, 0);
        add(ButtonSend, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

	private void TextFieldBookDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldBookDescActionPerformed
		// TODO add your handling code here:

	}//GEN-LAST:event_TextFieldBookDescActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_jButton1ActionPerformed
		NAdminGui.refresh();
		GUI.cardLayout.show(GUI.frame.getContentPane(), "nAdminGui");
	}//GEN-LAST:event_jButton1ActionPerformed

	private void ButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSendActionPerformed
		try {
			Book book = new Book(
					TextFieldBookName.getText()
					, Integer.parseInt(TextFieldBookPages.getText())
					, new ArrayList<>(Arrays.asList(TextFieldBookCategory.getText().split(",\\s*")))
					, TextFieldBookAuthor.getText()
					, TextFieldBookDesc.getText()
					, NLogin.user_id
			);
			int result = book.insert();
			if (result > 0) {
				JOptionPane.showMessageDialog(GUI.frame,"The book has been successfully added");

			} else {
				JOptionPane.showMessageDialog(GUI.frame,"Failed to add the book");

			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(GUI.frame
					, "number Page ()"
					+ TextFieldBookPages.getText()
					+ "must is number ", "WARNING"
					, JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	//GEN-LAST:event_ButtonSendActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSend;
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
