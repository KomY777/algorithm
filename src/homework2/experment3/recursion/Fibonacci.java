package homework2.experment3.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(40));
        System.out.println(fib(40,1,1));
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fib(int n, int first, int second) {
        if (n <= 1) {
            return first;
        } else {
            return fib(n - 1, second, first + second);
        }
    }
}

