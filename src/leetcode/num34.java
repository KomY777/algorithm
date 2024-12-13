package leetcode;
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
//如果数组中不存在目标值 target，返回 [-1, -1]。
//
//你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
public class num34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = right / 2;
        while (left <= right) {
           if(nums[mid]>target){
               right = mid - 1;
               mid  = (left + right)/2;
               continue;
           }
           if(nums[mid]<target){
               left = mid + 1;
               mid  = (right + left)/2;
           }
           if(nums[mid]==target){
               while(nums[left]!=target && left<mid)left++;
               while(nums[right]!=target && right>mid)right--;
               return new int[]{left,right};
           }
        }
        return new int[]{-1, -1};
    }
}
