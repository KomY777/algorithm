package suanfaclass.suixianglu.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class num123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][4];
        dp[0][0]=-prices[0];
        dp[0][2]=-prices[0];
        for(int i =1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i][0]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]-prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]+prices[i]);
        }
        return dp[len-1][3];
    }
}
