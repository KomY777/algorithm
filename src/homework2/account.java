package homework2;

import java.util.Scanner;

public class account {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        double total = 0;
        for (int i = 0; i < 12; i++) {
            double monthMoney = sc.nextDouble();
            total += monthMoney;
        }
        System.out.println("$"+(total/12));
    }
}
