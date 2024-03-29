package homework2;

import java.util.Arrays;
import java.util.Scanner;

public class primeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        System.out.println(primeNumber(scanner.nextInt()));
//        System.out.println(primeNumber2(scanner.nextInt()));
        System.out.println(countPrimes(scanner.nextInt()));
    }

    public static int primeNumber(int num) {
        char[] nums = new char[num];
        char[] prime = new char[num];
        int count = 0;
        for (int i = 2; i < num; i++) {
            if (nums[i] == 0) {
                prime[count++]= (char) i;
            }
            for (int j = 0; j < num && i * prime[j] < num; j++) {
                nums[i * prime[j]] = 1;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
        return count;
    }
//暴力算法
    public static int primeNumber2(int num) {
        int count = 0;
        boolean flag;//定义一个变量，若为合数，则该变量的值变为0
        for (int i = 2; i < num; i++) {
            flag = true;//先假定该数为素数
            for (int j = 2; j * j <= i; j++)
            {
                if (i % j == 0)//找到这个数的质因子
                {
                    flag = false;//flag==0说明这个数是合数
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
            return count;
    }
    public static int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;

    }
}