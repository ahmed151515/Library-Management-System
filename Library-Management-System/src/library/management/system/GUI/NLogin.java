/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package library.management.system.GUI;

import library.management.system.Admin;
import library.management.system.Database;
import library.management.system.User;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ahmed
 */
public class NLogin extends javax.swing.JPanel {

	private JLabel LoginLabel;
	private JButton loginButton;
	private JLabel passwordLabel;
	private JPasswordField passwordTextField;
	private JLabel userIdLabel;
	private JTextField userIdTextField;
	// End of variables declaration//GEN-END:variables
	static int user_id;


	/**
	 * Creates new form NLogin
	 */
	public NLogin() {
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

		LoginLabel = new javax.swing.JLabel();
		passwordTextField = new javax.swing.JPasswordField();
		userIdTextField = new javax.swing.JTextField();
		userIdLabel = new javax.swing.JLabel();
		passwordLabel = new javax.swing.JLabel();
		loginButton = new javax.swing.JButton();

		setForeground(new java.awt.Color(60, 63, 65));

		LoginLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		LoginLabel.setText("LOGIN");

		userIdTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userIdTextFieldActionPerformed(evt);
			}
		});

		userIdLabel.setText("User ID");

		passwordLabel.setText("Password");

		loginButton.setText("LOGIN");
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					loginButtonActionPerformed(evt);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(488, 488, 488)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(LoginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap(346, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(userIdLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(userIdTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(331, 331, 331))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(70, 70, 70)
								.addComponent(LoginLabel)
								.addGap(83, 83, 83)
								.addComponent(userIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(userIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(88, 88, 88)
								.addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(83, 83, 83)
								.addComponent(loginButton)
								.addContainerGap(115, Short.MAX_VALUE))
		);
	}// </editor-fold>//GEN-END:initComponents

	private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_loginButtonActionPerformed
		// TODO add your handling code here:
		String userId = userIdTextField.getText();

		char[] passwordChars = passwordTextField.getPassword();
		String password = new String(passwordChars);

		user_id = Integer.parseInt(userId);
		if (User.is_user(userId, password)) {

			GUI.cardLayout.show(GUI.frame.getContentPane(), "userGui");
		} else if (Admin.is_admin(userId, password)) {
			GUI.cardLayout.show(GUI.frame.getContentPane(), "nAdminGui");
		} else
		{
			JOptionPane.showMessageDialog(null, "user id or password is wrong", "", JOptionPane.WARNING_MESSAGE);
		}

	}//GEN-LAST:event_loginButtonActionPerformed

	private void userIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIdTextFieldActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_userIdTextFieldActionPerformed


	// Variables declaration - do not modify//GEN-BEGIN:variables



}
