package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyApplicationUI implements ActionListener {
    private JPanel mainPanel;
    private JButton toCalculator, toPalindrome, toNotes;

    public MyApplicationUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 20, 20));
        mainPanel.setPreferredSize(new Dimension(400, 400));
        mainPanel.setBackground(new Color(20, 20, 20));

        toCalculator = createStyledButton("Calculator");
        toPalindrome = createStyledButton("Palindrome Checker");
        toNotes = createStyledButton("My Notes");

        toCalculator.addActionListener(this);
        toPalindrome.addActionListener(this);
        toNotes.addActionListener(this);

        mainPanel.add(toCalculator);
        mainPanel.add(toPalindrome);
        mainPanel.add(toNotes);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
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
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toCalculator) {
            openWindow("Calculator", new CalculatorUI().getMainPanel());
        } else if (e.getSource() == toPalindrome) {
            openWindow("Palindrome Checker", new PalindromeUI().getMainPanel());
        } else if (e.getSource() == toNotes) {
            openWindow("My Notes", new NotesUI().getMainPanel());
        }
    }

    private void openWindow(String title, JPanel panel) {
        JFrame frame = new JFrame(title);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
