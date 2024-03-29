package homework2.experment3.recursion;

public class Staircase {
    public static void main(String[] args) {
        System.out.println(result(3));
    }

    public static int result(int n) {
        if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }else if (n<1){
            return 0;
        }
        return result(n-1)+result(n-2);
    }
}
