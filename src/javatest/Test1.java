package javatest;

import java.util.Scanner;

/**
 * @author kom
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个正整数m和n");
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int gcd = commonDivisor(m,n);
        int lcm = commonMultiple(m,n,gcd);
        System.out.println("最大公约数是：" + gcd);
        System.out.println("最小公倍数是：" + lcm);
    }
    public static int commonDivisor(int m, int n){
        while(n != 0){
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
    public static int commonMultiple(int m, int n, int gcd){
        return m * n / gcd;
    }
}
