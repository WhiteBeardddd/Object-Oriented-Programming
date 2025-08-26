package MainPackage;
import IO.InputScanner;
import MathUtil.BasicOperations;

public class Main {
    public static void main(String[] args) {
            InputScanner input = new InputScanner();
            int choice = 0, val1, val2, result;
            BasicOperations calculate = new BasicOperations();

            while(choice != 5){

                System.out.println("Choose an Operation");
                System.out.println("1. add");
                System.out.println("2. subtract");
                System.out.println("3. multiply");
                System.out.println("4. divide");
                System.out.println("5. end program");

                System.out.println("Enter Choice");
                choice = input.takeInt();

                switch(choice){
                    case 1:
                        val1 = input.takeInt();
                        val2 = input.takeInt();
                        result = calculate.add(val1, val2);
                        System.out.println("The Sum is " + result);
                        break;

                    case 2:
                        val1 = input.takeInt();
                        val2 = input.takeInt();
                        result = calculate.subtract(val1, val2);
                        System.out.println("The Difference is " + result);
                        break;

                    case 3:
                        val1 = input.takeInt();
                        val2 = input.takeInt();
                        result = calculate.multiply(val1, val2);
                        System.out.println("The Product is " + result);
                        break;

                    case 4:
                        val1 = input.takeInt();
                        val2 = input.takeInt();
                        result = calculate.divide(val1, val2);
                        System.out.println("The Quotient " + result);
                        break;

                    case 5:
                        break;

                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }


//        Activity 1
//
//        Scanner num1 = new Scanner(System.in);
//        System.out.println("Enter 1st Num");
//        int val1 = num1.nextInt();
//
//        Scanner num2 = new Scanner(System.in);
//        System.out.println("Enter 2nd Num");
//        int val2 = num2.nextInt();
//
//        System.out.println("The number between " + val1 + "and " + val2 + " are:");
//        for(int i = val1 + 1; i != val2; i++){
//            System.out.println(i);
//        }1
    }
}
