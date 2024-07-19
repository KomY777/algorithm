package suanfaclass.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 */
public class num40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtracing(candidates,target,0,0,used);
        return res;
    }
    public void backtracing(int[] candidates,int target,int start, int sum,boolean[] used){
        if(sum>target)return;
        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i =start;i<candidates.length;i++){
            if(i>0 && candidates[i-1]==candidates[i] && !used[i-1]){
                continue;
            }
            path.add(candidates[i]);
            sum+=candidates[i];
            used[i]=true;
            backtracing(candidates,target,i+1,sum,used);
            used[i]=false;
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
