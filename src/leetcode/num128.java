package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class num128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for (int num : nums) {
            map.add(num);
        }
        int max = 0;
        for (int num : map) {
            if (!map.contains(num - 1)) {
                int count = 1;
                int currentnum = num;
                while (map.contains(currentnum + 1)) {
                    count++;
                    currentnum++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
