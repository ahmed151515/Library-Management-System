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
        cardLayout = new CardLayout();
        frame.setLayout(cardLayout);

        NLogin loginPanel = new NLogin();
        User_gui userGui = new User_gui();
        NAdminGui nAdminGui = new NAdminGui();

        AddBook addBook = new AddBook();


        frame.add(loginPanel, "LoginPanel");
        frame.add(userGui, "userGui");
        frame.add(nAdminGui, "nAdminGui");
        frame.add(addBook, "addBook");

        cardLayout.show(frame.getContentPane(), "LoginPanel");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
