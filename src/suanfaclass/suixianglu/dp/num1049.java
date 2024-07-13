package suanfaclass.suixianglu.dp;

import java.util.Arrays;

public class num1049 {
    public static void main(String[] args) {
        int[] stones = {8, 2, 4, 4, 8};
        System.out.println(lastStoneWeightII(stones));
    }

    public static int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        if (sum % 2 == 0 && dp[target] == target) {
            return 0;
        }
        return Math.abs(sum - dp[target] * 2);
    }
}
