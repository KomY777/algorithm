package suanfaclass.suixianglu.dp;

public class baggage01 {
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int len = weight.length;
        int[][] dp = new int[len][len];
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 0; i < len; i++){
            for (int j=0;j<bagSize;j++){
                if (j<weight[i])dp[i][j]=dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
            }
        }
    }
}
