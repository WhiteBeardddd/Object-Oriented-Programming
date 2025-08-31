package MathUtil;

public class CalculatorOperations {

    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+': return add(num1, num2);
            case '-': return subtract(num1, num2);
            case '*': return multiply(num1, num2);
            case '/': return divide(num1, num2);
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
}
