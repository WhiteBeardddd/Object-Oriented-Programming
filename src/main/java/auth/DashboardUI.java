package auth;

import Controllers.AuthController;
import Models.User;

import javax.swing.*;
import java.awt.*;

public class DashboardUI extends JFrame {
    private AuthController authController;

    public DashboardUI(AuthController authController) {
        this.authController = authController;
        User currentUser = authController.getCurrentUser();

        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        UIUtils.applyDarkTheme(this);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel(
                "WELCOME " + currentUser.getFirstname() + " " + currentUser.getLastname() + " TO YOUR SHOP",
                SwingConstants.CENTER
        );
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton changePassBtn = new JButton("Change Password");
        JButton logoutBtn = new JButton("Logout");

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        bottomPanel.setBackground(new Color(40, 40, 40));
        bottomPanel.add(logoutBtn);
        bottomPanel.add(changePassBtn);

        add(welcomeLabel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // 🔗 Navigation
        changePassBtn.addActionListener(e -> {
            new ChangePasswordUI(authController);
            dispose();
        });

        logoutBtn.addActionListener(e -> {
            new WelcomeUI();
            dispose();
        });

        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
