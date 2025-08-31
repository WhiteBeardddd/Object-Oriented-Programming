package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import MathUtil.CalculatorController;

public class CalculatorUI implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Roboto Mono", Font.BOLD, 24);

    CalculatorController controller = new CalculatorController();

    public CalculatorUI() {
        frame = new JFrame("Robotic Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(20, 20, 20)); // dark background

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(new Color(0, 255, 0)); // glowing green numbers
        textfield.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 2));

        // Create buttons
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

        for (int i = 0; i < 9; i++) {
            styleButton(functionButtons[i]);
            functionButtons[i].addActionListener(this);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            styleButton(numberButtons[i]);
            numberButtons[i].addActionListener(this);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(new Color(20, 20, 20));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(myFont);
        button.setFocusable(false);
        button.setBackground(new Color(40, 40, 40));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 2));

        // Glowing hover effect
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
