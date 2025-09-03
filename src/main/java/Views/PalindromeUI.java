package Views;

import Controllers.PalindromeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeUI implements ActionListener {
    private JPanel mainPanel;
    private JTextField inputField;
    private JButton checkButton, clearButton;
    private JLabel resultLabel;

    public PalindromeUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(420, 300));
        mainPanel.setBackground(new Color(20, 20, 20));

        inputField = new JTextField();
        inputField.setBounds(50, 30, 300, 40);
        inputField.setFont(new Font("Roboto Mono", Font.BOLD, 20));
        inputField.setBackground(Color.BLACK);
        inputField.setForeground(new Color(0, 255, 0));
        inputField.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 2));

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setBounds(50, 80, 300, 40);
        resultLabel.setFont(new Font("Roboto Mono", Font.BOLD, 20));
        resultLabel.setForeground(Color.WHITE);

        checkButton = new JButton("Check");
        clearButton = new JButton("Clear");

        styleButton(checkButton);
        styleButton(clearButton);

        checkButton.setBounds(50, 140, 140, 40);
        clearButton.setBounds(210, 140, 140, 40);

        checkButton.addActionListener(this);
        clearButton.addActionListener(this);

        mainPanel.add(inputField);
        mainPanel.add(resultLabel);
        mainPanel.add(checkButton);
        mainPanel.add(clearButton);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Roboto Mono", Font.BOLD, 18));
        button.setFocusable(false);
        button.setBackground(new Color(40, 40, 40));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 2));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 60, 0));
                button.setForeground(new Color(0, 255, 0));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(40, 40, 40));
                button.setForeground(Color.WHITE);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkButton) {
            String text = inputField.getText();
            if (PalindromeController.isPalindrome(text)) {
                resultLabel.setText("✅ It's a palindrome!");
                resultLabel.setForeground(new Color(0, 255, 0));
            } else {
                resultLabel.setText("❌ Not a palindrome!");
                resultLabel.setForeground(Color.RED);
            }
        } else if (e.getSource() == clearButton) {
            inputField.setText("");
            resultLabel.setText("");
        }
    }
}
