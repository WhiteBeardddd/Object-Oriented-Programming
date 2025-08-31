package IO;
import java.util.Scanner;

public class InputScanner {
    public double takeDouble() {
        Scanner input = new Scanner(System.in);
        return input.nextDouble() ;
    }

    public int takeInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt() ;
    }

    public String takeString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine() ;
    }
}

