package suanfaclass.suixianglu.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 */
public class num637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        dfs(root,0,list);
        for (List<Integer> item : list){
            long sum = 0L;
            for (int i : item){
                sum+=i;
            }
            res.add((double)sum/item.size());
        }
        return res;
    }
    public void dfs(TreeNode root,int dep, List<List<Integer>> list){
        if (root==null)return;
        dep++;
        if (dep>list.size()){
            list.add(new ArrayList<>());
        }
        list.get(dep-1).add(root.val);
        dfs(root.left,dep,list);
        dfs(root.right,dep,list);
    }
}
