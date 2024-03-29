package homework2;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.sqrt;
import static java.lang.System.exit;

public class isPrime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=0,b=0;
        ArrayList isprime=new ArrayList<>();
        do {
             a=sc.nextInt();
             b=sc.nextInt();
             if (a!=0||b!=0) {
                 isprime.add(checknumber(a, b));
             }else {
                 break;
             }
    }while (true);
        for (int i=0;i< isprime.size();i++){
            if ((boolean) isprime.get(i)) {
            }else{
                System.out.println("Sorry");
                exit(0);
            }
        }
        System.out.println("OK");
    }
    public static boolean checknumber(int a, int b) {
        if (a < b && a >= -39 && b <= 50) {
            if (check(a)){
                if (check(b)){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
            return false;
    }
    public static boolean check(int n){
        int num=(n^2)+n+39;
        for (int i=2;i<sqrt(num);i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}
