package Controllers;

import MathUtil.CalculatorOperations;

public class CalculatorController {
    private double num1 = 0, num2 = 0, result = 0;
    private char operator = ' ';
    private boolean resetText = false;

    public String processInput(String input, String currentText) {
        switch (input) {
            case "NUMBER":
                if (resetText) {
                    resetText = false;
                    return currentText; // keep typing new number
                }
                return currentText;
            case ".":
                return currentText + ".";
            case "+":
            case "-":
            case "*":
            case "/":
                num1 = Double.parseDouble(currentText);
                operator = input.charAt(0);
                resetText = true;
                return "";
            case "=":
                num2 = Double.parseDouble(currentText);
                result = CalculatorOperations.calculate(num1, num2, operator);
                num1 = result;
                resetText = true;
                return String.valueOf(result);
            case "CLR":
                num1 = num2 = result = 0;
                operator = ' ';
                return "";
            case "DEL":
                if (!currentText.isEmpty()) {
                    return currentText.substring(0, currentText.length() - 1);
                }
                return "";
            case "NEG":
                if (!currentText.isEmpty()) {
                    double temp = Double.parseDouble(currentText) * -1;
                    return String.valueOf(temp);
                }
                return currentText;
            default:
                return currentText;
        }
    }
}
