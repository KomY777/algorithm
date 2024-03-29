package suanfaclass.suixianglu.tree;

import java.util.ArrayList;
import java.util.List;

public class num102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(root,0,res);
        return res;
    }
    public void dfs(TreeNode root,int dep,List<List<Integer>> res){
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
