package suanfaclass.suixianglu.dp;

import java.util.Arrays;


/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class num494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target)) return 0;
        int t = sum + target;
        if (t % 2 != 0) return 0;
        t/=2;
        int[] dp = new int[t + 1];
        dp[0] = 1;
        System.out.println(t);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            for (int j = t; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[t];
    }
}
