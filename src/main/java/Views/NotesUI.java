package Views;

import Controllers.NotesController;
import Models.Note;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NotesUI implements ActionListener {
    private JPanel mainPanel;
    private JTextArea notesArea;
    private JTextField inputField;
    private JButton addButton, clearButton;

    private NotesController controller = new NotesController();
    private JButton button1;

    public NotesUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setPreferredSize(new Dimension(420, 400));
        mainPanel.setBackground(new Color(20, 20, 20));

        inputField = new JTextField();
        inputField.setFont(new Font("Roboto Mono", Font.PLAIN, 16));
        inputField.setBackground(Color.BLACK);
        inputField.setForeground(new Color(0, 255, 0));
        inputField.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 2));

        notesArea = new JTextArea();
        notesArea.setEditable(false);
        notesArea.setFont(new Font("Roboto Mono", Font.PLAIN, 16));
        notesArea.setBackground(Color.BLACK);
        notesArea.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(notesArea);

        addButton = new JButton("Add Note");
        clearButton = new JButton("Clear All");

        styleButton(addButton);
        styleButton(clearButton);

        addButton.addActionListener(this);
        clearButton.addActionListener(this);

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(inputField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);

        inputPanel.add(buttonPanel, BorderLayout.EAST);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Roboto Mono", Font.BOLD, 14));
        button.setFocusable(false);
        button.setBackground(new Color(40, 40, 40));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                controller.addNote(new Note(text));
                notesArea.append("- " + text + "\n");
                inputField.setText("");
            }
        } else if (e.getSource() == clearButton) {
            controller.clearNotes();
            notesArea.setText("");
        }
    }
}
