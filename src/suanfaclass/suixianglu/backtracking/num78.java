package suanfaclass.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class num78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return res;
    }
    public void backtracking(int[] nums, int start){
        res.add(new ArrayList<>(path));
        for(int i =start;i<nums.length;i++){
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
