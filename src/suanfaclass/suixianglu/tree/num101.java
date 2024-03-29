package suanfaclass.suixianglu.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class num101 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null)return true;
        return bfs(root.left,root.right);
    }

    public boolean bfs(TreeNode left,TreeNode right) {
        if (left==null&&right==null)return true;
        if (left == null ||right==null) return false;
        if (left.val!=right.val)return false;
        return bfs(left.left,right.right) &&bfs(left.right,right.left);
    }
}
