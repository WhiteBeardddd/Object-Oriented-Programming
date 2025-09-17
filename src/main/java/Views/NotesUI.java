package Views;

import Controllers.NotesController;
import Models.Note;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class NotesUI extends JFrame {
    private NotesController controller;
    private JTextField titleField;
    private JTextArea contentArea;
    private JTable notesTable;
    private DefaultTableModel tableModel;

    public NotesUI() {
        controller = new NotesController();

        setTitle("Notes App");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top panel (form)
        JPanel formPanel = new JPanel(new GridLayout(6, 1));
        titleField = new JTextField();
        contentArea = new JTextArea(3, 20);

        JButton addButton = new JButton("Add Note");
        JButton updateButton = new JButton("Update Note");
        JButton deleteButton = new JButton("Delete Note");

        // Add Note
        addButton.addActionListener(e -> {
            controller.addNoteFromUI(titleField.getText(), contentArea.getText());
            refreshTable();
            titleField.setText("");
            contentArea.setText("");
        });

        // Update Note
        updateButton.addActionListener(e -> {
            int selectedRow = notesTable.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                String newTitle = titleField.getText();
                String newContent = contentArea.getText();
                controller.updateNoteFromUI(id, newTitle, newContent);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a note to update.");
            }
        });

        // Delete Note
        deleteButton.addActionListener(e -> {
            int selectedRow = notesTable.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to delete this note?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    controller.deleteNoteFromUI(id);
                    refreshTable();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a note to delete.");
            }
        });

        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Content:"));
        formPanel.add(new JScrollPane(contentArea));
        formPanel.add(addButton);
        formPanel.add(updateButton);
        formPanel.add(deleteButton);

        // Table for notes
        String[] columns = {"ID", "Title", "Content", "Date"};
        tableModel = new DefaultTableModel(columns, 0);
        notesTable = new JTable(tableModel);
        notesTable.setFillsViewportHeight(true);

        JTableHeader header = notesTable.getTableHeader();
        JScrollPane tableScroll = new JScrollPane(notesTable);

        // Table row selection → load into form fields
        notesTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = notesTable.getSelectedRow();
            if (selectedRow >= 0) {
                String title = (String) tableModel.getValueAt(selectedRow, 1);
                String content = (String) tableModel.getValueAt(selectedRow, 2);
                titleField.setText(title);
                contentArea.setText(content);
            }
        });

        // Layout
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(tableScroll, BorderLayout.CENTER);

        refreshTable();
    }

    private void refreshTable() {
        try {
            tableModel.setRowCount(0);
            List<Note> notes = controller.fetchAllNotes();
            for (Note n : notes) {
                tableModel.addRow(new Object[]{
                        n.getId(), n.getTitle(), n.getContent(), n.getDate()
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error loading notes: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NotesUI().setVisible(true));
    }
}
