package auth;

import Controllers.AuthController;

import javax.swing.*;
import java.awt.*;

public class RegisterUI extends JFrame {
    private AuthController authController = new AuthController();

    public RegisterUI() {
        setTitle("Register");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        UIUtils.applyDarkTheme(this);
        setLayout(new GridLayout(6, 2, 10, 10));

        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();

        add(new JLabel("First Name:")); add(firstNameField);
        add(new JLabel("Last Name:")); add(lastNameField);
        add(new JLabel("Email:")); add(emailField);
        add(new JLabel("Password:")); add(passwordField);
        add(new JLabel("Confirm Password:")); add(confirmPasswordField);

        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back");
        add(backBtn);
        add(registerBtn);

        backBtn.addActionListener(e -> {
            new WelcomeUI();
            dispose();
        });

        registerBtn.addActionListener(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPass = new String(confirmPasswordField.getPassword());

            if (!password.equals(confirmPass)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean success = authController.register(firstName, lastName, email, password);

            if (success) {
                JOptionPane.showMessageDialog(this, "Registration successful!");
                new LoginUI();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to register. Email may already exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
