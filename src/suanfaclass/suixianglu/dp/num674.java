package suanfaclass.suixianglu.dp;

import java.util.Arrays;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class num674 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2,3,4,5};
        System.out.println(findLengthOfLCIS(nums));
    }
    public static int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int res = 1;
        for (int i = 1; i<len;i++){
            if(nums[i]>nums[i-1])dp[i]=dp[i-1]+1;
            System.out.println(Arrays.toString(dp));
            if(dp[i]>res) res=dp[i];
        }
        return res;
    }
}
