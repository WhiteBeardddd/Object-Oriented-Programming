package Views;

import Controllers.CalculatorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorUI implements ActionListener {
    private JPanel mainPanel;
    private JTextField textfield;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[9];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton, negButton;

    private CalculatorController controller = new CalculatorController();

    public CalculatorUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(420, 550));
        mainPanel.setBackground(new Color(20, 20, 20));

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(new Font("Roboto Mono", Font.BOLD, 24));
        textfield.setEditable(false);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(new Color(0, 255, 0));
        textfield.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 2));

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (JButton button : functionButtons) {
            styleButton(button);
            button.addActionListener(this);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            styleButton(numberButtons[i]);
            numberButtons[i].addActionListener(this);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        JPanel gridPanel = new JPanel();
        gridPanel.setBounds(50, 100, 300, 300);
        gridPanel.setLayout(new GridLayout(4, 4, 10, 10));
        gridPanel.setBackground(new Color(20, 20, 20));

        gridPanel.add(numberButtons[1]);
        gridPanel.add(numberButtons[2]);
        gridPanel.add(numberButtons[3]);
        gridPanel.add(addButton);
        gridPanel.add(numberButtons[4]);
        gridPanel.add(numberButtons[5]);
        gridPanel.add(numberButtons[6]);
        gridPanel.add(subButton);
        gridPanel.add(numberButtons[7]);
        gridPanel.add(numberButtons[8]);
        gridPanel.add(numberButtons[9]);
        gridPanel.add(mulButton);
        gridPanel.add(decButton);
        gridPanel.add(numberButtons[0]);
        gridPanel.add(equButton);
        gridPanel.add(divButton);

        mainPanel.add(gridPanel);
        mainPanel.add(negButton);
        mainPanel.add(delButton);
        mainPanel.add(clrButton);
        mainPanel.add(textfield);
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
        String currentText = textfield.getText();
        String newText = currentText;

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                newText = controller.processInput("NUMBER", currentText + i);
            }
        }
        if (e.getSource() == decButton) newText = controller.processInput(".", currentText);
        if (e.getSource() == addButton) newText = controller.processInput("+", currentText);
        if (e.getSource() == subButton) newText = controller.processInput("-", currentText);
        if (e.getSource() == mulButton) newText = controller.processInput("*", currentText);
        if (e.getSource() == divButton) newText = controller.processInput("/", currentText);
        if (e.getSource() == equButton) newText = controller.processInput("=", currentText);
        if (e.getSource() == clrButton) newText = controller.processInput("CLR", currentText);
        if (e.getSource() == delButton) newText = controller.processInput("DEL", currentText);
        if (e.getSource() == negButton) newText = controller.processInput("NEG", currentText);

        textfield.setText(newText);
    }
}
