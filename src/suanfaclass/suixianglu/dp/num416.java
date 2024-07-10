package suanfaclass.suixianglu.dp;

import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class num416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1)return false;
        int[] dp = new int[nums.length+1];
        dp[0]=sum/2;
        for (int i = 0; i < nums.length; i++){
            if (dp[i]==nums[i])return true;
            if (dp[i]<nums[i]){
                dp[i+1]=dp[i];
            }
            if (dp[i]>nums[i]){
                dp[i+1]=dp[i]-nums[i];
            }
        }
        return dp[nums.length]==0;
    }
}
