package suanfaclass.suixianglu.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class num515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    public void dfs(TreeNode root, int dep, List<Integer> res) {
        if (root == null) return;
        dep++;
        if (dep>res.size()){
            res.add(root.val);
        }
        res.set(dep - 1, Math.max(res.get(dep-1), root.val));
        dfs(root.right, dep, res);
        dfs(root.left, dep, res);
    }
}
