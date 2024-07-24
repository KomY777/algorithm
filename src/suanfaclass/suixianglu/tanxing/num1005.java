package suanfaclass.suixianglu.tanxing;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 */
public class num1005 {
    public static void main(String[] args) {
        int[] nums = {4,2,3};
        int k = 1;
        System.out.println(largestSumAfterKNegations(nums,k));
    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int res =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0 && k>0){
                k--;
                nums[i]=-nums[i];
            }
            System.out.println(k);
            res+=nums[i];
        }
        Arrays.sort(nums);
        if(k%2!=0)res-=2*nums[0];
        return res;
    }
}
