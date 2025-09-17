package auth;

import Controllers.AuthController;
import Models.User;

import javax.swing.*;
import java.awt.*;

public class ChangePasswordUI extends JFrame {
    private AuthController authController;

    public ChangePasswordUI(AuthController authController) {
        this.authController = authController;

        User currentUser = authController.getCurrentUser();
        String firstName = currentUser.getFirstname();
        String lastName = currentUser.getLastname();

        setTitle("Change Password");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        UIUtils.applyDarkTheme(this);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel userLabel = new JLabel("Logged in as: " + firstName + " " + lastName);
        add(userLabel); add(new JLabel());

        JPasswordField oldPassword = new JPasswordField();
        JPasswordField newPassword = new JPasswordField();
        JPasswordField confirmPassword = new JPasswordField();

        add(new JLabel("Old Password:")); add(oldPassword);
        add(new JLabel("New Password:")); add(newPassword);
        add(new JLabel("Confirm New Password:")); add(confirmPassword);

        JButton backBtn = new JButton("Back");
        JButton saveBtn = new JButton("Save");
        add(backBtn); add(saveBtn);

        // 🔗 Navigation
        backBtn.addActionListener(e -> {
            new DashboardUI(authController);
            dispose();
        });

        saveBtn.addActionListener(e -> {
            String oldPass = new String(oldPassword.getPassword());
            String newPass = new String(newPassword.getPassword());
            String confirmPass = new String(confirmPassword.getPassword());

            if (!newPass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(this, "New passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (authController.changePassword(oldPass, newPass)) {
                JOptionPane.showMessageDialog(this, "Password changed successfully!");
                new DashboardUI(authController);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to change password. Check old password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
