package MathUtil;
import java.lang.Math;

public class BasicOperations {
    public int add(int x, int y){
        return x + y;
    }

    public int subtract(int x, int y){
        return x - y;
    }

    public int multiply(int x, int y){
        return x * y;
    }

    public int divide(int x, int y){
        return x / y;
    }

//    Formula [-b ± √(b² - 4ac)] / 2a

    public double[] quadratic(double b, double a, double c){
        double discriminant = b * b - 4 * a * c;

        if(discriminant < 0){
            return new double[0];
        }

        double squareRoot = Math.sqrt(discriminant);
        double root1, root2;
        root1 = (-b + squareRoot) / (2 * a);
        root2 = (-b - squareRoot) / (2 * a);
        return new double[] {root1 , root2};
    }
}
