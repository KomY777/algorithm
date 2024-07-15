package suanfaclass.suixianglu.dp;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class num213 {
    public static void main(String[] args) {
                int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));
    }

    public static int rob2(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int len = nums.length;
        int[] dp = new int[len];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            System.out.println(Arrays.toString(dp));
        }
        return dp[end];
    }
}
