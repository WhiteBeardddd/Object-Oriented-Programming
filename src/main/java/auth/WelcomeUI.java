package auth;

import javax.swing.*;
import java.awt.*;

public class WelcomeUI extends JFrame {
    public WelcomeUI() {
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UIUtils.applyDarkTheme(this);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("WELCOME TO MY SHOP APP", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(40, 40, 40));

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        // Set fixed button sizes so they look consistent
        Dimension btnSize = new Dimension(120, 40);
        loginBtn.setPreferredSize(btnSize);
        registerBtn.setPreferredSize(btnSize);

        buttonPanel.add(loginBtn);
        buttonPanel.add(registerBtn);

        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // 🔗 Navigation
        loginBtn.addActionListener(e -> {
            new LoginUI();
            dispose();
        });
        registerBtn.addActionListener(e -> {
            new RegisterUI();
            dispose();
        });

        setSize(400, 250);         // proper sizing
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }

    public static void main(String[] args) {
        new WelcomeUI();
    }
}
