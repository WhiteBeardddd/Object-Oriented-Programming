package auth;

import Controllers.AuthController;
import Models.User;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    private AuthController authController = new AuthController();

    public LoginUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        UIUtils.applyDarkTheme(this);
        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(40, 40, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(180, 25));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(180, 25));

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(40, 40, 40));

        JButton backBtn = new JButton("Back");
        JButton loginBtn = new JButton("Login");

        Dimension btnSize = new Dimension(90, 30);
        backBtn.setPreferredSize(btnSize);
        loginBtn.setPreferredSize(btnSize);

        buttonPanel.add(backBtn);
        buttonPanel.add(loginBtn);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        backBtn.addActionListener(e -> {
            new WelcomeUI();
            dispose();
        });

        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            User loggedInUser = authController.login(email, password);

            if (loggedInUser != null) {
                new DashboardUI(authController);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Invalid email or password!",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        setSize(400, 220);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
