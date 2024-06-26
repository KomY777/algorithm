package leetcode;


import leetcode.ListNode.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class num938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root== null){
            return 0;
        }
        if (root.val >high){
           return rangeSumBST(root.left,low,high);
        }
        if (root.val< low){
           return rangeSumBST(root.right,low,high);
        }
        return root.val +rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }
}




