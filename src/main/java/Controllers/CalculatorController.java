package MathUtil;

public class CalculatorController {
    private double num1 = 0, num2 = 0, result = 0;
    private char operator = ' ';
    private boolean resetText = false;

    public String processInput(String command, String currentText) {
        switch (command) {
            case "NUMBER":
                if (resetText) {
                    resetText = false;
                    return currentText; // fresh number typed
                }
                return currentText;

            case ".":
                return currentText + ".";

            case "+":
            case "-":
            case "*":
            case "/":
                if (!currentText.isEmpty()) {
                    num1 = Double.parseDouble(currentText);
                    operator = command.charAt(0);
                    resetText = true;
                }
                return "";

            case "=":
                if (!currentText.isEmpty()) {
                    num2 = Double.parseDouble(currentText);
                    result = CalculatorOperations.calculate(num1, num2, operator);
                    num1 = result;
                    resetText = true;
                    return String.valueOf(result);
                }
                return currentText;

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
