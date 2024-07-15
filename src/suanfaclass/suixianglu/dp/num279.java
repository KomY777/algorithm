package suanfaclass.suixianglu.dp;

import java.util.Arrays;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class num279 {
    public static void main(String[] args) {
                System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        for(int i =0;i<=n;i++){
            for(int j=i*i;j<=n;j++){
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
                System.out.println(" "+i+j);
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[n];
    }
}
