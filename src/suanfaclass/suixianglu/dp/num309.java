package suanfaclass.suixianglu.dp;

/**
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class num309 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<=1)return 0;
        int[][] dp = new int[len][2];
        dp[0][0]=-prices[0];
        dp[1][0]=Math.max(dp[0][0],-prices[1]);
        dp[1][1]=Math.max(0,dp[0][0]+prices[1]);
        for (int i =2; i< len; i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-2][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            System.out.println(dp[i][0]+" "+dp[i][1]);
        }
        return dp[len-1][1];
    }
}
