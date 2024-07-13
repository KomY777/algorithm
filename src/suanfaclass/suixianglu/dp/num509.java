package suanfaclass.suixianglu.dp;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 */
public class num509 {
    public static void main(String[] args) {
        fib(2);
    }
    public static int fib(int n) {
        int i=0, j=1;
        for(int k=2;k<=n;k++){
            int sum =i+j;
            i=j;
            j=sum;
            System.out.println(j);
        }
        return j;
    }
}
