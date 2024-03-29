package homework2;

import java.util.Scanner;

public class getLastInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(getnum(x,y));
    }
    public static int getnum(int x, int y){
        int result=1;
        while (y!=0){
            if (y%2==1) {
                result = (result * x) % 1000;
            }
            x=(x*x)%1000;
            y/=2;
        }
        return result;
    }
}
