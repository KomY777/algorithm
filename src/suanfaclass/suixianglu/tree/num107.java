package suanfaclass.suixianglu.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0,res);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = res.size()-1; i >=0 ; i--){
            ans.add(res.get(i));
        }
        return ans;
    }
    public void dfs(TreeNode root, int dep,List<List<Integer>> res){
        if (root==null)return;
        dep++;

        if (dep>res.size()){
            res.add(new ArrayList<>());
        }
        res.get(dep-1).add(root.val);
        dfs(root.left,dep,res);
        dfs(root.right,dep,res);
    }
}
