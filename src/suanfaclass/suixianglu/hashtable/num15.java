package suanfaclass.suixianglu.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 */
public class num15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for ( int left =0;left<len;left++) {
            if (nums[left] > 0) break;
            if (left > 0 && nums[left] == nums[left - 1]) continue;
            int current = left+1;
            int right = len - 1;
            while (current < right) {
                int sum = nums[left] + nums[current] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[current]);
                    list.add(nums[right]);
                    res.add(list);
                    while (nums[right - 1] == nums[right] && current < right) right--;
                    while (nums[current] == nums[current + 1] && current < right) current++;
                    current++;
                    right--;
                } else if (sum > 0) right--;
                else current++;
            }
        }
        return res;
    }
}
