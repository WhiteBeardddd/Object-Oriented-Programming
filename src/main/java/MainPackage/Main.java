package MainPackage;
import IO.InputScanner;
import MathUtil.BasicOperations;

public class Main {
    public static void main(String[] args) {
            InputScanner input = new InputScanner();
            int choice = 0, ival1, ival2, iresult;
            double dval1, dval2, dval3, dresult[];
            BasicOperations calculate = new BasicOperations();

            while(choice != 6){

                System.out.println("Choose an Operation");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("5. Quadratic");
                System.out.println("6. End program");

                System.out.println("Enter Choice");
                choice = input.takeInt();

                switch(choice){
                    case 1:
                        System.out.println("Input value1: ");
                        ival1 = input.takeInt();
                        System.out.println("Input value2: ");
                        ival2 = input.takeInt();
                        iresult = calculate.add(ival1, ival2);
                        System.out.println("The Sum is " + iresult);
                        break;

                    case 2:
                        System.out.println("Input value1: ");
                        ival1 = input.takeInt();
                        System.out.println("Input value2: ");
                        ival2 = input.takeInt();
                        iresult = calculate.subtract(ival1, ival2);
                        System.out.println("The Difference is " + iresult);
                        break;

                    case 3:
                        System.out.println("Input value1: ");
                        ival1 = input.takeInt();
                        System.out.println("Input value2: ");
                        ival2 = input.takeInt();
                        iresult = calculate.multiply(ival1, ival2);
                        System.out.println("The Product is " + iresult);
                        break;

                    case 4:
                        System.out.println("Input value1: ");
                        ival1 = input.takeInt();
                        System.out.println("Input value2: ");
                        ival2 = input.takeInt();
                        iresult = calculate.divide(ival1, ival2);
                        System.out.println("The Quotient " + iresult);
                        break;

                    case 5:
                        System.out.println("Input A: ");
                        dval1 = input.takeDouble();
                        System.out.println("Input B: ");
                        dval2 = input.takeDouble();
                        System.out.println("Input C: ");
                        dval3 = input.takeDouble();
                        dresult = calculate.quadratic(dval2,dval1, dval3);
                        if (dresult.length == 0) {
                            System.out.println("No real roots.");
                        } else {
                            System.out.println("The result is " + dresult[0]);
                            System.out.println("The result is " + dresult[1]);
                        }
                        break;
                    case 6:
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
