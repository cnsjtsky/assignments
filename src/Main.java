import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        System.out.println("\nEnter Task Number (1-10) or 0 to Exit:");

        if (!sc.hasNextInt()) return;
        int task = sc.nextInt();

        if (task == 0) {
            System.out.println("Program finished.");
            return;
        }

        switch (task) {
            case 1:
                System.out.println("Enter a number:");
                printDigits(sc.nextInt());
                break;

            case 2:
                System.out.println("Enter count of numbers:");
                int n2 = sc.nextInt();
                if (n2 == 0) {
                    System.out.println("Invalid input");
                    break;
                }
                System.out.println("Average: " + (findSum(n2) / (double) n2));
                break;

            case 3:
                System.out.println("Enter number to check:");
                System.out.println("Result: " + isPrime(sc.nextInt(), 2));
                break;

            case 4:
                System.out.println("Enter number:");
                System.out.println("Factorial: " + factorial(sc.nextInt()));
                break;

            case 5:
                System.out.println("Enter n:");
                System.out.println("Fibonacci: " + fibonacci(sc.nextInt()));
                break;

            case 6:
                System.out.println("Enter base 'a' and power 'n':");
                System.out.println("Result: " + power(sc.nextInt(), sc.nextInt()));
                break;

            case 7:
                System.out.println("Enter count of numbers:");
                int n7 = sc.nextInt();
                reverseInput(n7);
                System.out.println();
                break;

            case 8:
                System.out.println("Enter string:");
                System.out.println(isAllDigits(sc.next()) ? "Yes" : "No");
                break;

            case 9:
                System.out.println("Enter string:");
                System.out.println("Length: " + countChars(sc.next()));
                break;

            case 10:
                System.out.println("Enter two numbers:");
                System.out.println("GCD: " + gcd(sc.nextInt(), sc.nextInt()));
                break;

            default:
                System.out.println("Invalid Task Number.");
        }

        runMenu();
    }

    //  TASK 1
    public static void printDigits(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    //  TASK 2
    public static double findSum(int n) {
        if (n == 0) return 0;
        int val = sc.nextInt();
        return val + findSum(n - 1);
    }

    //  TASK 3
    public static String isPrime(int n, int i) {
        if (n <= 1) return "Composite";
        if (n == 2) return "Prime";
        if (n % i == 0) return "Composite";
        if (i * i > n) return "Prime";
        return isPrime(n, i + 1);
    }

    // TASK 4
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // TASK 5
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // TASK 6
    public static int power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    //  TASK 7
    public static void reverseInput(int n) {
        if (n == 0) return;
        int x = sc.nextInt();
        reverseInput(n - 1);
        System.out.print(x + " ");
    }

    // TASK 8
    public static boolean isAllDigits(String s) {
        if (s.isEmpty()) return true;
        if (!Character.isDigit(s.charAt(0))) return false;
        return isAllDigits(s.substring(1));
    }

    //  TASK 9
    public static int countChars(String s) {
        if (s.isEmpty()) return 0;
        return 1 + countChars(s.substring(1));
    }

    // TASK 10

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}