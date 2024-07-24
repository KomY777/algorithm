package suanfaclass.suixianglu.tanxing;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组
 * 是数组中的一个连续部分。
 */
public class num53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count=0;
        for(int i = 0;i<nums.length;i++){
            count+=nums[i];
            if(count>res) res=count;
            if(count<0) count=0;
        }
        return res;
    }
}
