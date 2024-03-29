package leetcode;

import leetcode.ListNode.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */

public class num235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            while (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            while (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            if (root == p || root == q){
                return root;
            }
            if (root.val > p.val && root.val < q.val) {
                return root;
            }
            if (root.val < p.val && root.val > q.val) {
                return root;
            }
        }
    }
}
