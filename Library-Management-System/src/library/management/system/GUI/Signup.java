package library.management.system.GUI;

import library.management.system.*;
import library.management.system.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import library.management.system.Admin;
import library.management.system.GUI.GUI;
import library.management.system.User;
import javax.swing.*;

/**
 *
 * @author Ahmed
 */
public class Signup extends JPanel{





    private PreparedStatement stmt;

    public Signup() {
        initComponents();
    }
    private void SignupButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
                String username = UsernameField.getText();
                char[] passwordChars = PasswordField.getPassword();
		        String password = new String(passwordChars);
                String Email = EmailField.getText();

                        String sql ="INSERT INTO Users VALUES(?,?,?)";
                        stmt=con.prepareStatement(sql);
                        stmt.setString(1, username);
                        stmt.setString(2, password);
                        stmt.setString(3, Email);

                    // Execute the update query and store the result.
                    int result = stmt.executeUpdate();
			        GUI.cardLayout.show(GUI.frame.getContentPane(), "NLogin");


//                    JOptionPane.showMessageDialog(null, "Error", "", JOptionPane.WARNING_MESSAGE);

                
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        SignupLabel = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        UsernameField = new javax.swing.JTextField();
        UsernameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        SignupButton = new javax.swing.JButton();
        EmailField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(10, 65, 100));
        setLayout(new java.awt.GridBagLayout());

        SignupLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SignupLabel.setText("Sign Up");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 401, 0, 0);
        add(SignupLabel, gridBagConstraints);

        BackButton.setText("<<<");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        add(BackButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 360;
        gridBagConstraints.insets = new java.awt.Insets(20, 230, 0, 300);
        add(UsernameField, gridBagConstraints);

        UsernameLabel.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 377;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 230, 0, 312);
        add(UsernameLabel, gridBagConstraints);

        PasswordLabel.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 380;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 230, 0, 312);
        add(PasswordLabel, gridBagConstraints);

        EmailLabel.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 401;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 230, 0, 312);
        add(EmailLabel, gridBagConstraints);

        SignupButton.setText("Sign Up");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 412, 90, 0);
        add(SignupButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 360;
        gridBagConstraints.insets = new java.awt.Insets(20, 230, 0, 300);
        add(EmailField, gridBagConstraints);

        PasswordField.setText("jPasswordField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 360;
        gridBagConstraints.insets = new java.awt.Insets(20, 230, 0, 300);
        add(PasswordField, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JButton SignupButton;
    private javax.swing.JLabel SignupLabel;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JLabel UsernameLabel;
    // End of variables declaration//GEN-END:variables
}
