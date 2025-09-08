package Views;

import Controllers.NotesController;
import Models.Note;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top panel (form)
        JPanel formPanel = new JPanel(new GridLayout(3, 1));
        titleField = new JTextField();
        contentArea = new JTextArea(3, 20);

        JButton addButton = new JButton("Add Note");
        addButton.addActionListener(e -> {
            controller.addNoteFromUI(titleField.getText(), contentArea.getText());
            refreshTable();
            titleField.setText("");
            contentArea.setText("");
        });

        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Content:"));
        formPanel.add(new JScrollPane(contentArea));
        formPanel.add(addButton);

        // Table for notes
        String[] columns = {"ID", "Title", "Content", "Date"};
        tableModel = new DefaultTableModel(columns, 0);
        notesTable = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(notesTable);

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
