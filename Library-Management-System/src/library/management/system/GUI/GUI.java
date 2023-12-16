package library.management.system.GUI;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class GUI {
	static JFrame frame = new JFrame("Library Management System");
	static CardLayout cardLayout;
	static JPanel cardPanel;

	public GUI() throws SQLException {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		NLogin loginPanel = new NLogin();
		User_gui userGui = new User_gui();
		Admin_gui adminGui = new Admin_gui();
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);

		cardPanel.add(loginPanel, "LoginPanel");
		cardPanel.add(userGui, "userGui");
		cardPanel.add(adminGui, "adminGui");
		frame.add(cardPanel);
		cardLayout.show(cardPanel, "LoginPanel");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
