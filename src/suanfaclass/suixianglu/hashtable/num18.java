package suanfaclass.suixianglu.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 */
public class num18 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        List<List<Integer>> list = fourSum(nums, target);
        System.out.println(list);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        int i = 0;
        while (i < len) {
            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return res;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                i++;// 对nums[i]去重
                continue;
            }
            int j = i + 1;
            while (j < len) {
                if (i + 1 < j && nums[j - 1] == nums[j]) {
                    j++;// 对nums[j]去重
                    continue;
                }
                int left = i + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right] + nums[j];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
                j++;
            }
            i++;
        }
        return res;
    }
}
