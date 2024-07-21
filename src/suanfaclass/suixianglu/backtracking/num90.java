package suanfaclass.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 */
public class num90 {
    List<List<Integer>> res  = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums,0,used);
        return res;
    }
    public void backtracking(int[] nums,int start,boolean[] used){
        res.add(new ArrayList<>(path));
        for(int i =start;i<nums.length;i++){
            if(i> 0&& nums[i]==nums[i-1]&& !used[i-1])continue;
            path.add(nums[i]);
            used[i]=true;
            backtracking(nums,i+1,used);
            used[i]=false;
            path.removeLast();
        }
    }
}
