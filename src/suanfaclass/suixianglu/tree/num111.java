package suanfaclass.suixianglu.tree;

import java.util.Map;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */
public class num111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left==null){
            return right+1;
        }
        if (root.right==null){
            return left+1;
        }
        return Math.min(left,right)+1;
    }
}
