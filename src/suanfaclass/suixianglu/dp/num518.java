package suanfaclass.suixianglu.dp;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class num518 {
    public static void main(String[] args) {
        System.out.println(change(5,new int[]{1,2,5}));
    }
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
            for (int i = 0; i < coins.length; i++) {
        for (int j = 0; j <= amount; j++) {
                if (j < coins[i]) continue;
                dp[j] += dp[j - coins[i]];
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[amount];
    }

}
