package suanfaclass.suixianglu.dp;

import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class num416 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    }
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        int[] dp = new int[sum+1];
        if(sum%2!=0)return false;
        sum/=2;
        for(int i=0;i<len;i++){
            for(int j=sum;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[sum]==sum;
    }
}
