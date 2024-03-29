package suanfaclass.suixianglu.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class num257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    public void dfs(TreeNode root, String s, List<String> res) {
        if (root == null) return;
        String val = "";
        if (s.length() > 0){
            val = s + "->" + root.val;
        }else{
           val= String.valueOf(root.val);
        }
        if (root.left == null && root.right == null) {
                res.add(val);
        }

        dfs(root.left, val, res);
        dfs(root.right, val, res);
    }
}
