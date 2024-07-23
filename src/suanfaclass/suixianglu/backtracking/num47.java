package suanfaclass.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class num47 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return res;
    }
    public void backtracking(int[] nums,boolean[] used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i<nums.length;i++){
            if(i>0 &&nums[i-1]==nums[i] &&used[i-1])continue;
            used[i]=true;
            path.add(nums[i]);
            backtracking(nums,used);
            path.removeLast();
            used[i]=false;
        }
    }
}
