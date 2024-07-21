package suanfaclass.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
public class num491 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {4,4,3,2,1};
        findSubsequences(nums);
        System.out.println(res);
    }
    public static List<List<Integer>> findSubsequences(int[] nums) {
        backtraking(nums,0);
        return res;
    }
    public static void backtraking(int[] nums,int start){
        for(int i = start;i<nums.length;i++){
            if(path.isEmpty() ||nums[i]>=path.getLast()){
                path.add(nums[i]);
                backtraking(nums,i+1);
                if(path.size()>1){
                    res.add(new ArrayList<>(path));
                }
                path.removeLast();
            }else{
                backtraking(nums,i+1);
            }

        }
    }
}
