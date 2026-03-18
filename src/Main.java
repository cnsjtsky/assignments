import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Task Number (1-10):");
        if (!sc.hasNextInt()) return;
        int task = sc.nextInt();

        switch (task) {
            case 1:
                System.out.println("Enter a number:");
                printDigits(sc.nextInt());
                break;
            case 2:
                System.out.println("Enter count of numbers:");
                int n2 = sc.nextInt();
                System.out.println("Average: " + (findSum(sc, n2) / n2));
                break;
            case 3:
                System.out.println("Enter number to check:");
                System.out.println(isPrime(sc.nextInt(), 2));
                break;
            case 4:
                System.out.println("Enter number:");
                System.out.println(factorial(sc.nextInt()));
                break;
            case 5:
                System.out.println("Enter n:");
                System.out.println(fibonacci(sc.nextInt()));
                break;
            case 6:
                System.out.println("Enter base 'a' and power 'n':");
                System.out.println(power(sc.nextInt(), sc.nextInt()));
                break;
            case 7:
                System.out.println("Enter count of numbers:");
                int n7 = sc.nextInt();
                reverseInput(sc, n7);
                break;
            case 8:
                System.out.println("Enter string:");
                System.out.println(isAllDigits(sc.next()));
                break;
            case 9:
                System.out.println("Enter string:");
                System.out.println(countChars(sc.next()));
                break;
            case 10:
                System.out.println("Enter two numbers:");
                System.out.println(gcd(sc.nextInt(), sc.nextInt()));
                break;
            default:
                System.out.println("Invalid Task Number.");
        }
    }

    /* --- Part 1. Recursion with Numbers --- */

    // Task 1: Print every digit on a separate line [cite: 25]
    public static void printDigits(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    // Task 2: Calculate sum recursively to find average [cite: 35]
    public static double findSum(Scanner sc, int n) {
        if (n == 0) return 0;
        int val = sc.nextInt();
        return val + findSum(sc, n - 1);
    }

    // Task 3: Check if number is prime [cite: 42]
    public static String isPrime(int n, int i) {
        if (n <= 1) return "Composite";
        if (n == 2) return "Prime";
        if (n % i == 0) return "Composite";
        if (i * i > n) return "Prime";
        return isPrime(n, i + 1);
    }

    // Task 4: Factorial n! [cite: 50]
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    /* --- Part 2. Recursion with Sequences --- */

    // Task 5: Fibonacci with Fn = Fn-1 + Fn-2, F0=0, F1=1 [cite: 60, 61]
    public static int fibonacci(int n) {
        if (n == 0) return 0; // Base case F0 = 0 [cite: 61]
        if (n == 1) return 1; // Base case F1 = 1 [cite: 61]
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive step [cite: 60]
    }

    // Task 6: Power function a^n [cite: 62]
    public static int power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    // Task 7: Reverse order without using another array [cite: 67]
    public static void reverseInput(Scanner sc, int n) {
        if (n == 0) return;
        int x = sc.nextInt();
        reverseInput(sc, n - 1);
        System.out.print(x + " ");
    }

    /* --- Part 3. Recursion with Strings --- */

    // Task 8: Check if string contains only digits [cite: 74, 75]
    public static String isAllDigits(String s) {
        if (s.isEmpty()) return "Yes";
        if (!Character.isDigit(s.charAt(0))) return "No";
        return isAllDigits(s.substring(1));
    }

    // Task 9: Count number of characters in a string [cite: 79, 80]
    public static int countChars(String s) {
        if (s.isEmpty()) return 0;
        return 1 + countChars(s.substring(1));
    }

    // Task 10: GCD using Euclidean Algorithm [cite: 88]
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}