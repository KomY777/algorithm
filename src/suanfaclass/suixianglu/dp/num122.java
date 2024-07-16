package suanfaclass.suixianglu.dp;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润
 */
public class num122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        for (int i =0; i<len;i++){
            for(int j=i;j<len;j++){
                dp[j][0]=Math.max(dp[j-1][0],dp[j-1][1]-prices[i]);
                dp[j][1]=Math.max(dp[j-1][1],dp[j-1][0]+prices[i]);
            }
        }
        return dp[len-1][1];
    }
}
